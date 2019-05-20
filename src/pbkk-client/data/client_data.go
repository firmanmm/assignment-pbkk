package data

type ClientData struct {
	IdentifierData
	Authorities string `json:"authorities" form:"authorities"`
	Scopes      string `json:"scopes" form:"scopes"`
}
