package com.kuliah.pbkk.service.customer.entity.oauth.authorities;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority{

	@Override
	public String getAuthority() {
		return "User";
	}
}
