package data

type DriverData struct {
	UserData
	IsApproved     bool   `json:"is_approved" form:"is_approved"`
	JenisKendaraan string `json:"jenis_kendaraan" form:"jenis_kendaraan"`
	NoPolisi       string `json:"no_polisi" form:"no_polisi"`
}
