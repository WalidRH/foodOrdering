package com.FoodOrdering.app.FoodOrderingApp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.repository.ClientRepository;

public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	ClientRepository clientRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client client = clientRepo.findByEmail(email);
		return buildUserForAuthentication(client);
	}
	
	private UserDetails buildUserForAuthentication(Client user) {
        return 
        new User(
        		user.getEmail(), 
        		user.getPassword(), 
        		new ArrayList<GrantedAuthority>()
        			.add(new SimpleGrantedAuthority(user.getRole())
        		), false, false, false, null);
    }
	
}
