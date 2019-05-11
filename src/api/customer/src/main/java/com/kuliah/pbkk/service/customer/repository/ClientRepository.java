package com.kuliah.pbkk.service.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.kuliah.pbkk.service.customer.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	public Client getByIdentifier(String identifier);
}
