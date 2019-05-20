package controllers

type HomeController struct {
	AuthenticatedController
}

func (h *HomeController) Index() {
	h.TplName = "home.html"
	h.TplExt = ".html"
}

func (h *HomeController) Register() {
	h.TplName = "daftar.html"
	h.TplExt = ".html"
}

func (h *HomeController) List() {
	h.TplName = "list.html"
	h.TplExt = ".html"
}
