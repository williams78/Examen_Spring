package com.prueba.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainResource {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/user")
	public String user() {
		return ("user");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Welcome Admin</h1>");
	}
	
	@GetMapping("/renovar")
	public String renovar() {
		return "renovar";
	}
	
}
