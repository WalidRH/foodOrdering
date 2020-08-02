package com.FoodOrdering.app.FoodOrderingApp;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.FoodOrdering.app.FoodOrderingApp.connector.impl.MenuConnectorImpl;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;
import com.FoodOrdering.app.FoodOrderingApp.service.impl.AuthenticationServiceImpl;
import com.FoodOrdering.app.FoodOrderingApp.service.impl.MenuServiceImpl;
import com.FoodOrdering.app.FoodOrderingApp.service.impl.OrderServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
class FoodOrderingAppApplicationTests {

	@Autowired
	AuthenticationServiceImpl authService;
	
	@Autowired
	MenuServiceImpl menuService;
	
	@Autowired
	MenuConnectorImpl menuCon;
	
	@Autowired
	OrderServiceImpl orderService;
	
	@Autowired
	Client client;
	
	@Autowired
	Order order;
	
	@Autowired
	Menu menu;
	
	@Test
	void serviceAuthentication() {
		System.out.println("START TEST");
		authService.login("testWalid@gmail.com", "wiwi12345");
	}
	
	@Test
	void SignUP() {
		System.out.println("START TEST - SIGNUP");
		client.setEmail("testWalid@gmail.com");
		client.setFirstName("Walid");
		client.setLastName("Rahou");
		client.setPassword("wiwi12345");
		client.setRole("ADMIN");
		authService.signUp(client);
	}
	
	@Test
	void newMenu() {
		System.out.println("START TEST - ADDING MENU");
		menu.setName("emince Poulet");
		menu.setPrice(36);
		menuService.addMenu(menu);
	}
	
	@Test
	void getAllMenu() {
		System.out.println("START TEST - ADDING MENU");
		System.out.println("----> "+menuService.getAll());
	}
	
	@Test
	void testMakeOrder() {
		System.out.println("START TEST - MAKE ORDER");
		menu = menuCon.getMenu(2);
		order.setMenu(menu);
		order.setDateOrder(new Date());
		order.setQuantity(3);
		order.setTrackingState("Onprepare");
		System.out.println("----> "+orderService.makeOrder(order, "testWalid@gmail.com") );
	}
	
	@Test
	void testGetOrder() {
		System.out.println("START TEST - GET ORDER BY ID");
		orderService.getOrder(3);
	}

}
