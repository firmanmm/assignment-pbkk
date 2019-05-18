package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuliah.pbkk.service.customer.exception.BadRequestException;
import com.kuliah.pbkk.service.customer.utility.BCryptEncoder;

@MappedSuperclass
public abstract class IdentityTrait extends Data{

	@Column(nullable=false,updatable=false)
	private String identifier;
	@JsonIgnore
	private String password;
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void updatePassword(String newPassword) {
		this.password = BCryptEncoder.getEncoder().encode(newPassword);
	}
	
	public Boolean checkPassword(String rawPassword) {
		return BCryptEncoder.getEncoder().matches(rawPassword, password);
	}
	
	public abstract String getPrefix();
	
	@Override
	public void validate() {
		if(identifier != null) {
			if(identifier.length() < 4) {
				throw new BadRequestException("Identifier is too short! Expected minimum of 4 characters");
			}
		}
		
		if(password != null) {
			if(password.length() < 4) {
				throw new BadRequestException("Password too short! Min 4");
			}
		}
		
	}

}
