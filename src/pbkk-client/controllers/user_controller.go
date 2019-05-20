package controllers

import (
	"fmt"
	"pbkk-client/data"
	"pbkk-client/models"
	"strconv"
)

type UserController struct {
	AuthenticatedController
}

func (c *UserController) Register() {
	c.TplName = "user/form.html"
	c.TplExt = ".html"
}

func (c *UserController) DoRegister() {
	userModel := new(models.UserModel)
	user := new(data.UserData)
	err := c.ParseForm(user)
	if err != nil {
		c.Data["error"] = err.Error()
	}
	_, err = userModel.Save(user, c.Auth)
	if err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Berhasil memasukkan data"
	}
	c.Register()
}

func (c *UserController) Delete() {
	idString := c.Ctx.Input.Param(":id")
	id, _ := strconv.Atoi(idString)
	userModel := new(models.UserModel)
	if err := userModel.Delete(id, c.Auth); err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Behasil menandai penghapusan!"
	}
	c.Update()
}

func (c *UserController) Update() {
	idString := c.Ctx.Input.Param(":id")
	id, _ := strconv.Atoi(idString)
	userModel := new(models.UserModel)
	user, err := userModel.GetById(id, c.Auth)
	if err != nil {
		c.Data["error"] = err
	}
	c.Data["data"] = user
	c.TplName = "user/form.html"
	c.TplExt = ".html"
}

func (c *UserController) DoUpdate() {
	userModel := new(models.UserModel)
	user := new(data.UserData)
	err := c.ParseForm(user)
	if err != nil {
		c.Data["error"] = err.Error()
	}
	_, err = userModel.Save(user, c.Auth)
	if err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Berhasil mengupdate data"
	}
	c.Update()
}

func (c *UserController) List() {
	userModel := new(models.UserModel)
	users, err := userModel.GetAll(c.Auth)
	if err != nil {
		fmt.Println(err)
		c.Data["error"] = err.Error()
	}
	c.Data["datas"] = users
	c.TplName = "user/list.html"
	c.TplExt = ".html"

}
