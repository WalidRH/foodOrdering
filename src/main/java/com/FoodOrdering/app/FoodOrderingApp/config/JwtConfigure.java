package com.FoodOrdering.app.FoodOrderingApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
	private JwtTokenFilter customFilter;
	
	@Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
