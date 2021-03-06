package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuliah.pbkk.service.customer.exception.BadRequestException;
import com.kuliah.pbkk.service.customer.utility.RegExpPattern;

@MappedSuperclass
public abstract class UserTrait extends IdentityTrait {
	@Column(name="no_identitas", nullable=false)
	private String noIdentitas;
	private String nama;
	private String alamat;
	@Column(name="no_handphone", nullable=false)
	private String noHandphone;
	private String email;
	
	private Boolean isActivated;
	
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
	public String getNoIdentitas() {
		return noIdentitas;
	}
	public void setNoIdentitas(String noIdentitas) {
		this.noIdentitas = noIdentitas;
	}
	public Boolean getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	@Override
	public void validate() {
		super.validate();
		if(noIdentitas != null && noIdentitas.length() > 0) {
			if(!noIdentitas.matches(RegExpPattern.numeric) && noIdentitas.length() != 14) {
				throw new BadRequestException("Not a valid noIdentity! Expected in numeric format with length == 14");
			}
		}
		
		if((email != null && email.length() > 0)) {
			if(!email.matches(RegExpPattern.email)) {
				throw new BadRequestException("Email is not an valid email!");
			}
		}
		
		if((nama != null && nama.length() > 0)) {
			if(!nama.matches(RegExpPattern.name)){
				throw new BadRequestException("Not a valid name!");

			}
		}
		
		if(noHandphone != null && noHandphone.length() > 0) {
			if(noHandphone.length() > 14 || noHandphone.length() < 10) {
				throw new BadRequestException("Handphone number is invalid! Min 10, Max 14");
			}
		}
	}
	
	
}
