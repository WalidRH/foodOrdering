package com.FoodOrdering.app.FoodOrderingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.service.impl.MenuServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/menu")
public class MenuController {

	@Autowired
	MenuServiceImpl menuSerive;
	
	@RequestMapping(value = "/find",
			params = { "id" },
			method = RequestMethod.GET)
	public ResponseEntity findMenuById(@RequestParam("id") int id) {
		return menuSerive.getMenu(id);
	}
	
	
	@RequestMapping(value = "/find",
			params = { "name" },
			method = RequestMethod.GET)
	public ResponseEntity findMenuByName(@RequestParam("name") String name) {
		return menuSerive.getMenu(name);
	}
	
	
	@RequestMapping(value = "/findAll",
			method = RequestMethod.GET)
	public ResponseEntity findAll() {
		return menuSerive.getAll();
	}
	
	@PostMapping(value="/add",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity addMenu(@RequestBody Menu menu) {
		return menuSerive.addMenu(menu);
	}
	
	
	@PutMapping( value="/edit",
			consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity editMenu( @RequestBody Menu menu ) {
		return menuSerive.updateMenu(menu);
	}
	
	
	
	
}
