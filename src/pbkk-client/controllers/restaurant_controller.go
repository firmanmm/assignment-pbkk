package controllers

import (
	"fmt"
	"pbkk-client/data"
	"pbkk-client/models"
	"strconv"
)

type RestaurantController struct {
	AuthenticatedController
}

func (c *RestaurantController) Register() {
	c.TplName = "restaurant/form.html"
	c.TplExt = ".html"
}

func (c *RestaurantController) DoRegister() {
	restaurantModel := new(models.RestaurantModel)
	restaurant := new(data.RestaurantData)
	err := c.ParseForm(restaurant)
	if err != nil {
		c.Data["error"] = err.Error()
	}
	_, err = restaurantModel.Save(restaurant, c.Auth)
	if err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Berhasil memasukkan data"
	}
	c.Register()
}

func (c *RestaurantController) Delete() {
	idString := c.Ctx.Input.Param(":id")
	id, _ := strconv.Atoi(idString)
	restaurantModel := new(models.RestaurantModel)
	if err := restaurantModel.Delete(id, c.Auth); err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Behasil menandai penghapusan!"
	}
	c.Update()
}

func (c *RestaurantController) Update() {
	idString := c.Ctx.Input.Param(":id")
	id, _ := strconv.Atoi(idString)
	restaurantModel := new(models.RestaurantModel)
	restaurant, err := restaurantModel.GetById(id, c.Auth)
	if err != nil {
		c.Data["error"] = err
	}
	c.Data["data"] = restaurant
	c.TplName = "restaurant/form.html"
	c.TplExt = ".html"
}

func (c *RestaurantController) DoUpdate() {
	restaurantModel := new(models.RestaurantModel)
	restaurant := new(data.RestaurantData)
	err := c.ParseForm(restaurant)
	if err != nil {
		c.Data["error"] = err.Error()
	}
	_, err = restaurantModel.Save(restaurant, c.Auth)
	if err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Berhasil mengupdate data"
	}
	c.Update()
}

func (c *RestaurantController) List() {
	restaurantModel := new(models.RestaurantModel)
	restaurants, err := restaurantModel.GetAll(c.Auth)
	if err != nil {
		fmt.Println(err)
		c.Data["error"] = err.Error()
	}
	c.Data["datas"] = restaurants
	c.TplName = "restaurant/list.html"
	c.TplExt = ".html"

}
