package com.FoodOrdering.app.FoodOrderingApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.FoodOrdering.app.FoodOrderingApp.service.impl.AuthenticationServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
class FoodOrderingAppApplicationTests {

	@Autowired
	AuthenticationServiceImpl authService;
	
	@Test
	void serviceAuthentication() {
		System.out.println("START TEST");
		authService.login("emailTest@gmail.com", "123456");
	}

}
