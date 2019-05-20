package controllers

import (
	"net/http"
	"pbkk-client/data"

	"github.com/astaxie/beego"
)

type MainController struct {
	Auth *data.AuthData
	beego.Controller
}

func (c *MainController) Prepare() {
	if !c.isLogin() {
		accessKey := beego.AppConfig.String("AccessKey")
		if len(accessKey) > 0 {
			authData := data.NewAuthData(accessKey, "", "", "", 1)
			c.Auth = authData
		} else {
			c.Redirect("/login", http.StatusFound)
		}
	}
	c.Data["auth"] = c.Auth
}

func (c *MainController) isLogin() bool {
	if c.Auth == nil {
		raw := c.GetSession("auth")
		if raw != nil {
			c.Auth = raw.(*data.AuthData)
		}
	}
	return c.Auth != nil
}

func (c *MainController) Get() {
	c.Redirect("/home", http.StatusFound)
}
