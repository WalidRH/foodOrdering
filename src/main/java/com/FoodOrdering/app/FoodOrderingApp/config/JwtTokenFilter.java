package com.FoodOrdering.app.FoodOrderingApp.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class JwtTokenFilter extends GenericFilterBean{
	
	@Autowired
    private JwtProvider jwtTokenProvider;

	// filter the request, and getting jwtToken from the header
	// then check if the token is valid
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
		 System.out.println("********************************************************************\n********************************************************************");
		 System.out.println("Token : "+token);
		    if (token != null && jwtTokenProvider.validateToken(token)) {
	        	System.out.println("Token is Valid");
	            Authentication auth = (token != null) ? jwtTokenProvider.getAuthentication(token) : null;
	            SecurityContextHolder.getContext().setAuthentication(auth);
	        }else {
	        	if (token == null)
	        		System.out.println("Token is null");
	        	else
	        	System.out.println("Invalide Token");
	        }
			 System.out.println("********************************************************************\n********************************************************************");

	        chain.doFilter(request, response);
		
	}

}
