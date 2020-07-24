package com.FoodOrdering.app.FoodOrderingApp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * The persistent class for the Order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
@Component
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDER_IDORDER_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_IDORDER_GENERATOR")
	private int idOrder;

	private String date_Order;

	@Column(name="date_ready")
	private String dateReady;

	@Column(name="nb_person")
	private BigDecimal nbPerson;

	private BigDecimal quantity;

	private String trackingState;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="id_menu")
	private Menu menu;

	public Order() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getDate_Order() {
		return this.date_Order;
	}

	public void setDate_Order(String date_Order) {
		this.date_Order = date_Order;
	}

	public String getDateReady() {
		return this.dateReady;
	}

	public void setDateReady(String dateReady) {
		this.dateReady = dateReady;
	}

	public BigDecimal getNbPerson() {
		return this.nbPerson;
	}

	public void setNbPerson(BigDecimal nbPerson) {
		this.nbPerson = nbPerson;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getTrackingState() {
		return this.trackingState;
	}

	public void setTrackingState(String trackingState) {
		this.trackingState = trackingState;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}