package com.prueba.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prueba.auth.models.Login;

@Service
public class MyService {
	
	@Autowired
	UserRepository userRepository;
	
public void updatePassword(String newPassword, Login login, PasswordEncoder passwordEncoder) {
    	
    	String encodedPassword = passwordEncoder.encode(newPassword);
    	login.setPassword(encodedPassword);
    	login.setFechamodificacion(new Date());
    	System.out.println(newPassword);
    	System.out.println(login);
    	System.out.println(passwordEncoder);
    	userRepository.save(login);	
    } 
	

}
