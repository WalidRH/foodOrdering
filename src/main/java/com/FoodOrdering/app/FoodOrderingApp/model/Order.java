package com.FoodOrdering.app.FoodOrderingApp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Order database table.
 * 
 */
@Entity
@Table(name="order")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
@Component
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private int idOrder;

	@Column(name = "date_Order")
	private Date dateOrder;

	@Column(name="serve_date")
	private Date serveDate;

	@Column(name="nb_person")
	private int nbPerson;

	private double quantity;

	@Column(name = "trackingStatus")
	private String trackingStatus;

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

	public Date getDateOrder() {
		return this.dateOrder;
	}

	public void setDateOrder(Date date_Order) {
		this.dateOrder = date_Order;
	}

	public Date getDateReady() {
		return this.serveDate;
	}

	public void setDateReady(Date dateReady) {
		this.serveDate = dateReady;
	}

	public int getNbPerson() {
		return this.nbPerson;
	}

	public void setNbPerson(int nbPerson) {
		this.nbPerson = nbPerson;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getTrackingState() {
		return this.trackingStatus;
	}

	public void setTrackingState(String trackingState) {
		this.trackingStatus = trackingState;
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