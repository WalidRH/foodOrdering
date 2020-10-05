package com.FoodOrdering.app.FoodOrderingApp.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	@JsonProperty("ref")
	private int idOrder;

	@JsonProperty("orderDate")
	@Column(name = "date_Order")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Timestamp dateOrder;

	@JsonProperty("serveDate")
	@Column(name="serve_date")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Timestamp serveDate;

	@JsonProperty("nbPreson")
	@Column(name="nb_person")
	private int nbPerson;

	@Column(name="quantity_order")
	private double quantity;

	@JsonProperty("trackingStatus")
	@Column(name = "tracking_state")
	private String trackingState;

	@JsonProperty("totalPrice")
	@Column(name = "total_price")
	private double totalPrice;

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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<String, Object> getMenuDataMap(){
		Map<String, Object> menuData = new HashMap<>();
		menuData.put("ref", this.menu.getIdmenu());
		menuData.put("name", this.menu.getName());
		menuData.put("categorie", this.menu.getCategorie());
		menuData.put("price", this.menu.getPrice());
		return menuData;
	}

	public Map<String, Object> getClientDataMap(){
		Map<String, Object> clientData = new HashMap<>();
		clientData.put("idclient",this.client.getIdclient());
		clientData.put("email",this.client.getEmail());
		clientData.put("firstName",this.client.getFirstName());
		clientData.put("lastName",this.client.getLastName());
		clientData.put("role",this.client.getRole());
		return clientData;
	}
}