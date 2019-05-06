package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@MappedSuperclass
@Table(name="users")
public class User extends Data{
	private String noIdentitas;
	private String nama;
	private String alamat;
	private String noHandphone;
	private String email;
	@JsonIgnore
	private byte[] password;
	private Boolean isActivated;
	
	public String getName() {
		return nama;
	}
	public void setName(String name) {
		this.nama = name;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
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
	public String getNoHandphone() {
		return noHandphone;
	}
	public void setNoHandphone(String noHandphone) {
		this.noHandphone = noHandphone;
	}
}
