package com.prueba.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.prueba.auth.models.Login;
import com.prueba.auth.models.MyUserDetails;

@Controller
public class modificarPassController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MyService myService;

	@GetMapping("/modificaPass")
	public String modificarPassword(Model model) {
		
		model.addAttribute("pageTitle","Cambiar password");
		
		return "modificaPass";
	}
	
	@PostMapping("/modificaPass")
	public String savePassword(HttpServletRequest request, HttpServletResponse response,Model model	) {
		    
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String oldPassword = request.getParameter("Antpassword");
	    String newPassword = request.getParameter("nuevopassword");
	    
		Object principal = null;
        if(authentication != null) {
        	principal = authentication.getPrincipal();
        }
        if (principal != null && principal instanceof MyUserDetails) {
		    MyUserDetails userDetails = (MyUserDetails) principal;
		    Login login  = userDetails.getLogin();
		    
		     
		    if(!passwordEncoder.matches(oldPassword, login.getPassword())) {
		    	model.addAttribute("pageTitle","Cambiar password");
		    	model.addAttribute("message","Contraseña no coincide");
		    
		    	return "modificaPass";
		    	
		    }
		    if(oldPassword.equals(newPassword)) {
		    	model.addAttribute("pageTitle","Cambiar password");
		    	model.addAttribute("message","Captura Contraseña diferente a la anterior");
		      
		    	return "modificaPass";
		    	
		    }
		    
		   
	    	
		    
		    myService.updatePassword(newPassword, login, passwordEncoder);
		    
	
		    
        }
		
        
        
		return "user";	
	}
	
}
