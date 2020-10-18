package com.FoodOrdering.app.FoodOrderingApp.service.impl;

import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementExistException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.FoodOrdering.app.FoodOrderingApp.config.JwtProvider;
import com.FoodOrdering.app.FoodOrderingApp.connector.impl.ClientConnectorImpl;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import static org.springframework.http.ResponseEntity.ok;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.service.interfaces.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	ClientConnectorImpl clientConnectorDB;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtProvider jwtTokenProvider;

	@Override
	public ResponseEntity login(String email, String password) {
		try {
	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	        String token = jwtTokenProvider.createToken(email, this.clientConnectorDB.getClient(email).getRole());
	        System.out.println("TOKEN");
			Map<Object, Object> model = new HashMap<>();
	        model.put("email", email);
	        model.put("role", this.clientConnectorDB.getClient(email).getRole());
			model.put("firstName", clientConnectorDB.getClient(email).getFirstName());
			model.put("lastName", clientConnectorDB.getClient(email).getLastName());
			model.put("number", clientConnectorDB.getClient(email).getPhone());
			model.put("token", token);
			return ok(model);

		}
		catch (AuthenticationException e) {
            throw new ElementNotFoundException("Invalid email/password supplied");
        }

	}

	@Override
	public ResponseEntity signUp(Client client ) {
		Client userExists = clientConnectorDB.getClient(client.getEmail());
		System.out.println("WAL :: SignUP "+ client.getEmail());
        if (userExists != null) {
            throw new ElementExistException("User with username: " + client.getEmail() + " already exists");
        }

    	Map<Object, Object> model = new HashMap<>();
        if(clientConnectorDB.saveClient(client) != null){
        	model.put("Registration", "SUCCESS");
		}
        else{
        	model.put("Registration", "FAILED");
		}
        
        return ok(model);
	}

}
