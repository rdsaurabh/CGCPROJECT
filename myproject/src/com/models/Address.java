package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ADDRESS")
public class Address {
@Id
@GeneratedValue
@Column(name="ID")
private int id;
@Column(name="USER_ID")
private int userId;
@Column(name="STREET")
private String street;
@Column(name="LANDMARK")
private String landmark;
@Column(name="PHONE")
private String phone;
@Column(name="CITY")
private String city;
@Column(name="STATE")
private String state;
@Column(name="COUNTRY")
private String country;
@Column(name="PINCODE")
private int pincode;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}

public String getCompleteAddress() {
	return street+","+landmark+","+city+","+state+","+country+","+phone+","+pincode;
}

}
