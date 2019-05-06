package com.kuliah.pbkk.service.customer.service.implementation;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import com.kuliah.pbkk.service.customer.entity.Driver;
import com.kuliah.pbkk.service.customer.repository.DriverRepository;
import com.kuliah.pbkk.service.customer.service.DriverService;

public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepository DriverRepository;
	
	@Override
	public Driver save(Driver data) {
		if (data.getPassword() != null && data.getPassword().length > 0 ) {
			String hashed = BCrypt.hashpw(data.getPassword().toString(), BCrypt.gensalt());
			data.setPassword(hashed.getBytes());
		}
		return null;
	}

	@Override
	public void deleteById(Long id) {
		DriverRepository.deleteById(id);
		
	}

	@Override
	public Iterable<Driver> findAll() {
		return DriverRepository.findAll();
	}

	@Override
	public Optional<Driver> findById(Long id) {
		return DriverRepository.findById(id);
	}
	
}
