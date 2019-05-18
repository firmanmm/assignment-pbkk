package com.kuliah.pbkk.service.customer.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class BCryptEncoder {
	private static BCryptPasswordEncoder encoder;
	
	private BCryptEncoder() {
		
	}
	
	public static BCryptPasswordEncoder getEncoder() {
		if(encoder == null) {
			encoder = new BCryptPasswordEncoder();
		}
		return encoder;
	}
}
