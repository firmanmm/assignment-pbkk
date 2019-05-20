package models

import (
	"errors"
	"net/http"
	"pbkk-client/data"
	"strconv"

	"github.com/go-resty/resty"
	jsoniter "github.com/json-iterator/go"
)

type ClientModel struct {
	BaseModel
}

func (c *ClientModel) GetById(id int, authToken *data.AuthData) (*data.ClientData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	idString := strconv.Itoa(id)
	response, err := request.Get(c.GetBaseURL() + "/clients/" + idString)
	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	client := new(data.ClientData)
	jsoniter.Unmarshal(body, &client)
	return client, nil
}

func (c *ClientModel) GetAll(authToken *data.AuthData) ([]*data.ClientData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	response, err := request.Get(c.GetBaseURL() + "/clients")
	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	var clients []*data.ClientData
	if err := jsoniter.Unmarshal(body, &clients); err != nil {
		return nil, err
	}
	return clients, nil
}

func (c *ClientModel) Save(client *data.ClientData, authToken *data.AuthData) (*data.ClientData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	var response *resty.Response
	var err error
	formData := c.GenerateFormBody(client)
	request.SetFormData(formData)
	if client.Id != 0 {
		response, err = request.Post(c.GetBaseURL() + "/clients")
	} else {
		idString := strconv.Itoa(client.Id)
		response, err = request.Put(c.GetBaseURL() + "/clients/" + idString)
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
	newClient := new(data.ClientData)
	jsoniter.Unmarshal(body, &newClient)
	return newClient, nil
}

func (c *ClientModel) Delete(id int, authToken *data.AuthData) error {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	idString := strconv.Itoa(id)
	response, err := request.Delete(c.GetBaseURL() + "/clients/" + idString)
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

func (c *ClientModel) GenerateFormBody(client *data.ClientData) map[string]string {
	formData := map[string]string{
		"id":          strconv.Itoa(client.Id),
		"identifier":  client.Identifier,
		"password":    client.Password,
		"authorities": client.Authorities,
		"scopes":      client.Scopes,
	}
	return formData
}
