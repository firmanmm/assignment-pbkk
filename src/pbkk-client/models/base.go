package models

import (
	"github.com/astaxie/beego"
)

type BaseModel struct {
	BaseURL string
}

func (b *BaseModel) GetBaseURL() string {
	if len(b.BaseURL) == 0 {
		b.BaseURL = beego.AppConfig.String("BaseUrl")
	}
	return b.BaseURL
}
