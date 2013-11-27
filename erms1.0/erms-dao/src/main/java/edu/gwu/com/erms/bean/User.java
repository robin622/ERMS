package edu.gwu.com.erms.bean;

import java.util.Date;

import org.bson.types.ObjectId;

public class User {
	private ObjectId _id;
	private String name;
	private String password;
	private String email;
	private Date date;
	private double status;
	public double getStatus() {
		return status;
	}
	public void setStatus(double status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
