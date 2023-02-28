package com.example.onestopg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.onestopg.entity.User;
import com.example.onestopg.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not found.");
		}
		
		return new CustomUserDetails(user);
	}

}
