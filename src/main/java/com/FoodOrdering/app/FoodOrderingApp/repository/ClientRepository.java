package com.FoodOrdering.app.FoodOrderingApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.FoodOrdering.app.FoodOrderingApp.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{
	Client findById(int idClient);
	Client findByEmail(String email);
}
