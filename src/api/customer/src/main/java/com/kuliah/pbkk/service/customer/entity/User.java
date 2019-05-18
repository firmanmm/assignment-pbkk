package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;



@Entity
@Table(name="users", indexes={
		@Index(name="idx_identifier", columnList="identifier", unique = true),
		@Index(name="idx_no_handphone", columnList="no_handphone", unique=true),
		@Index(name="idx_no_identitas", columnList="no_identitas", unique=true)})
public class User extends UserTrait{

	@Override
	public String getPrefix() {
		return "user_";
	}
	
}
