package com.prueba.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prueba.auth.models.Login;
import com.prueba.auth.models.MyUserDetails;

@Service
	public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<Login> login =userRepository.findByUserName(userName);
	
 
	   login.orElseThrow(()->new UsernameNotFoundException("No se encontro: " + userName));
	
		return login.map(MyUserDetails::new).get();
		
	
	}
	
	

}
