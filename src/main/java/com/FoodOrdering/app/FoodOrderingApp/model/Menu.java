package com.FoodOrdering.app.FoodOrderingApp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
@Component
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idmenu")
	private int idmenu;

	private String name;

	private String categorie;

	private double price;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="menu")
	private List<Order> orders;

	public Menu() {
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getIdmenu() {
		return this.idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setMenu(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setMenu(null);

		return order;
	}

}