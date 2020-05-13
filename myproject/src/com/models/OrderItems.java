package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItems {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "ORDER_ID")
	private int orderId;
	@Column(name = "PRODUCT_ID")
	private int productId;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "MRP")
	private double mrp;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
}
