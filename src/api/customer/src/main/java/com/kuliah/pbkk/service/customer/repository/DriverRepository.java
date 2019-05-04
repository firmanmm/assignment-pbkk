package com.kuliah.pbkk.service.customer.repository;

import java.util.List;

import com.kuliah.pbkk.service.customer.entity.Driver;

public interface DriverRepository extends UserRepository {
	public Driver getByNoPolisi(String noPolisi);
	public List<Driver> getByJenisKendaraan(String jenisKendaraan);
}
