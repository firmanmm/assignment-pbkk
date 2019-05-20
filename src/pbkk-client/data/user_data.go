package data

type UserData struct {
	IdentifierData
	Alamat      string `json:"alamat" form:"alamat" `
	Email       string `json:"email" form:"email"`
	IsActivated bool   `json:"is_activated" form:"is_activated"`
	Nama        string `json:"nama" form:"nama"`
	NoHandphone string `json:"no_handphone" form:"no_handphone"`
	NoIdentitas string `json:"no_identitas" form:"no_identitas"`
}
