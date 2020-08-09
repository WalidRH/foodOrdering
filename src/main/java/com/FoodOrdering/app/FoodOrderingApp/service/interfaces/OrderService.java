package com.FoodOrdering.app.FoodOrderingApp.service.interfaces;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;

public interface OrderService {
	
	/**
	 * insert a new order made by the client
	 * 
	 * fill the order data by getting client's id from the client's email
	 * @param order
	 * @return
	 */

	public ResponseEntity makeOrder(Order order, String email, int id);
	
	
	/**
	 * updating the existing commande
	 * @param order
	 * @param email
	 * @return
	 */
	public ResponseEntity updateOrder(Order order, String email);
	
	/**
	 * get order by id
	 * @param order
	 * @return
	 */
	public ResponseEntity getOrder(int idOrder);
	
	/**
	 * return the track status of the order
	 * @param orderId
	 * @return
	 */
	public ResponseEntity trackCommande(String trackStatus);
	
	/**
	 * get list of orders by date
	 * @param date
	 * @return
	 */
	public ResponseEntity getOrder(Date date);
	
	/**
	 * get list of orders by client
	 * @param client
	 * @return
	 */
	public ResponseEntity getOrder(String clientEmail);
	
	/**
	 * 
	 * get list of orders pre-booked
	 * 
	 * @return
	 */
	
	public ResponseEntity getPrebookingOrder();
	
	
	
	
}
