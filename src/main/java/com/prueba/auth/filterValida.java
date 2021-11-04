package com.prueba.auth;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.prueba.auth.models.Login;
import com.prueba.auth.models.MyUserDetails;

@Component
public class filterValida implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURL = httpRequest.getRequestURL().toString();
        
        if(requestURL.endsWith("/modificaPass")) {
        	chain.doFilter(request, response);
        	return;
        }
        
        System.out.println("Expiro password: " + requestURL);
		
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = null;
        if(authentication != null) {
        	principal = authentication.getPrincipal();
        }
        
        if (principal != null && principal instanceof MyUserDetails) {
        	
        	MyUserDetails myuserdetails = (MyUserDetails) principal;
        	Login login = myuserdetails.getLogin();
        	
        	if(login.isvaluarExpiracion()) {
        		System.out.println(login.getUserName() + "Expiro tu contraseña");
        		System.out.println("Fecha de hoy" + new Date());
        		
        		HttpServletResponse httpResponse = (HttpServletResponse) response;
        		String redirectURL = httpRequest.getContextPath() + "/modificaPass";
        		httpResponse.sendRedirect(redirectURL);
        	}else {
        		
        		System.out.println(login.getUserName() + "No ha expirado tu contraseña");
        		chain.doFilter(request, response);		
        	}
        	
        }else {
        	
        	chain.doFilter(request, response);	
        }
        
        
	}

	
	
}
