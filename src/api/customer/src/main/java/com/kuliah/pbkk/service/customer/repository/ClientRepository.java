	package com.kuliah.pbkk.service.customer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kuliah.pbkk.service.customer.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	@Query("UPDATE FROM clients SET `deleted_at` = CURRENT_TIMESTAMP WHERE id = ?1 AND `deleted_at` IS NULL")
	public void markDelete(Long id);
	public Client getByIdentifier(String identifier);
}
