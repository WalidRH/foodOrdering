package com.FoodOrdering.app.FoodOrderingApp.connector;

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
    
    @Autowired
    private Client clientModel;
	
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

	@Transactional
	@Override
	public Client saveClient(Client client) {
		clientModel.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
		String ClientAccessRole = (client.getRole() != null ) ? client.getRole() : "USER" ; 
		clientModel.setRole(ClientAccessRole);
		return clientRepo.save(clientModel);
	    
	}

}
