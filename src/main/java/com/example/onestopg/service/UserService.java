package com.example.onestopg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.onestopg.entity.User;
import com.example.onestopg.repository.RoleRepository;
import com.example.onestopg.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User tmp) {
		User user = new User();
		user.setUsername(tmp.getUsername());
		user.setEmail(tmp.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(tmp.getPassword()));
		
		System.out.println("role_user: " + roleRepository.findById(1).get());
		System.out.println("role_admin: " + roleRepository.findById(2).get());
		
		user.addRoles(roleRepository.findById(1).get());
		user.addRoles(roleRepository.findById(2).get());
		return userRepository.save(user);
	}
}
 