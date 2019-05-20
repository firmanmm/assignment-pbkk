package data

type IdentifierData struct {
	Data
	Identifier string `json:"identifier" form:"identifier"`
	Password   string `json:"password" form:"password"`
}
