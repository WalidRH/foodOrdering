package com.FoodOrdering.app.FoodOrderingApp.controller;

import java.sql.Date;
import java.sql.Timestamp;

import com.FoodOrdering.app.FoodOrderingApp.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;
import com.FoodOrdering.app.FoodOrderingApp.service.impl.OrderServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping(value="/makeOrder",
			params = { "email","idMenu" },
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity makeOrder(@RequestBody Order order, @RequestParam("email") String email, @RequestParam("idMenu") int id) {
		return orderService.makeOrder(order, email, id);
	}
	
	@PutMapping( value="/editOrder",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateOrder(@RequestBody Order order) {
		return orderService.updateOrder(order);
	}
	
	@RequestMapping(value = "/findOrder",
			params = { "id" },
			method = RequestMethod.GET)
	public ResponseEntity getOrder(@RequestParam("id") int idOrder) {
		return orderService.getOrder(idOrder);
	}
	
	@RequestMapping(value = "/findOrder",
			params = { "status" },
			method = RequestMethod.GET)
	public ResponseEntity trackCommande(@RequestParam("status") String trackStatus) {
		return orderService.trackCommande(trackStatus);
		
	}
	
	@RequestMapping(value = "/findOrder",
			params = { "orderDate" },
			method = RequestMethod.GET)
	public ResponseEntity getOrderApi( @RequestParam("orderDate") String date) {
		return orderService.getOrderbyOrderdate(date);
	}
	
	@RequestMapping(value = "/findOrder",
			params = { "emailClient" },
			method = RequestMethod.GET)
	public ResponseEntity getOrder( @RequestParam("emailClient") String clientEmail) {
		return orderService.getOrder(clientEmail);
	}
	
	@RequestMapping(value = "/PreBookingOrders",
			params = { "reserveDate" },
			method = RequestMethod.GET)
	public ResponseEntity getPrebookingOrder(@RequestParam("reserveDate") String reserveDate) {
		return orderService.getPrebookingOrder(reserveDate);
	}

	@RequestMapping(value = "/OrderedMenus",
			params = { "popular" },
			method = RequestMethod.GET)
	public ResponseEntity getPrebookingOrder(@RequestParam("popular") boolean popular) {
		return orderService.getOrderedItems(popular);
	}

}
