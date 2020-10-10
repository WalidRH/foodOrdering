package com.FoodOrdering.app.FoodOrderingApp.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;

import java.sql.Timestamp;

public interface OrderRepository extends CrudRepository<Order, Integer>{

	public Order findByIdOrder(int id);
	
	public Iterable<Order> findAll();

	@Query("select o from Order o where DATE(o.dateOrder) like :dateOrder")
	public Iterable<Order> findByDateOrder(Timestamp dateOrder);

	@Query("select o from Order o where DATE(o.serveDate) like :serveDate")
	public Iterable<Order> findByServeDate(Timestamp serveDate);
	
	public Iterable<Order> findByNbPerson(int nbPerson);
	
	public Iterable<Order> findByQuantity(double quantity);
	
	public Iterable<Order> findByTrackingState(String trackingState);
	
	public Iterable<Order> findByClient(Client client);
	
	public Iterable<Order> findByMenu(Menu menu);

	@Query("select new com.FoodOrdering.app.FoodOrderingApp.model.Order( o.client, o.menu, count(o) ) from Order o group by o.menu, o.client having count(o) > 3")
	public Iterable<Order> findOrderedMenus();

	public long deleteByIdOrder(int idOrder);
}