package com.FoodOrdering.app.FoodOrderingApp.connector.Interface;

import java.sql.Timestamp;

import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;

public interface OrderConnector {
	
	public Order getByIdOrder(int id);
	
	public Order insertOrder(Order order);
	
	public Order editOrder(Order order);
	
	public Iterable<Order> getAll();
	
	public Iterable<Order> getByDateOrder(Timestamp dateOrder);
	
	public Iterable<Order> getByServeDate(Timestamp serveDate);
	
	public Iterable<Order> getByNbPerson(int nbPerson);
	
	public Iterable<Order> getByQuantity(double quantity);
	
	public Iterable<Order> getByTrackingStatus(String trackingStatus);
	
	public Iterable<Order> getByClient(Client client);
	
	public Iterable<Order> getByMenu(Menu menu);

	public Iterable<Order> getOrderedMenus();

	public boolean deleteOrder(int idOrder);

}
