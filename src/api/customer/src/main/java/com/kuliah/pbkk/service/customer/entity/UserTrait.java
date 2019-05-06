package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class UserTrait extends Data {
	@Column(name="no_identitas", nullable=false)
	private String noIdentitas;
	private String nama;
	private String alamat;
	@Column(name="no_handphone", nullable=false)
	private String noHandphone;
	private String email;
	@JsonIgnore
	private byte[] password;
	private Boolean isActivated;
	public String getNoIdentitas() {
		return noIdentitas;
	}
	public void setNoIdentitas(String noIdentitas) {
		this.noIdentitas = noIdentitas;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNoHandphone() {
		return noHandphone;
	}
	public void setNoHandphone(String noHandphone) {
		this.noHandphone = noHandphone;
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
	
	
}
