package com.example.onestopg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	Logger logger = LogManager.getLogger(UserService.class);
	
	public User saveUser(User tmp) {
		User user = new User();
		user.setUsername(tmp.getUsername());
		user.setEmail(tmp.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(tmp.getPassword()));
		
		user.addRole(roleRepository.findById(2).get()); //default authority - VIEW_STORE
		
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public User updateUserProfile(User tmp, Integer id, String ADD_STORE, String VIEW_STORE) {
		User user = userRepository.findById(id).get();
		user.setUsername(tmp.getUsername());
		user.setEmail(tmp.getEmail());
		
		if (ADD_STORE == null) {
			user.removeRole(roleRepository.findRoleByName("ADD_STORE"));
		} else if (user.getRoles().size() == 1 && ADD_STORE.equalsIgnoreCase("on")) {
			user.addRole(roleRepository.findRoleByName("ADD_STORE"));
		}
		
		return userRepository.save(user);
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
}
 