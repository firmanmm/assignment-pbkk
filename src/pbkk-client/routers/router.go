package routers

import (
	"pbkk-client/controllers"

	"github.com/astaxie/beego"
)

func init() {
	beego.Router("/login", &controllers.AuthController{}, "get:Login;post:DoLogin")
	beego.Router("/logout", &controllers.AuthController{}, "get:Logout")
	beego.Router("/home", &controllers.HomeController{}, "get:Index")
	beego.Router("/register", &controllers.HomeController{}, "get:Register")
	beego.Router("/list", &controllers.HomeController{}, "get:List")
	beego.Router("/check-token", &controllers.AccessController{}, "get:CheckId;post:DoCheckId")
	beego.Router("/validate", &controllers.AccessController{}, "get:Validate;post:DoValidate")

	beego.Router("/client/register", &controllers.ClientController{}, "get:Register;post:DoRegister")
	beego.Router("/client/update/:id", &controllers.ClientController{}, "get:Update;post:DoUpdate")
	beego.Router("/client/delete/:id", &controllers.ClientController{}, "get:Delete")
	beego.Router("/client/list", &controllers.ClientController{}, "get:List")

	beego.Router("/user/register", &controllers.UserController{}, "get:Register;post:DoRegister")
	beego.Router("/user/update/:id", &controllers.UserController{}, "get:Update;post:DoUpdate")
	beego.Router("/user/delete/:id", &controllers.UserController{}, "get:Delete")
	beego.Router("/user/list", &controllers.UserController{}, "get:List")

	beego.Router("/driver/register", &controllers.DriverController{}, "get:Register;post:DoRegister")
	beego.Router("/driver/update/:id", &controllers.DriverController{}, "get:Update;post:DoUpdate")
	beego.Router("/driver/delete/:id", &controllers.DriverController{}, "get:Delete")
	beego.Router("/driver/list", &controllers.DriverController{}, "get:List")

	beego.Router("/resto/register", &controllers.RestaurantController{}, "get:Register;post:DoRegister")
	beego.Router("/resto/update/:id", &controllers.RestaurantController{}, "get:Update;post:DoUpdate")
	beego.Router("/resto/delete/:id", &controllers.RestaurantController{}, "get:Delete")
	beego.Router("/resto/list", &controllers.RestaurantController{}, "get:List")

	beego.Router("/", &controllers.MainController{})
}
