package com.kuliah.pbkk.service.customer.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kuliah.pbkk.service.customer.entity.Driver;
import com.kuliah.pbkk.service.customer.entity.IdentityTrait;
import com.kuliah.pbkk.service.customer.entity.oauth.UserDetailData;
import com.kuliah.pbkk.service.customer.repository.DriverRepository;
import com.kuliah.pbkk.service.customer.repository.RestaurantRepository;
import com.kuliah.pbkk.service.customer.repository.UserRepository;
import com.kuliah.pbkk.service.customer.service.RestaurantService;

@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		IdentityTrait identity = null;
		if(username.startsWith("driver_")) {
			identity = driverRepository.getByIdentifier(username.substring("driver_".length()));
		}else if(username.startsWith("user_")) {
			identity = userRepository.getByIdentifier(username.substring("user_".length()));
		}else if(username.startsWith("restaurant_")) {
			identity = restaurantRepository.getByIdentifier(username.substring("restaurant_".length()));
		}else {
			throw new UsernameNotFoundException("Identifier type not supported");
		}
		
		if(identity == null) {
			throw new UsernameNotFoundException("User for username = " + username + " can't be found on this server");
		}
		return new UserDetailData(identity);
	}

}
