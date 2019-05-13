	package com.kuliah.pbkk.service.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kuliah.pbkk.service.customer.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	@Query(value="UPDATE clients SET deleted_at = NOW() WHERE id = ?1 AND deleted_at IS NULL", nativeQuery=true)
	public void markDelete(Long id);
	public Client findByIdentifier(String identifier);
}
