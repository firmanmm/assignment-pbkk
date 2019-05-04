package com.kuliah.pbkk.service.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User extends Data{
	private String noIdentitas;
	private String name;
	private String alamat;
	private String handphone;
	private String email;
	@JsonIgnore
	private byte[] password;
	private Boolean isActivated;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getHandphone() {
		return handphone;
	}
	public void setHandphone(String handphone) {
		this.handphone = handphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public Boolean getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}
	public String getNoIdentitas() {
		return noIdentitas;
	}
	public void setNoIdentitas(String noIdentitas) {
		this.noIdentitas = noIdentitas;
	}
}
