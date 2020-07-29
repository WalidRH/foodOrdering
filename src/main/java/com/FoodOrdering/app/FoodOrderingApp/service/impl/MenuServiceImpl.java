package com.FoodOrdering.app.FoodOrderingApp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static org.springframework.http.ResponseEntity.ok;
import com.FoodOrdering.app.FoodOrderingApp.connector.impl.MenuConnectorImpl;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.service.interfaces.MenuService;

import antlr.collections.List;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuConnectorImpl menuConnector;

	@Override
	public ResponseEntity addMenu(Menu menu) {
		Map<String, Object> model = new HashMap<>();
		if (this.getMenu(menu.getName()) == null) {
			Menu menu_ = menuConnector.saveMenu(menu);
			model.put("name", menu_.getName());
			model.put("price", menu_.getPrice());
		} else
			model.put("ERROR", "Can't add Menu");
		return ok(model);
	}

	@Override
	public ResponseEntity updateMenu(Menu menu) {
		Map<String, Object> model = new HashMap<>();
		if (this.getMenu(menu.getIdmenu()) != null) {
			Menu menu_ = menuConnector.editMenu(menu);
			model.put("name", menu_.getName());
			model.put("price", menu_.getPrice());
		} else
			model.put("ERROR", "Can't Update Menu");
		return ok(model);
	}

	@Override
	public ResponseEntity getMenu(int id) {
		Map<String, Object> model = new HashMap<>();
		Menu menu = menuConnector.getMenu(id);
		model.put("name", menu.getName());
		model.put("price", menu.getPrice());
		return ok(model);

	}

	@Override
	public ResponseEntity getMenu(String name) {
		Map<String, Object> model = new HashMap<>();
		Menu menu = menuConnector.getMenu(name);
		model.put("name", menu.getName());
		model.put("price", menu.getPrice());
		return ok(model);
	}

	@Override
	public ResponseEntity getAll() {
		Iterable<Menu> menuDB = menuConnector.getAll();
		Map<String, Object> menuList = new HashMap<>();
		
		for (Menu menuElement : menuDB) {
			menuList.put("name", menuElement.getName());
			menuList.put("price", menuElement.getPrice());
		}
		return new ResponseEntity<Object>(menuList, HttpStatus.OK);
	}

}
