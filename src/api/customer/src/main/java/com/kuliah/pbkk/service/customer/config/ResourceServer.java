package com.kuliah.pbkk.service.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import com.kuliah.pbkk.service.customer.entity.Client;
import com.kuliah.pbkk.service.customer.repository.ClientRepository;

@Configuration
public class ResourceServer extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Primary
    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        Client client = clientRepository.findByIdentifier("resource");
        tokenService.setCheckTokenEndpointUrl(
                "http://localhost:9999/oauth/check_token");
        tokenService.setClientId(client.getIdentifier());
        tokenService.setClientSecret(client.getSecret());
        return tokenService;
    }
}
