package com.bayviewglen.daySevenTrees;

public class BinarySearchTree {
	
	IntTreeNode root;
	
	public BinarySearchTree() {
		super();
		this.root = null;
	}
	
	public BinarySearchTree(IntTreeNode root) {
		super();
		this.root = root;
	}
	
	public void add(IntTreeNode current, int x) {
		IntTreeNode temp = new IntTreeNode(x);
		
		if (current == null) { // fix this one
			current = temp;
		} else if (current.getData() > x) {// left
			add(current.getLeft(), x);
		} else if (current.getData() <= x) {
			add(current.getRight(), x);
		}
	}
	
	public void add(int x) {
		if (root == null) {
			IntTreeNode temp = new IntTreeNode(x);
			root = temp;
		} else {
			add(root, x);
		}
	}
	
	// traversals
	
	public void inorderTraversal(IntTreeNode current) {
		if (current.getLeft() != null){ // left subtree
			inorderTraversal (current.getLeft());
		} 
		
		evaluate(current); // process root
		
		if (current.getRight() != null) {
			inorderTraversal(current.getRight());
		}
		
	}
	
	public void preorderTraversal(IntTreeNode current) {
		if (current.getLeft() != null){ // left subtree
			inorderTraversal (current.getLeft());
		} 
		// no else if, or you won't get to the right child 
		if (current.getRight() != null) {
			inorderTraversal(current.getRight());
		}
			
		evaluate(current); // process root
	}
	
	public void postorderTraversal(IntTreeNode current) {

		
	}
	
	
	private void evaluate(IntTreeNode current) {
		System.out.println(current.getData());
	}
	
	
	
	// Getters and Setters
	

	public IntTreeNode getRoot() {
		return root;
	}

	public void setRoot(IntTreeNode root) {
		this.root = root;
	}

	
	

}
