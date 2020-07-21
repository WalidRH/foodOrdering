package com.FoodOrdering.app.FoodOrderingApp.connector.Interface;


import com.FoodOrdering.app.FoodOrderingApp.model.Client;
public interface ClientConnector {
	/**
	 * Connect to the dataBase to get some Client data based on id or email
	 * @param id || email
	 * @return Client
	 */
	public Client getClient(int id);
	public Client getClient(String email);
}
