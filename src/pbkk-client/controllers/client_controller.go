package controllers

import (
	"fmt"
	"pbkk-client/data"
	"pbkk-client/models"
	"strconv"
)

type ClientController struct {
	AuthenticatedController
}

func (c *ClientController) Register() {
	c.TplName = "client/form.html"
	c.TplExt = ".html"
}

func (c *ClientController) DoRegister() {
	clientModel := new(models.ClientModel)
	client := new(data.ClientData)
	err := c.ParseForm(client)
	if err != nil {
		c.Data["error"] = err.Error()
	}
	_, err = clientModel.Save(client, c.Auth)
	if err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Berhasil memasukkan data"
	}
	c.Register()
}

func (c *ClientController) Delete() {
	idString := c.Ctx.Input.Param(":id")
	id, _ := strconv.Atoi(idString)
	clientModel := new(models.ClientModel)
	if err := clientModel.Delete(id, c.Auth); err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Behasil menandai penghapusan!"
	}
	c.Update()
}

func (c *ClientController) Update() {
	idString := c.Ctx.Input.Param(":id")
	id, _ := strconv.Atoi(idString)
	clientModel := new(models.ClientModel)
	client, err := clientModel.GetById(id, c.Auth)
	if err != nil {
		c.Data["error"] = err
	}
	c.Data["data"] = client
	c.TplName = "client/form.html"
	c.TplExt = ".html"
}

func (c *ClientController) DoUpdate() {
	clientModel := new(models.ClientModel)
	client := new(data.ClientData)
	err := c.ParseForm(client)
	if err != nil {
		c.Data["error"] = err.Error()
	}
	_, err = clientModel.Save(client, c.Auth)
	if err != nil {
		c.Data["error"] = err.Error()
	} else {
		c.Data["success"] = "Berhasil mengupdate data"
	}
	c.Update()
}

func (c *ClientController) List() {
	clientModel := new(models.ClientModel)
	clients, err := clientModel.GetAll(c.Auth)
	if err != nil {
		fmt.Println(err)
		c.Data["error"] = err.Error()
	}
	c.Data["clients"] = clients
	c.TplName = "client/list.html"
	c.TplExt = ".html"

}
