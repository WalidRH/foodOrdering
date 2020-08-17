package com.FoodOrdering.app.FoodOrderingApp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.ItalicAction;

import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.MenuConnector;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import org.apache.logging.log4j.util.SystemPropertiesPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	MenuConnector menuCon;

	@Autowired
	ClientConnector clientCon;

	@Override
	public ResponseEntity makeOrder(Order order, String email, int id) {
		Client client = clientCon.getClient(email);
		Map<String, Object> model;
		if (client != null) {
			order.setClient(client);
			Menu menu = menuCon.getMenu(id);
			if ( menu != null ) {
				order.setMenu(menu);
				long now = System.currentTimeMillis();
				Timestamp date = new Timestamp(now);

				order.setDateOrder(date);
				order = orderCon.insertOrder(order);
				model = this.setModelOrder(order);
			}else{
				model = new HashMap<String, Object>();
				model.put("ERROR", "New Menu");
			}
		}
		else {
			model = new HashMap<String, Object>();
			model.put("ERROR", "Cannot find the user");
		}
		return ok(model);
	}

	@Override
	public ResponseEntity updateOrder(Order order) {
		Map<String, Object> model;
		if (order != null && orderCon.getByIdOrder(order.getIdOrder()) != null) {
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
		Order order = orderCon.getByIdOrder(idOrder);
		return ok(this.setModelOrder(order));
	}

	@Override
	public ResponseEntity trackCommande(String trackingStatus) {
		Iterable<Order> orderList = orderCon.getByTrackingStatus(trackingStatus);
		List<HashMap<String, Object>> orderLitMap = this.getOrderListMap(orderList);
		return new ResponseEntity(orderLitMap, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getOrderbyOrderdate(String dateOrder) {
		List<HashMap<String, Object>> orderLitMap;
		Timestamp dateOrdered = Timestamp.valueOf(dateOrder);
		Iterable<Order> ordersList = orderCon.getByDateOrder(dateOrdered);
		List<Order> ordersWithSameDateTime = new ArrayList<>();
		for (Order orderItem: ordersList) {
			Timestamp dbDateOrder = orderItem.getDateOrder();
			if (dbDateOrder.equals(dateOrdered)){
				ordersWithSameDateTime.add(orderItem);
			}
		}
		if (!ordersWithSameDateTime.isEmpty()) {
			ordersList = ordersWithSameDateTime;
		}
		orderLitMap = this.getOrderListMap(ordersList);
		return new ResponseEntity(orderLitMap, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity getOrder(String clientEmail) {
		Client client = clientCon.getClient(clientEmail);
		Iterable<Order> orderList = orderCon.getByClient(client);
		List<HashMap<String, Object>> orderLitMap = this.getOrderListMap(orderList);
		return new ResponseEntity(orderLitMap, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getPrebookingOrder( String reserveDate) {
		Timestamp dateReserving = Timestamp.valueOf(reserveDate);
		Iterable<Order> orderList = orderCon.getByServeDate(dateReserving);
		List<HashMap<String, Object>> orderLitMap = this.getOrderListMap(orderList);
		return new ResponseEntity(orderLitMap, HttpStatus.OK);
	}

	private List<HashMap<String,Object>> getOrderListMap(Iterable<Order> orderList){
		List<HashMap<String, Object>> orderLitMap = new ArrayList<HashMap<String, Object>>();
		for (Order orderItem : orderList) {
			orderLitMap.add(this.setModelOrder(orderItem));
		}
		return orderLitMap;
	}
	
	private HashMap<String, Object> setModelOrder(Order order) {
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("Ref", order.getIdOrder());
		model.put("IdMenu", order.getMenu().getIdmenu());
		model.put("Quantity", order.getQuantity());
		model.put("Tracking-Status", order.getTrackingState());
		model.put("Order-Date", order.getDateOrder());
		if (order.getServeDate() != null && order.getNbPerson() == 0) {
			model.put("ref", order.getIdOrder());
			model.put("ref", order.getIdOrder());
		}
		return model;
	}

}
