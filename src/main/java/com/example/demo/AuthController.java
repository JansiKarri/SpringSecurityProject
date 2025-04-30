package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
	private final userService userservice;

	public AuthController(userService userservice) {
		super();
		this.userservice = userservice;
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/register")
   public String saveuser(User u) {
	   userservice.addUser(u);
	   return "redirect:/login";
   }
   @GetMapping("/userdashboard")
   public String userDashboard() {
	   return "userdashboard";
   }
   @GetMapping("/logout")
   public String logout() {
	   return "redirect:/login?logout";
   }
}
