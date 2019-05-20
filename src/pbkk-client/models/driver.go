package models

import (
	"errors"
	"net/http"
	"pbkk-client/data"
	"strconv"

	"github.com/go-resty/resty"
	jsoniter "github.com/json-iterator/go"
)

type DriverModel struct {
	BaseModel
}

func (c *DriverModel) GetById(id int, authToken *data.AuthData) (*data.DriverData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	idString := strconv.Itoa(id)
	response, err := request.Get(c.GetBaseURL() + "/drivers/" + idString)
	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	Driver := new(data.DriverData)
	jsoniter.Unmarshal(body, &Driver)
	return Driver, nil
}

func (c *DriverModel) GetAll(authToken *data.AuthData) ([]*data.DriverData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	response, err := request.Get(c.GetBaseURL() + "/drivers")
	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	var Drivers []*data.DriverData
	if err := jsoniter.Unmarshal(body, &Drivers); err != nil {
		return nil, err
	}
	return Drivers, nil
}

func (c *DriverModel) Save(Driver *data.DriverData, authToken *data.AuthData) (*data.DriverData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	var response *resty.Response
	var err error
	formData := c.GenerateFormBody(Driver)
	request.SetFormData(formData)
	if Driver.Id != 0 {
		response, err = request.Post(c.GetBaseURL() + "/drivers")
	} else {
		idString := strconv.Itoa(Driver.Id)
		response, err = request.Put(c.GetBaseURL() + "/drivers/" + idString)
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
	newDriver := new(data.DriverData)
	jsoniter.Unmarshal(body, &newDriver)
	return newDriver, nil
}

func (c *DriverModel) Delete(id int, authToken *data.AuthData) error {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	idString := strconv.Itoa(id)
	response, err := request.Delete(c.GetBaseURL() + "/drivers/" + idString)
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

func (c *DriverModel) GenerateFormBody(Driver *data.DriverData) map[string]string {
	formData := map[string]string{
		"id":             strconv.Itoa(Driver.Id),
		"identifier":     Driver.Identifier,
		"password":       Driver.Password,
		"alamat":         Driver.Alamat,
		"email":          Driver.Email,
		"nama":           Driver.Nama,
		"noHandphone":    Driver.NoHandphone,
		"noIdentitas":    Driver.NoIdentitas,
		"isActivated":    "true",
		"jenisKendaraan": Driver.JenisKendaraan,
		"noPolisi":       Driver.NoPolisi,
	}
	return formData
}
