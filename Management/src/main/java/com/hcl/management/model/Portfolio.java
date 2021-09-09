package com.hcl.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int portfolioId;

	@Column(name = "name")
	private String name;

	@Column(name = "total_price")
	private double totalPrice;
	@Column(name = "quantity")
	private int quantity;
	
	

	public Portfolio() {
		super();
	}

	

	public Portfolio(int portfolioId, String name, double totalPrice, int quantity) {
		super();
		this.portfolioId = portfolioId;
		this.name = name;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getPortfolioId() {
		return portfolioId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}

}
