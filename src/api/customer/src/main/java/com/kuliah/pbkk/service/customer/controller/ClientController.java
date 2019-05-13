package com.kuliah.pbkk.service.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("#oauth2.hasScope('read_client')")
	@GetMapping("/clients")
	public Iterable<Client> getAllClient() {
		return clientService.findAll();
		
	}
	@PreAuthorize("#oauth2.hasScope('read_client')")
	@GetMapping("/clients/{id}")
	public Client getClientById(
			@PathVariable Long id) {
		return clientService.findById(id).get();
	}
	@PreAuthorize("#oauth2.hasScope('trust_client')")	
	@PostMapping("/clients") 
	public Client postClient(
			@ModelAttribute Client client) {
		return clientService.save(client);
	}
	@PreAuthorize("#oauth2.hasScope('trust_client')")
	@PutMapping("/clients/{id}")
	public Client putClient(
			@PathVariable Long id, 
			@ModelAttribute Client client) {
		client.setId(id);
		return clientService.save(client);
	}
	@PreAuthorize("#oauth2.hasScope('write_client')")	
	@PatchMapping("/clients/{id}")
	public Client patchClient(
			@PathVariable Long id, 
			@ModelAttribute Client client) {
		client.setId(id);
		return clientService.update(client);
	}
	@PreAuthorize("#oauth2.hasScope('delete_client')")
	@DeleteMapping("/clients/{id}")
	public void deleteClient(
			@PathVariable Long id) {
		clientService.deleteById(id);
	}
}
