package com.shweta.springwebservices.sportyshoes.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;

	@Column(name = "username")
	private String name;

	@Column(name = "city")
	private String city;

	@Column(name = "login_at", nullable = false, updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate  loginAt;

	@OneToOne(mappedBy="user" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Order order;
	
	public Users() {
	}

	public Users(String name, String city, LocalDate loginAt) {
		super();
		this.name = name;
		this.city = city;
		this.loginAt = loginAt;
	}
	
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getLoginAt() {
		return loginAt;
	}

	public void setLoginAt(LocalDate loginAt) {
		this.loginAt = loginAt;
	}

}
