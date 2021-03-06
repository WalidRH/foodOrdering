package com.FoodOrdering.app.FoodOrderingApp.connector.Interface;

import com.FoodOrdering.app.FoodOrderingApp.model.Menu;

public interface MenuConnector {

	Menu getMenu(int id);
	Menu getMenu(String name);
	Iterable<Menu> getMenuList(String categorie);
	Iterable<Menu> getAll();
	Menu saveMenu(Menu menu);
	Menu editMenu(Menu menu);
}
