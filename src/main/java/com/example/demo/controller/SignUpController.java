package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.TblUser;
import com.example.demo.service.UserService;

@Controller
public class SignUpController {

	private final UserService userService;

	public SignUpController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/signUp")
	public String getSignUpPage(Model m) {
		m.addAttribute("user", new TblUser());
		return "SignUp";
	}

	@PostMapping("/userRegistration")
	public String userRegistration(@ModelAttribute TblUser user) {
		userService.saveUser(user);

		return "redirect:/login";

	}

}
