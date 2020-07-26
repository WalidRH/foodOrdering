package com.FoodOrdering.app.FoodOrderingApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.FoodOrdering.app.FoodOrderingApp.model.Client;

public interface ClientRepository extends CrudRepository<Client, String>{
	Optional<Client> findById(String idClient);
	Client findByEmail(String email);
}
