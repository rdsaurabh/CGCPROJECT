package com.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="TBLORDER")
public class Order {
@Id
@GeneratedValue
@Column(name="ID")
private int id;
@Column(name="TOTAL")
private double total;
@Column(name="STATUS")
private int status;
@Column(name="USER_ID")
private int userId;
@Column(name="DELIVERY_ADDRESS")
private String deliveryAddress;
@CreationTimestamp
@Column(name="CREATED_ON")
private Date createdOn;
@UpdateTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(name="MODIFIED_ON")
private Date modifiedOn;
@Transient
private List<OrderItems> orderItems;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getDeliveryAddress() {
	return deliveryAddress;
}
public void setDeliveryAddress(String deliveryAddress) {
	this.deliveryAddress = deliveryAddress;
}
public Date getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}
public Date getModifiedOn() {
	return modifiedOn;
}
public void setModifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
}
public void setOrderItems(List<OrderItems> orderItems) {
	this.orderItems = orderItems;
}
public List<OrderItems> getOrderItems() {
	return orderItems;
}
}
