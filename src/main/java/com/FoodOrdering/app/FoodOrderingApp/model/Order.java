package com.FoodOrdering.app.FoodOrderingApp.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


/**
 * The persistent class for the Order database table.
 * 
 */
@Entity
@Table(name="ordering")
@Component
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_order")
	private int idOrder;

	@Column(name = "date_Order")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Timestamp dateOrder;

	@Column(name="serve_date")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Timestamp serveDate;

	@Column(name="nb_person")
	private int nbPerson;

	@Column(name="quantity_order")
	private double quantity;

	@Column(name = "tracking_state")
	private String trackingState;

	@Transient
	private long numberOrders;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Menu
	@ManyToOne(cascade = {CascadeType.ALL},
			fetch = FetchType.EAGER)
	@JoinColumn(name="id_menu")
	private Menu menu;

	public Order() {
	}

	public Order( Client clientEntity, Menu menuEntity, long numberOrders ) {
		this.client = clientEntity;
		this.menu = menuEntity;
		this.numberOrders = numberOrders;
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Timestamp getDateOrder() {
		return dateOrder;
	}

	public Timestamp getServeDate() {
		return serveDate;
	}

	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}

	public void setServeDate(Timestamp serveDate) {
		this.serveDate = serveDate;
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

	public long getNumberOrders() {
		return numberOrders;
	}
}