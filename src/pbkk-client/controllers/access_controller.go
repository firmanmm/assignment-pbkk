package controllers

import "pbkk-client/models"

type AccessController struct {
	AuthenticatedController
}

func (a *AccessController) CheckId() {
	a.TplName = "other/access.html"
	a.TplExt = ".html"
}

func (a *AccessController) DoCheckId() {
	clientId := a.GetString("clientId")
	clientSecret := a.GetString("clientSecret")
	username := a.GetString("username")
	password := a.GetString("password")
	authModel := new(models.AuthModel)
	authToken, err := authModel.RequestAccessKey(clientId, clientSecret, username, password)
	if err != nil {
		a.Data["error"] = err
	} else {
		a.Data["success"] = authToken.AccessToken
	}
	a.CheckId()
}

func (a *AccessController) Validate() {
	a.TplName = "other/validate.html"
	a.TplExt = ".html"
}

func (a *AccessController) DoValidate() {
	accessKey := a.GetString("access_key")
	authModel := new(models.AuthModel)
	err := authModel.Validate(accessKey, a.Auth)
	if err != nil {
		a.Data["error"] = err
	} else {
		a.Data["success"] = "Token Valid"
	}
	a.CheckId()
}
