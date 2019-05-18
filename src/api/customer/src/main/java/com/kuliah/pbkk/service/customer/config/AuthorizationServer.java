package com.kuliah.pbkk.service.customer.config;

import java.util.ArrayList;
import java.util.Iterator;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder.ClientBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.kuliah.pbkk.service.customer.entity.Client;
import com.kuliah.pbkk.service.customer.repository.ClientRepository;
import com.kuliah.pbkk.service.customer.utility.BCryptEncoder;

@Configuration
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	private String salt;
	
	@Autowired
	@Qualifier("customClientDetailsService")
	private ClientDetailsService clientDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    
    public AuthorizationServer() {
		salt = BCrypt.gensalt();
	}
    
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JWTCustomerTokenEnchancer();
        converter.setSigningKey(salt);
        return converter;
    }
    
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
    
	
	@Override	
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
			.accessTokenConverter(accessTokenConverter())
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.passwordEncoder(BCryptEncoder.getEncoder()).checkTokenAccess("permitAll()");
	}
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientDetailsService);
		//initializeInMemoryClient(clients);
	}
	/*
	//TODO : Probably Delete :/
	private void initializeInMemoryClient(ClientDetailsServiceConfigurer clients) throws Exception {
		ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder> builder = clients.inMemory();
		Iterable<Client> clientList = clientRepository.findAll();
		Iterator<Client> iter = clientList.iterator();
		while(iter.hasNext()) {
			Client client = iter.next();
			ClientBuilder clientBuilder = builder.withClient(client.getIdentifier())
				.secret(client.getPassword())
				.authorizedGrantTypes("password", "refresh_token")
				.scopes(client.getScopes().split(" "));
				if(iter.hasNext()) {
					builder = clientBuilder.and();
				}
		}
	}
	*/
	
}
