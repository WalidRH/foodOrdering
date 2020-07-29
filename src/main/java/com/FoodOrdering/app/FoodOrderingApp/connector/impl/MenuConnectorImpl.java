package com.FoodOrdering.app.FoodOrderingApp.connector.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.MenuConnector;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.repository.MenuRepository;

@Component
public class MenuConnectorImpl implements MenuConnector{

	@Autowired
	private MenuRepository menuRep;
	
	@Transactional
	@Override
	public Menu getMenu(int id) {
		return menuRep.findById(id);
	}

	@Transactional
	@Override
	public Menu getMenu(String name) {
		return menuRep.findByName(name);
	}

	@Transactional
	@Override
	public Menu saveMenu(Menu menu) {
		return menuRep.save(menu);
	}

	@Transactional
	@Override
	public Menu editMenu(Menu menu) {
		Menu menuEntity = this.getMenu(menu.getIdmenu());
		menuEntity.setName(menu.getName());
		menuEntity.setPrice(menu.getPrice());
		return menuRep.save(menuEntity);
	}

	@Transactional
	@Override
	public Iterable<Menu> getAll() {
		return menuRep.findAll();
	}
	
	
	

}
