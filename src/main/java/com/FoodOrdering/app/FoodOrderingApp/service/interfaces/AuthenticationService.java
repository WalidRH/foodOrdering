package com.FoodOrdering.app.FoodOrderingApp.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.FoodOrdering.app.FoodOrderingApp.model.Client;

public interface AuthenticationService {
	public ResponseEntity login(String email, String password);
	public ResponseEntity signUp(Client client);
}
