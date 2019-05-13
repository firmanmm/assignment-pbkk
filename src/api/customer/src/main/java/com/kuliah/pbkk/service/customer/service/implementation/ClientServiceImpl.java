package com.kuliah.pbkk.service.customer.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuliah.pbkk.service.customer.entity.Client;
import com.kuliah.pbkk.service.customer.entity.Driver;
import com.kuliah.pbkk.service.customer.repository.ClientRepository;
import com.kuliah.pbkk.service.customer.service.ClientService;

@Component("clientService")
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client save(Client data) {
		return clientRepository.save(data);
	}

	@Override
	public Client update(Client data) {
		Client original = clientRepository.findById(data.getId()).get();
		original.merge(data);
		return clientRepository.save(original);
	}

	@Override
	public void deleteById(Long id) {
		clientRepository.markDelete(id);
	}

	@Override
	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> findById(Long id) {
		return clientRepository.findById(id);
	}
	


}
