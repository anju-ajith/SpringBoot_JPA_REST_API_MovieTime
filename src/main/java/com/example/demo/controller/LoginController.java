package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.TblUser;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
	private final UserService userService;

	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/login")
	public String getLoginPage(Model m) {
		m.addAttribute("user", new TblUser());
		return "LoginPage";
	}

	@PostMapping("/userLogin")
	public String userLogin(@ModelAttribute TblUser user) {
		TblUser tbluser = userService.findUser(user);
		if (tbluser != null) {
			return "Index";
		}

		return "redirect:/login";
	}

	@GetMapping("/index")
	public String getIndex() {

		return "Index";
	}

}
