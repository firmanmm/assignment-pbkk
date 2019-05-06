package com.kuliah.pbkk.service.customer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kuliah.pbkk.service.customer.entity.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long> {
	public Driver getByNoIdentitas(String noIdentitas);
	public Driver getByEmail(String email);
	public Driver getByNoHandphone(String noHandphone);
	public Driver getByNoPolisi(String noPolisi);
	public List<Driver> getByJenisKendaraan(String jenisKendaraan);
}
