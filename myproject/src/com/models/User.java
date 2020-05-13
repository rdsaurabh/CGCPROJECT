package com.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name= "USER")
public class User {
@Id
@GeneratedValue
@Column(name="ID")
private int id;
@Column(name="NAME")
private String name;
@Column(name="EMAIL",unique=true,updatable = false)
private String email;
@Column(name="PASSWORD")
private String password;
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
@Column(name="PHONE")
private String phone;
@Column(name="STATUS",length=1)
private int status;
@Column(name="USER_TYPE",length=20)
private String userType;
@Column(name="PROFILE_IMAGE", columnDefinition = " varchar(255) default 'avatar.jpg'")
private String profileImage;
@Column(name="TOKEN",length=255)
private String token;
@Column(name="CREATED_ON",updatable=false,columnDefinition= "timestamp default now()")
private Date createdOn;
@UpdateTimestamp
@Temporal(TemporalType.TIMESTAMP)
@Column(name="MODIFIED_ON")
private Date modifiedOn;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}	
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getProfileImage() {
	return profileImage;
}
public void setProfileImage(String profileImage) {
	this.profileImage = profileImage;
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
}
