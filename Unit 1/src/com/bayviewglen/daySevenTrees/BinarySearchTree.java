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
	
	// insertions
	
	public void add(IntTreeNode current, int value) {
		if (current == null) {
			root = new IntTreeNode(value);
		} else if (current.getData() > value) { // left side
			add(current.getLeft(), value);
		} else if (current.getData() <= value) { // right side
			add(current.getRight(), value);
		}
	}
	
	
	
	/*
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
	
	*/
	
	// deleting
	public boolean delete(IntTreeNode root, int dltKey) {
		if (root == null) {
			return false;
		} else if (dltKey < root.getData()) {
			return delete(root.getLeft(), dltKey);
		} else if (dltKey >= root.getData()) { // in ppt it only has >
			return delete(root.getRight(), dltKey);
		} else { // dltKey found
			if (root.getLeft() == null) {
				root = root.getRight();
				return true;
			}
		}
		
		return false;
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
		if (current.getLeft() != null) {
			// .... 
		}
		
	}
	
	
	private void evaluate(IntTreeNode current) {
		System.out.println(current.getData());
	}
	
	// searches
	
	// find smallest node 
	public int findSmallest(IntTreeNode root) {
		if (root.getLeft() == null) {
			return root.getData();// ****or address??
		} else {
			return findSmallest(root);
		}
	}
	
	// find largest node
	public int findLargest(IntTreeNode root) {
		if (root.getRight() == null) {
			return root.getData();
		} else {
			return findLargest(root);
		}		
	}
	
	// search method
	public int searchBST(IntTreeNode root, int targetKey) {
		if (root == null) { // empty
			return -1;
		} 
		
		int rootData = root.getData();
		
		if (targetKey < rootData) {
			return searchBST(root.getLeft(), targetKey);
		} else if (targetKey > rootData) {
			return searchBST(root.getRight(), targetKey);
		} else { // found target key
			return root.getData();
		}
	}
	
	// Getters and Setters
	

	public IntTreeNode getRoot() {
		return root;
	}

	public void setRoot(IntTreeNode root) {
		this.root = root;
	}

	
	

}
