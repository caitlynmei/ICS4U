package com.bayviewglen.dayOneArrays;

public class Contact {
	
	// complete the class by adding appropriate constructors, get, set methods, etc.
	
	private String lname;
	private String fname;
	private String phone;
	
	public Contact() {
		
	}
	
	public Contact(String lname, String fname, String phone) {
		super();
		this.lname = lname;
		this.fname = fname;
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
