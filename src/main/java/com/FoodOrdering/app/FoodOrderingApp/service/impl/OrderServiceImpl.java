package com.FoodOrdering.app.FoodOrderingApp.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.ClientConnector;
import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.OrderConnector;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;
import com.FoodOrdering.app.FoodOrderingApp.service.interfaces.OrderService;
import static org.springframework.http.ResponseEntity.ok;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderConnector orderCon;

	@Autowired
	ClientConnector clientCon;

	@Override
	public ResponseEntity makeOrder(Order order, String email) {
		Client client = clientCon.getClient(email);
		Map<String, Object> model;
		if (client != null) {
			order.setClient(client);
			order = orderCon.insertOrder(order);
			model = this.setModelOrder(order);
		}
		else {
			model = new HashMap<String, Object>();
			model.put("ERROR", "Cannot find the user");
		}
		return ok(model);
	}

	@Override
	public ResponseEntity updateOrder(Order order, String email) {
		Map<String, Object> model;
		if (order != null 
				&& orderCon.getByIdOrder(order.getIdOrder()) != null 
				&& order.getClient().getIdclient() == clientCon.getClient(email).getIdclient()) {
			order = orderCon.editOrder(order);
			model = this.setModelOrder(order);
		}
		else {
			model = new HashMap<String, Object>();
			model.put("ERROR", "Can't update order");
		}
		
		return ok(model);
	}

	@Override
	public ResponseEntity getOrder(int idOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity trackCommande(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity getOrder(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity getOrder(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity getPrebookingOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	private Map<String, Object> setModelOrder(Order order) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Ref", order.getIdOrder());
		model.put("IdMenu", order.getMenu().getIdmenu());
		model.put("Quantity", order.getQuantity());
		model.put("Tracking-Status", order.getTrackingState());
		model.put("Order-Date", order.getDateOrder());
		if (order.getDateReady() != null && order.getNbPerson() == 0) {
			model.put("ref", order.getIdOrder());
			model.put("ref", order.getIdOrder());
		}
		return model;
	}

}
