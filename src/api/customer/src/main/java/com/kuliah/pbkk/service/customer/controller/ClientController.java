package com.kuliah.pbkk.service.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuliah.pbkk.service.customer.entity.Client;
import com.kuliah.pbkk.service.customer.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public Iterable<Client> getAllClient() {
		return clientService.findAll();
		
	}
	
	@GetMapping("/clients/{id}")
	public Client getClientById(
			@PathVariable Long id) {
		return clientService.findById(id).get();
	}
	
	@PostMapping("/clients") 
	public Client postClient(
			@ModelAttribute Client client) {
		return clientService.save(client);
	}
	
	@PutMapping("/clients/{id}")
	public Client putClient(
			@PathVariable Long id, 
			@ModelAttribute Client client) {
		client.setId(id);
		return clientService.save(client);
	}
	
	@PatchMapping("/clients/{id}")
	public Client patchClient(
			@PathVariable Long id, 
			@ModelAttribute Client client) {
		client.setId(id);
		return clientService.update(client);
	}
	
	@DeleteMapping("/clients/{id}")
	public void deleteClient(
			@PathVariable Long id) {
		clientService.deleteById(id);
	}
}
