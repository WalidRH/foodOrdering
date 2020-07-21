package com.FoodOrdering.app.FoodOrderingApp.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.ClientConnector;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.repository.ClientRepository;

@Service
public class ClientConnectorImpl implements ClientConnector {

	@Autowired
	ClientRepository clientRepo;
	
	@Transactional
	@Override
	public Client getClient(int id) {
		return clientRepo.findById(id);
	}

	@Transactional
	@Override
	public Client getClient(String email) {
		return clientRepo.findByEmail(email);
	}

}
