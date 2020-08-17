package com.FoodOrdering.app.FoodOrderingApp.service.interfaces;

import java.sql.Date;
import java.sql.Timestamp;

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
	 * @return
	 */
	public ResponseEntity updateOrder(Order order);
	
	/**
	 * get order by id
	 * @param idOrder
	 * @return
	 */
	public ResponseEntity getOrder(int idOrder);
	
	/**
	 * return the track status of the order
	 * @param trackStatus
	 * @return
	 */
	public ResponseEntity trackCommande(String trackStatus);
	
	/**
	 * get list of orders by date
	 * @param date
	 * @return
	 */
	public ResponseEntity getOrderbyOrderdate(String date);

	/**
	 * get list of orders by client
	 * @param clientEmail
	 * @return
	 */
	public ResponseEntity getOrder(String clientEmail);
	
	/**
	 * 
	 * get list of orders pre-booked
	 * 
	 * @return
	 */
	
	public ResponseEntity getPrebookingOrder( String reserveDate);
	
	
	
	
}
