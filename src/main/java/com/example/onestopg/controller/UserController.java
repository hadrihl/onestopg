package com.example.onestopg.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.onestopg.entity.User;
import com.example.onestopg.service.CustomUserDetails;
import com.example.onestopg.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Logger logger = LogManager.getLogger(UserController.class);
	
	@GetMapping("/signup")
	public String getSignupPage() {
		logger.debug("Signup page OPENED.");
		return "signup";
	}
	
	@PostMapping("/signup")
	public String processSignup(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		logger.debug("User created SUCCESSFULLY.");
		return "redirect:/signin";
	}

	@GetMapping("/signin")
	public String getSigninPage() {
		return "signin";
	}
	
	@GetMapping("/signin-error")
	public ModelAndView getSigninError(Model model) {
		ModelAndView mv = new ModelAndView("signin");
		mv.addObject("error_string", "Wrong username/password. Please try again.");
		logger.debug("Signin UNSUCCESSFUL.");
		return mv;
	}
	
	@GetMapping("/users")
	public String getUsersPage(Model model, @AuthenticationPrincipal CustomUserDetails loggedinUser) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		loggedinUser.getAuthorities();
		model.addAttribute("username", loggedinUser.getUsername());
		logger.debug("Users page OPENED.");
		return "users";
	}
	
	@GetMapping("/users/{id}")
	public String getEditUserProfilePage(Model model, @AuthenticationPrincipal CustomUserDetails loggedinUser,
			@PathVariable("id") Integer id) {
		User user = userService.getUserById(id);
		model.addAttribute("username", loggedinUser.getUsername());
		model.addAttribute("user", user);
		return "edit-user";
	}
	
	@PostMapping("/update-user/{id}")
	public String updateUserProfile(HttpServletRequest request, @ModelAttribute("user") User user, @PathVariable("id") Integer id) {
		String ADD_STORE = request.getParameter("addStore");
		String VIEW_STORE = request.getParameter("viewStore");
	
//		System.out.println("User ID: " + id);
//		System.out.println("user.username: " + user.getUsername());
//		System.out.println("user.email: " + user.getEmail());
//		System.out.println("ADD_STORE: " + ADD_STORE);
//		System.out.println("VIEW_STORE: " + VIEW_STORE);
		
		userService.updateUserProfile(user, id, ADD_STORE, VIEW_STORE);
		logger.debug("User profile updated SUCCESSFULLY.");
		return "redirect:/users";
	}
	
	@GetMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}
