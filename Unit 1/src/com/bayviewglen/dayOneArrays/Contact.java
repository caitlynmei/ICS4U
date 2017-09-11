package com.bayviewglen.dayOneArrays;

import java.util.Comparator;

public class Contact implements Comparator <Contact> {
	
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
	
	public int compareTo(Object o) {
		Contact c = (Contact) o; 
		String a = this.lname + this.fname;
		String b = c.lname + c.fname; 
		
		return a.compareTo(b);
	}
	
	public int compare(Contact a, Contact b) {
		String c = a.lname + a.fname;
		String d = b.lname + b.fname;
		return c.compareTo(d); 
	}
	
}
