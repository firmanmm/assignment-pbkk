package com.kuliah.pbkk.service.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kuliah.pbkk.service.customer.entity.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long> {
	public Driver getByNoIdentitas(String noIdentitas);
	public Driver getByEmail(String email);
	public Driver getByNoHandphone(String noHandphone);
	public Driver getByNoPolisi(String noPolisi);
	public List<Driver> getByJenisKendaraan(String jenisKendaraan);
	@Transactional
	@Modifying
	@Query(value="UPDATE drivers SET deleted_at = NOW() WHERE id = ?1 AND deleted_at IS NULL", nativeQuery=true)
	public void markDelete(Long id);
}
