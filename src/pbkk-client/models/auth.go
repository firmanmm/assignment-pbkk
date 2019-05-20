package models

import (
	"errors"
	"net/http"
	"pbkk-client/data"

	jsoniter "github.com/json-iterator/go"

	"github.com/go-http-utils/headers"
	"github.com/go-resty/resty"
)

type AuthModel struct {
	BaseModel
}

func (a *AuthModel) RequestAccessKey(clientId, clientSecret, username, password string) (*data.AuthData, error) {
	client := resty.New()
	request := client.R()
	request = request.SetBasicAuth(clientId, clientSecret)
	request = request.SetHeader(headers.ContentType, "application/json")
	formData := map[string]string{
		"username":   username,
		"password":   password,
		"grant_type": "password",
	}
	request = request.SetFormData(formData)
	response, err := request.Post(a.GetBaseURL() + "/oauth/token")
	if err != nil {
		return nil, err
	}
	mappedData := make(map[string]interface{})
	jsoniter.Unmarshal(response.Body(), &mappedData)
	if response.StatusCode() != http.StatusOK {
		return nil, errors.New(mappedData["error"].(string))
	}
	accessToken := mappedData["access_token"].(string)
	refreshToken := mappedData["refresh_token"].(string)
	scopes := mappedData["scope"].(string)
	userType := mappedData["user_type"].(string)
	sub := mappedData["sub"].(float64)
	authToken := data.NewAuthData(accessToken, scopes, refreshToken, userType, int(sub))
	return authToken, nil
}

func (a *AuthModel) Validate(key string, authToken *data.AuthData) error {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	formData := make(map[string]string)
	formData["token"] = key
	request.SetFormData(formData)
	response, _ := request.Post(a.GetBaseURL() + "/oauth/check_token")
	if response.StatusCode() != http.StatusOK {
		return errors.New("Validation Failed")
	}
	return nil
}
