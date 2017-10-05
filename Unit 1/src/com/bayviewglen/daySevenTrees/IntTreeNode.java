package com.bayviewglen.daySevenTrees;

public class IntTreeNode {

	private int data; // data to contact for phone number 
	private IntTreeNode left;
	private IntTreeNode right;
	
	public IntTreeNode() {
		super();
		data  = 0;
		left = null;
		right = null;
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

	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public IntTreeNode getLeft() {
		return left;
	}
	
	public void setLeft(IntTreeNode left) {
		this.left = left;
	}
	
	public IntTreeNode getRight() {
		return right;
	}
	
	public void setRight(IntTreeNode right) {
		this.right = right;
	}

}
