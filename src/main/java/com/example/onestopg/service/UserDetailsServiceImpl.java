package com.example.onestopg.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.onestopg.entity.User;
import com.example.onestopg.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not found.");
		}
		
		logger.debug("user " + user.getUsername() + " login SUCCESSFULLY.");		
		return new CustomUserDetails(user);
	}

}
