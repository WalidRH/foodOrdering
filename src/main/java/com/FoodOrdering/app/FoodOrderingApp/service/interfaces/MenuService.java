package com.FoodOrdering.app.FoodOrderingApp.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.FoodOrdering.app.FoodOrderingApp.model.Menu;

public interface MenuService {
	
	public ResponseEntity addMenu(Menu menu);
	
	public ResponseEntity updateMenu(Menu menu);
	
	public ResponseEntity getMenu(int id);
	
	public ResponseEntity getMenu(String name);

	public ResponseEntity getMenuListByCategorie(String categorie);

	public ResponseEntity getAll();
	

}
