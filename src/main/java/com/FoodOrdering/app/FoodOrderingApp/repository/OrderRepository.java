package com.FoodOrdering.app.FoodOrderingApp.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{
	public Order findByIdOrder(int id);
	
	public Iterable<Order> findAll();
	
	public Iterable<Order> findByDateOrder(Date dateOrder);
	
	public Iterable<Order> findByServeDate(Date serveDate);
	
	public Iterable<Order> findByNbPerson(int nbPerson);
	
	public Iterable<Order> findByQuantity(double quantity);
	
	public Iterable<Order> findByTrackingStatus(String trackingStatus);
	
	public Iterable<Order> findByClient(Client client);
	
	public Iterable<Order> findByMenu(Menu menu);
	
	public Iterable<Order> findByServeDateNotNull();
}
