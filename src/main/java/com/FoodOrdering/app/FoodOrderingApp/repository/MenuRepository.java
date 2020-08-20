package com.FoodOrdering.app.FoodOrderingApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.FoodOrdering.app.FoodOrderingApp.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Integer>{

	Menu findById(int id);
	Menu findByName(String name);
	Iterable<Menu> findByCategorie(String categorie);
	Iterable<Menu> findAll();
}
