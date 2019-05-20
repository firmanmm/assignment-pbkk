package data

import "time"

type Data struct {
	Id        int       `json:"id" form:"id"`
	CreatedAt time.Time `json:"created_at" form:"created_at"`
	DeletedAt time.Time `json:"deleted_at"`
	UpdatedAt time.Time `json:"updated_at"`
}
