package com.bayviewglen.daySevenTrees;

public class ContactTreeNode {

	private Contact data; // data to contact for phone number 
	private ContactTreeNode left;
	private ContactTreeNode right;
	
	// constructors
	
	public ContactTreeNode() {
		super();
		this.data  = null;
		this.left = null;
		this.right = null;
	}
	
	public ContactTreeNode(Contact data) {
		super();
		this.data = data;
		left = null;
		right = null;
	}
	
	public ContactTreeNode(Contact data, ContactTreeNode left, ContactTreeNode right) {
		super();
		this.data  = data;
		this.left = left;
		this.right = right;
	}

	// data
	
	public Contact getData() {
		return data;
	}
	
	public void setData(Contact data) {
		this.data = data;
	}
	
	/*
	public void setData(Object data) {
		this.data = (Integer) null;
	}
	*/
	
	// left
	
	public ContactTreeNode getLeft() {
		return left;
	}
	
	public void setLeft(ContactTreeNode left) {
		this.left = left;
	}
	
	// right
	
	public ContactTreeNode getRight() {
		return right;
	}
	
	public void setRight(ContactTreeNode right) {
		this.right = right;
	}
}
