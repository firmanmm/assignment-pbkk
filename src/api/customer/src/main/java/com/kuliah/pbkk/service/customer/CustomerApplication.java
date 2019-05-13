package com.kuliah.pbkk.service.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.kuliah.pbkk.service.customer.config.MethodSecurityConfig;
import com.kuliah.pbkk.service.customer.config.ServerSecurityConfig;

@EntityScan("com.kuliah.pbkk.service.customer.entity")
@ComponentScan("com.kuliah.pbkk.service.customer")
@EnableAuthorizationServer
@EnableResourceServer
@EnableWebSecurity
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
