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
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuConnectorImpl menuConnector;

	@Override
	public ResponseEntity addMenu(Menu menu) {
		Map<String, Object> model = new HashMap<>();
		if (menuConnector.getMenu(menu.getName()) == null) {
			Menu menu_ = menuConnector.saveMenu(menu);
			model.put("ref", menu_.getIdmenu());
			model.put("name", menu_.getName());
			model.put("price", menu_.getPrice());
		} else
			model.put("ERROR", "Can't add Menu");
		return ok(model);
	}

	@Override
	public ResponseEntity updateMenu(Menu menu) {
		Map<String, Object> model = new HashMap<>();
		if (menuConnector.getMenu(menu.getName()) != null) {
			menu.setIdmenu(menuConnector.getMenu(menu.getName()).getIdmenu());
			Menu menu_ = menuConnector.editMenu(menu);
			model.put("ref", menu_.getIdmenu());
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
		if (menu != null) {
		model.put("ref", menu.getIdmenu());
		model.put("name", menu.getName());
		model.put("categorie", menu.getCategorie());
		model.put("price", menu.getPrice());
		} else {
			model.put("ERROR", "The menu deosn't existe");
		}
		return ok(model);

	}

	@Override
	public ResponseEntity getMenu(String name) {
		Map<String, Object> model = new HashMap<>();
		Menu menu = menuConnector.getMenu(name);
		if (menu != null) {
			model.put("ref", menu.getIdmenu());
			model.put("name", menu.getName());
			model.put("price", menu.getPrice());
		}else {
			model.put("ERROR", "The menu deosn't existe");
		}
		return ok(model);
	}

	@Override
	public ResponseEntity getMenuListByCategorie(String categorie) {
		Iterable<Menu> menuDB = menuConnector.getMenuList(categorie);
		List<HashMap<String, Object>> menuList = new ArrayList<HashMap<String, Object>>();
		for ( Menu menuElement : menuDB ) {
			System.out.println("menuElt ==> "+menuElement.getIdmenu());
			HashMap<String, Object> menuMap = new HashMap<String, Object>();
			menuMap.put("ref", menuElement.getIdmenu());
			menuMap.put("name", menuElement.getName());
			menuMap.put("price", menuElement.getPrice());
			menuMap.put( "categorie", menuElement.getCategorie());
			menuList.add(menuMap);
		}
		return new ResponseEntity(menuList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getAll() {
		Iterable<Menu> menuDB = menuConnector.getAll();
		List<HashMap<String, Object>> menuList = new ArrayList<HashMap<String, Object>>();

		for (Menu menuElement : menuDB) {
			System.out.println("menuElt ==> "+menuElement.getIdmenu());
			HashMap<String, Object> menuMap = new HashMap<String, Object>();
			menuMap.put("ref", menuElement.getIdmenu());
			menuMap.put("name", menuElement.getName());
			menuMap.put("price", menuElement.getPrice());
			menuMap.put( "categorie", menuElement.getCategorie());
			menuList.add(menuMap);
		}
		return new ResponseEntity(menuList, HttpStatus.OK);
	}

}
