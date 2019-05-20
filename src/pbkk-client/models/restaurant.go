package models

import (
	"errors"
	"net/http"
	"pbkk-client/data"
	"strconv"

	"github.com/go-resty/resty"
	jsoniter "github.com/json-iterator/go"
)

type RestaurantModel struct {
	BaseModel
}

func (c *RestaurantModel) GetById(id int, authToken *data.AuthData) (*data.RestaurantData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	idString := strconv.Itoa(id)
	response, err := request.Get(c.GetBaseURL() + "/restaurants/" + idString)
	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	Restaurant := new(data.RestaurantData)
	jsoniter.Unmarshal(body, &Restaurant)
	return Restaurant, nil
}

func (c *RestaurantModel) GetAll(authToken *data.AuthData) ([]*data.RestaurantData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	response, err := request.Get(c.GetBaseURL() + "/restaurants")
	if err != nil {
		return nil, err
	}
	body := response.Body()
	if response.StatusCode() != http.StatusOK {
		errorData := make(map[string]interface{})
		jsoniter.Unmarshal(body, &errorData)
		return nil, errors.New(errorData["message"].(string))
	}
	var Restaurants []*data.RestaurantData
	if err := jsoniter.Unmarshal(body, &Restaurants); err != nil {
		return nil, err
	}
	return Restaurants, nil
}

func (c *RestaurantModel) Save(Restaurant *data.RestaurantData, authToken *data.AuthData) (*data.RestaurantData, error) {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	var response *resty.Response
	var err error
	formData := c.GenerateFormBody(Restaurant)
	request.SetFormData(formData)
	if Restaurant.Id != 0 {
		response, err = request.Post(c.GetBaseURL() + "/restaurants")
	} else {
		idString := strconv.Itoa(Restaurant.Id)
		response, err = request.Put(c.GetBaseURL() + "/restaurants/" + idString)
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
	newRestaurant := new(data.RestaurantData)
	jsoniter.Unmarshal(body, &newRestaurant)
	return newRestaurant, nil
}

func (c *RestaurantModel) Delete(id int, authToken *data.AuthData) error {
	request := resty.R()
	request.SetAuthToken(authToken.AccessToken)
	idString := strconv.Itoa(id)
	response, err := request.Delete(c.GetBaseURL() + "/restaurants/" + idString)
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

func (c *RestaurantModel) GenerateFormBody(Restaurant *data.RestaurantData) map[string]string {
	formData := map[string]string{
		"id":         strconv.Itoa(Restaurant.Id),
		"identifier": Restaurant.Identifier,
		"password":   Restaurant.Password,
		"alamat":     Restaurant.Alamat,
		"nama":       Restaurant.Nama,
		"deskripsi":  Restaurant.Deskripsi,
		"isPremium":  "true",
		"userId":     strconv.Itoa(Restaurant.OwnerId),
	}
	return formData
}
