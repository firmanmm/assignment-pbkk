package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clients", indexes= {
		@Index(name="idx_identifier", columnList="identifier", unique = true)
	})
public class Client extends IdentityTrait{

	private String scopes;
	private String authorities;

	public String getScopes() {
		return scopes;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}

	@Override
	public void validate() {
		super.validate();
	}

	@Override
	public String getPrefix() {
		return "client_";
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

}
