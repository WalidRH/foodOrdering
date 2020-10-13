package com.FoodOrdering.app.FoodOrderingApp.connector.impl;

import java.sql.Timestamp;

import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ActionErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.OrderConnector;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;
import com.FoodOrdering.app.FoodOrderingApp.repository.OrderRepository;

@Component
public class OrderConnectorImpl implements OrderConnector {

	@Autowired
	OrderRepository orderRepo;
	
	@Transactional
	@Override
	public Order getByIdOrder(int id) {
		return orderRepo.findByIdOrder(id);
	}
	
	@Transactional
	@Override
	public Iterable<Order> getAll() {
		return orderRepo.findAll();
	}

	@Transactional
	@Override
	public Iterable<Order> getByDateOrder(Timestamp dateOrder) {
		return orderRepo.findByDateOrder(dateOrder);
	}

	@Transactional
	@Override
	public Iterable<Order> getByServeDate(Timestamp serveDate) {
		return orderRepo.findByServeDate(serveDate);
	}

	@Transactional
	@Override
	public Iterable<Order> getByNbPerson(int nbPerson) {
		return orderRepo.findByNbPerson(nbPerson);
	}

	@Transactional
	@Override
	public Iterable<Order> getByQuantity(double quantity) {
		return orderRepo.findByQuantity(quantity);
	}

	@Transactional
	@Override
	public Iterable<Order> getByTrackingStatus(String trackingStatus) {
		return orderRepo.findByTrackingState(trackingStatus);
	}

	@Transactional
	@Override
	public Iterable<Order> getByClient(Client client) {
		return orderRepo.findByClient(client);
	}

	
	@Transactional
	@Override
	public Iterable<Order> getByMenu(Menu menu) {
		return orderRepo.findByMenu(menu);
	}

	@Transactional
	@Override
	public Iterable<Order> getOrderedMenus() {
		return orderRepo.findOrderedMenus();
	}

	@Transactional
	@Override
	public boolean deleteOrder(int idOrder) {
		return ( this.orderRepo.deleteByIdOrder(idOrder) == 1 )? true : false;
	}


	@Transactional
	@Override
	public Order insertOrder(Order order) {
		return orderRepo.save(order);
	}

	@Transactional
	@Override
	public Order editOrder(Order order) {
		try{
			Order orderEntity = this.getByIdOrder(order.getIdOrder());
			orderEntity.setDateOrder(order.getDateOrder());
			orderEntity.setServeDate(order.getServeDate());
			orderEntity.setMenu(order.getMenu());
			orderEntity.setNbPerson(order.getNbPerson());
			orderEntity.setQuantity(order.getQuantity());
			orderEntity.setTrackingState(order.getTrackingState());
			orderEntity.setTotalPrice(order.getMenu().getPrice() * order.getQuantity());
			return orderRepo.save(orderEntity);
		} catch (RuntimeException e){
			throw new ActionErrorException("Can't Update Order");
		}
	}
}
