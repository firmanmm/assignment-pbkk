package com.kuliah.pbkk.service.customer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.kuliah.pbkk.service.customer.entity.oauth.UserDetailData;

public class JWTCustomerTokenEnchancer extends JwtAccessTokenConverter{
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		if(authentication.getOAuth2Request().getGrantType().equalsIgnoreCase("password")) {
			UserDetailData user = (UserDetailData) authentication.getUserAuthentication().getPrincipal();
			Map<String, Object> additionalInformation = new HashMap<String, Object>();
			additionalInformation.put("sub", user.getUsername());
			String prefix = user.getPrefix();
			additionalInformation.put("user_type", prefix.substring(0, prefix.length()-1));
			token.setAdditionalInformation(additionalInformation);
		}
		token = (DefaultOAuth2AccessToken) super.enhance(token, authentication);
		return token;
	}
}
