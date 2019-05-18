package com.kuliah.pbkk.service.customer.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kuliah.pbkk.service.customer.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User getByIdentifier(String identitifer);
	public User getByNoIdentitas(String noIdentitas);
	public User getByEmail(String email);
	public User getByNoHandphone(String noHandphone);
	@Transactional
	@Modifying
	@Query(value="UPDATE users SET deleted_at = NOW() WHERE id = ?1 AND deleted_at IS NULL", nativeQuery=true)
	public void markDelete(Long id);
}
