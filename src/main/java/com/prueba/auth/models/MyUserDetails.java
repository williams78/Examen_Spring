package com.prueba.auth.models;

import java.util.Arrays;

import java.util.Collection;
import java.util.Date;

import javax.xml.bind.PrintConversionEvent;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyUserDetails implements UserDetails{

	
	private String password;
	private String userName;
	
	private Login login;
	
	public MyUserDetails(Login login) {
	 	this.login = login;
	 	
	 	
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return login.getPassword();
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login.getUserName();
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}

       
    
    
	
	
}
