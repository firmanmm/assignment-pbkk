package controllers

import (
	"net/http"
	"pbkk-client/models"

	"github.com/astaxie/beego"
)

type AuthController struct {
	beego.Controller
}

func (a *AuthController) Login() {
	a.TplName = "login.html"
	a.TplExt = ".html"
}

func (a *AuthController) DoLogin() {
	clientId := a.GetString("clientId")
	clientSecret := a.GetString("clientSecret")
	username := a.GetString("username")
	password := a.GetString("password")
	authModel := new(models.AuthModel)
	authToken, err := authModel.RequestAccessKey(clientId, clientSecret, username, password)
	if err != nil {
		a.Data["error"] = err
	} else {
		a.SetSession("auth", authToken)
		a.Redirect("/home", http.StatusFound)
	}
	a.Login()
}

func (a *AuthController) Logout() {
	a.DestroySession()
}
