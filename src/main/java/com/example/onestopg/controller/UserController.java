package com.example.onestopg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onestopg.entity.User;
import com.example.onestopg.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signup")
	public String getSignupPage() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String processSignup(@ModelAttribute("user") User user) {
		System.out.println("user.username: " + user.getUsername());
		System.out.println("user.email: " + user.getEmail());
		userService.saveUser(user);
		return "redirect:/signin";
	}

	@GetMapping("/signin")
	public String getSigninPage() {
		return "signin";
	}
}
