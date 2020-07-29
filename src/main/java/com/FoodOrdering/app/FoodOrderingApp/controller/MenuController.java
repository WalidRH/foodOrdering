package com.FoodOrdering.app.FoodOrderingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public ResponseEntity findMenu(@RequestParam("id") int id) {
		return menuSerive.getMenu(id);
	}
}
