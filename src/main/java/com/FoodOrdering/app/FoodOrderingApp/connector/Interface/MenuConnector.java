package com.FoodOrdering.app.FoodOrderingApp.connector.Interface;

import com.FoodOrdering.app.FoodOrderingApp.model.Menu;

public interface MenuConnector {

	Menu getMenu(int id);
	Menu getMenu(String name);
	Menu AddMenu(Menu menu);
	Menu EditMenu(Menu menu);
}
