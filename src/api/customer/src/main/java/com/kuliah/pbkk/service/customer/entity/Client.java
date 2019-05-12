package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="clients", indexes= {
		@Index(name="idx_identifier", columnList="identifier", unique = true)
	})
public class Client extends Data{

	@Column(unique=true, updatable=false)
	private String identifier;
	private String secret;
	private String scopes;

	public String getScopes() {
		return scopes;
	}


	public void setScopes(String scopes) {
		this.scopes = scopes;
	}


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSecret() {
		return secret;
	}



	public void setSecret(String secret) {
		this.secret = secret;
	}



	@Override
	public void validate() {
		return;
	}

}
