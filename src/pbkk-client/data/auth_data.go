package data

import (
	"strings"
)

type AuthData struct {
	AccessToken  string
	Scope        []string
	RefreshToken string
	UserType     string
	Sub          int
}

func NewAuthData(accessToken, scope, refreshToken, userType string, sub int) *AuthData {
	authData := new(AuthData)
	authData.AccessToken = accessToken
	authData.RefreshToken = refreshToken
	authData.Scope = strings.Split(scope, " ")
	authData.UserType = userType
	authData.Sub = sub
	return authData
}
