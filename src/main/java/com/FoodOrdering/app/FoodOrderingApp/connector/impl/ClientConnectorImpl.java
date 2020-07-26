package com.FoodOrdering.app.FoodOrderingApp.connector.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.ClientConnector;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.repository.ClientRepository;

@Service
public class ClientConnectorImpl implements ClientConnector {

	@Autowired
	ClientRepository clientRepo;
	
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

	@Transactional
	@Override
	public Client getClient(String email) {
		return clientRepo.findByEmail(email);
	}

	@Transactional
	@Override
	public Client saveClient(Client client) {
		System.out.println("WAL :: saveClient ---> "+client.getEmail());
		client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
		String ClientAccessRole = (client.getRole() != null && !client.getRole().isEmpty() ) ? client.getRole() : "USER" ; 
		client.setRole(ClientAccessRole);
		return clientRepo.save(client);
	    
	}

}
