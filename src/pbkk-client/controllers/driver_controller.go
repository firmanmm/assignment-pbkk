package controllers

import (
	"fmt"
	"pbkk-client/data"
	"pbkk-client/models"
	"strconv"
)

type DriverController struct {
	AuthenticatedController
}

func (c *DriverController) Register() {
	c.TplName = "driver/form.html"
	c.TplExt = ".html"
}

func (c *DriverController) DoRegister() {
	driverModel := new(models.DriverModel)
	driver := new(data.DriverData)
	err := c.ParseForm(driver)
	if err != nil {
		c.Data["error"] = err.Error()
	}
	_, err = driverModel.Save(driver, c.Auth)
	if err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Berhasil memasukkan data"
	}
	c.Register()
}

func (c *DriverController) Delete() {
	idString := c.Ctx.Input.Param(":id")
	id, _ := strconv.Atoi(idString)
	driverModel := new(models.DriverModel)
	if err := driverModel.Delete(id, c.Auth); err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Behasil menandai penghapusan!"
	}
	c.Update()
}

func (c *DriverController) Update() {
	idString := c.Ctx.Input.Param(":id")
	id, _ := strconv.Atoi(idString)
	driverModel := new(models.DriverModel)
	driver, err := driverModel.GetById(id, c.Auth)
	if err != nil {
		c.Data["error"] = err
	}
	c.Data["data"] = driver
	c.TplName = "driver/form.html"
	c.TplExt = ".html"
}

func (c *DriverController) DoUpdate() {
	driverModel := new(models.DriverModel)
	driver := new(data.DriverData)
	err := c.ParseForm(driver)
	if err != nil {
		c.Data["error"] = err.Error()
	}
	_, err = driverModel.Save(driver, c.Auth)
	if err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Berhasil mengupdate data"
	}
	c.Update()
}

func (c *DriverController) List() {
	driverModel := new(models.DriverModel)
	drivers, err := driverModel.GetAll(c.Auth)
	if err != nil {
		fmt.Println(err)
		c.Data["error"] = err.Error()
	}
	c.Data["datas"] = drivers
	c.TplName = "driver/list.html"
	c.TplExt = ".html"

}
