package com.kuliah.pbkk.service.customer.entity;

public class Driver extends User {
	private String noPolisi;
	private String jenisKendaraan;
	private Boolean isApproved;
	
	public String getNoPolisi() {
		return noPolisi;
	}
	public void setNoPolisi(String noPolisi) {
		this.noPolisi = noPolisi;
	}
	public String getJenisKendaraan() {
		return jenisKendaraan;
	}
	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
}
