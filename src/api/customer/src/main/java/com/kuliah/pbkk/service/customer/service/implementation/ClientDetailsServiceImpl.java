package com.kuliah.pbkk.service.customer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import com.kuliah.pbkk.service.customer.entity.Client;
import com.kuliah.pbkk.service.customer.entity.oauth.ClientDetailData;
import com.kuliah.pbkk.service.customer.repository.ClientRepository;

@Component("customClientDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId){
		
		Client client = clientRepository.getByIdentifier(clientId);
		if(client == null) {
			throw new ClientRegistrationException("Client with id = " + clientId + " can't be found");
		}
		return new ClientDetailData(client);
	}
	
}
