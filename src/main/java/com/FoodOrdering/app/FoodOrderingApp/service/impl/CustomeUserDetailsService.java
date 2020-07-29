package com.FoodOrdering.app.FoodOrderingApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.repository.ClientRepository;

@Component
public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	ClientRepository clientRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client client = clientRepo.findByEmail(email);
		
	    if(client != null) {
	    	System.out.println("USER Found "+ client.getRole());
            return buildUserForAuthentication(client);
        } else {
            throw new UsernameNotFoundException("username not found");
        }

	}
	
	private UserDetails buildUserForAuthentication(Client user) {
        return 
        new User(
        		user.getEmail(), 
        		user.getPassword(), this.getAuthority(user));
    }
	
	private List<GrantedAuthority> getAuthority(Client user) {
		List<GrantedAuthority> authoritie = new ArrayList<GrantedAuthority>();
		//get Role
		authoritie.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
		
		return authoritie;
	}
	
}
