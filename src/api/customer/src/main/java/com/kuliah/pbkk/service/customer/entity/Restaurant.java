package com.kuliah.pbkk.service.customer.entity;

public class Restaurant extends Data {
	private User pemilik;
	private String nama;
	private String deskripsi;
	private String alamat;
	private Boolean isPremium;
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public Boolean getIsPremium() {
		return isPremium;
	}
	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}
	public User getPemilik() {
		return pemilik;
	}
	public void setPemilik(User pemilik) {
		this.pemilik = pemilik;
	}
}
