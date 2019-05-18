package com.kuliah.pbkk.service.customer.entity.oauth;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.kuliah.pbkk.service.customer.entity.Client;
import com.kuliah.pbkk.service.customer.entity.oauth.authorities.AdminAuthority;
import com.kuliah.pbkk.service.customer.entity.oauth.authorities.UserAuthority;

public class ClientDetailData implements ClientDetails {

	
	private Client client;
	private Set<String> scopes;
	private Set<String> grantedType;
	private Collection<GrantedAuthority> authorities;
	
	public ClientDetailData(Client client) {
		this.client = client;
		String[] scopeArray = client.getScopes().split(" ");
		this.scopes = new HashSet<>();
		for (String scope : scopeArray) {
			this.scopes.add(scope);
		}
		this.grantedType = new HashSet<>();
		this.grantedType.add("password");
		this.grantedType.add("refresh_token");
		this.authorities = new HashSet<>();
		String[] authorityArray = client.getAuthorities().split(" ");
		for (String authority : authorityArray) {
			this.authorities.add(new SimpleGrantedAuthority(authority));
		}
	}
	
	@Override
	public String getClientId() {
		return client.getIdentifier();
	}

	@Override
	public Set<String> getResourceIds() {
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return client.getPassword();
	}

	@Override
	public boolean isScoped() {
		return true;
	}

	@Override
	public Set<String> getScope() {
		return this.scopes;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return this.grantedType;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return new HashSet<>();
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return 60*60*24;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return getAccessTokenValiditySeconds() * 30;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return true;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

}
