package com.kuliah.pbkk.service.customer.entity.oauth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.kuliah.pbkk.service.customer.entity.IdentityTrait;
import com.kuliah.pbkk.service.customer.entity.oauth.authorities.UserAuthority;

public class UserDetailData implements UserDetails{
	
	private IdentityTrait identity;
	
	public UserDetailData(IdentityTrait identityTrait) {
		this.identity = identityTrait;
	}

	@Override
	public Collection<UserAuthority> getAuthorities() {
		List<UserAuthority> authorities = new ArrayList<>();
		authorities.add(new UserAuthority());
		return authorities;
	}

	@Override
	public String getPassword() {
		return identity.getPassword();
	}

	@Override
	public String getUsername() {
		return identity.getIdentifier();
	}
	
	public String getPrefix() {
		return identity.getPrefix();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return identity.getDeletedAt() == null;
	}

}
