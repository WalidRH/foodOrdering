package com.FoodOrdering.app.FoodOrderingApp.connector.impl;

import java.util.Date;

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
	public Iterable<Order> getByDateOrder(Date dateOrder) {
		return orderRepo.findByDateOrder(dateOrder);
	}

	@Transactional
	@Override
	public Iterable<Order> getByServeDate(Date serveDate) {
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
	public Order insertOrder(Order order) {
		return orderRepo.save(order);
	}

	@Transactional
	@Override
	public Order editOrder(Order order) {
		Order orderEntity = this.getByIdOrder(order.getIdOrder());
		orderEntity.setDateOrder(order.getDateOrder());
		orderEntity.setDateReady(order.getDateReady());
		orderEntity.setMenu(order.getMenu());
		orderEntity.setNbPerson(order.getNbPerson());
		orderEntity.setQuantity(order.getQuantity());
		orderEntity.setTrackingState(order.getTrackingState());
		return orderRepo.save(orderEntity);
	}

	@Transactional
	@Override
	public Iterable<Order> getByServeDateWhenNotNull() {
		return orderRepo.findByServeDateNotNull();
	}

}
