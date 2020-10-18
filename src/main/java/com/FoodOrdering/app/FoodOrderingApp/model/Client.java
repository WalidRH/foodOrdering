package com.FoodOrdering.app.FoodOrderingApp.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
@Component
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String idclient;
	
	@Column(name="email")
	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;

	@Column(name="phone")
	private String phone;
	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="client")
	private List<Order> orders;

	public Client() {
	}

}