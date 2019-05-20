package models

import (
	"errors"
	"net/http"
	"pbkk-client/data"
	"strconv"

	"github.com/go-resty/resty"
	jsoniter "github.com/json-iterator/go"
)

type UserModel struct {
	BaseModel
}

func (c *UserModel) GetById(id int, authToken *data.AuthData) (*data.UserData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	idString := strconv.Itoa(id)
	response, err := request.Get(c.GetBaseURL() + "/users/" + idString)
	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	User := new(data.UserData)
	jsoniter.Unmarshal(body, &User)
	return User, nil
}

func (c *UserModel) GetAll(authToken *data.AuthData) ([]*data.UserData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	response, err := request.Get(c.GetBaseURL() + "/users")
	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	var Users []*data.UserData
	if err := jsoniter.Unmarshal(body, &Users); err != nil {
		return nil, err
	}
	return Users, nil
}

func (c *UserModel) Save(User *data.UserData, authToken *data.AuthData) (*data.UserData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	var response *resty.Response
	var err error
	formData := c.GenerateFormBody(User)
	request.SetFormData(formData)
	if User.Id != 0 {
		response, err = request.Post(c.GetBaseURL() + "/users")
	} else {
		idString := strconv.Itoa(User.Id)
		response, err = request.Put(c.GetBaseURL() + "/users/" + idString)
	}

	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	newUser := new(data.UserData)
	jsoniter.Unmarshal(body, &newUser)
	return newUser, nil
}

func (c *UserModel) Delete(id int, authToken *data.AuthData) error {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	idString := strconv.Itoa(id)
	response, err := request.Delete(c.GetBaseURL() + "/users/" + idString)
	if err != nil {
		return err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return errors.New(errorData["message"].(string))
	}
	return nil
}

func (c *UserModel) GenerateFormBody(User *data.UserData) map[string]string {
	formData := map[string]string{
		"id":          strconv.Itoa(User.Id),
		"identifier":  User.Identifier,
		"password":    User.Password,
		"alamat":      User.Alamat,
		"email":       User.Email,
		"nama":        User.Nama,
		"noHandphone": User.NoHandphone,
		"noIdentitas": User.NoIdentitas,
		"isActivated": "true",
	}
	return formData
}
