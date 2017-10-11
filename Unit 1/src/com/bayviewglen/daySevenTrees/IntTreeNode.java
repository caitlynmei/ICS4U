package com.bayviewglen.daySevenTrees;

public class IntTreeNode {

	private int data; // data to contact for phone number 
	private IntTreeNode left;
	private IntTreeNode right;
	
	// constructors
	
	public IntTreeNode() {
		super();
		this.data  = 0;
		this.left = null;
		this.right = null;
	}
	
	public IntTreeNode(int data) {
		super();
		this.data = data;
		left = null;
		right = null;
	}
	
	public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
		super();
		this.data  = data;
		this.left = left;
		this.right = right;
	}

	// data
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	/*
	public void setData(Object data) {
		this.data = (Integer) null;
	}
	*/
	
	// left
	
	public IntTreeNode getLeft() {
		return left;
	}
	
	public void setLeft(IntTreeNode left) {
		this.left = left;
	}
	
	// right
	
	public IntTreeNode getRight() {
		return right;
	}
	
	public void setRight(IntTreeNode right) {
		this.right = right;
	}

	

}
