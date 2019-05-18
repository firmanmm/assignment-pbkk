	package com.kuliah.pbkk.service.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kuliah.pbkk.service.customer.entity.Client;
import com.kuliah.pbkk.service.customer.entity.User;

public interface ClientRepository extends CrudRepository<Client, Long> {
	@Transactional
	@Modifying
	@Query(value="UPDATE clients SET deleted_at = NOW() WHERE id = ?1 AND deleted_at IS NULL", nativeQuery=true)
	public void markDelete(Long id);
	public Client getByIdentifier(String identifier);
}
