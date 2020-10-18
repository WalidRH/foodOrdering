package com.FoodOrdering.app.FoodOrderingApp.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */

@Getter
@Setter
@Entity
@Table(name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
@Component
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("ref")
	@Column(name="idmenu")
	private int idmenu;

	private String name;

	private String categorie;

	private double price;

	private String image;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="menu")
	private List<Order> orders;

	public Menu() {
	}

}