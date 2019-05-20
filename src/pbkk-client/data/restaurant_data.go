package data

type RestaurantData struct {
	IdentifierData
	OwnerId int `form:"owner_id"`
	User *UserData `json:"pemilik"`
	Alamat string `json:"alamat" form:"alamat"`
	Deskripsi string `json:"deskripsi" form:"deskripsi"`
	IsPremium bool `json:"is_premium" form:"is_premium"`
	Nama string `json:"nama" form:"nama"`
}