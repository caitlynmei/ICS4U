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
	
	// --- Getters and Setters ---
	

	public IntTreeNode getRoot() {
		return root;
	}

	public void setRoot(IntTreeNode root) {
		this.root = root;
	}

	// --- insertions ---
	
	// public add method from driver 
	public void add(int value) {
		root = add(root, value);
		
		/*
		if (root == null) {
			root = new IntTreeNode(value);
		} else {
			add(root, value);
		}
		*/
	}
	
	// private add method (takes in node)
	private IntTreeNode add(IntTreeNode root, int value) {
		if (root == null) {
			root = new IntTreeNode(value);
			return root;
		} else if (value < root.getData()) { // left side
			root.setLeft(add(root.getLeft(), value));
		} else if (value >= root.getData()) { // right side
			root.setRight(add(root.getRight(), value));
		}
		
		return root;
	}
	
	/* 
	 * we wrote this one in class  
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
	*/
	
	// --- delete --- 
	
	// public delete method from driver
	public boolean delete(int dltKey) {
		if (root == null) {
			return false;
		} else {
			return delete(root, dltKey);
		}
		
	}
	/*
	// private delete method (takes in node)
		private boolean delete(IntTreeNode root, int dltKey) { // change root to parent 
			if (root == null) {
				return false;
				
			} else if (dltKey < root.getData()) {
				return delete(root.getLeft(), dltKey);
			} else if (dltKey > root.getData()) {
				return delete(root.getRight(), dltKey);
				
			} else { // dltKey found
				if (root.getLeft() == null) { 
					root = root.getRight();
					return true;
				} else if (root.getRight() == null) {
					root = root.getLeft();
					return true;
				} else {//if (root.getRight() != null && root.getLeft() != null){ // have L and R children --> find largest node on the left side 
					//root = root.getLeft();
					IntTreeNode tempLeft = root.getLeft();
					IntTreeNode largestLeft = findLargestRemove(tempLeft);
					
					// find largest node from the parent.getLeft() side and replaces the parent with the greatest left node 
					int tempData = largestLeft.getData(); 
					
					root.setData(tempData); // replace root with data from largest node on left 
					tempLeft.setRight(null);  // null the largest node on left of root
					//largestLeft = null;
					return true;
				}
			}
		}
		*/
	// private delete method (takes in node)
	private boolean delete(IntTreeNode root, int dltKey) { // change root to parent 
		IntTreeNode parent = root;
		IntTreeNode current = root;
		boolean isLeftChild = false;
		
		if (root == null) {
			return false;
		} else {
			while (current.getData() != dltKey) {
				parent = current;
				if (dltKey < current.getData()) {
					isLeftChild = true;
					current = current.getRight();
				} else if (dltKey > current.getData()) {
					current = current.getLeft();
				}
				if (current == null) {
					return false;
				}
			}
		}
			
		// dltKey found
		// Case 1: if node has no children
		if (current.getLeft() == null && current.getRight() == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
			return true;
		
		// Case 2: if node has 1 child 
		} else if (current.getLeft() == null) { 
			parent.setLeft(current.getRight());
			return true;
		} else if (current.getRight() == null) {
			parent.setLeft(current.getLeft());
			return true;
		
		// Case 3: if node has 2 children --> find largest node on the left side 	
		} else {//if (root.getRight() != null && root.getLeft() != null){ // 
			IntTreeNode tempLeft = current.getLeft();
			IntTreeNode largestLeft = findLargestRemove(tempLeft);
			// ^ find largest node from the parent.getLeft() side and replaces the parent with the greatest left node 
				
			current.setData(largestLeft.getData()); // replace root with data from largest node on left side
			//parent.getLeft().setRight(null);  // null the largest node on left of root
			//parent.setLeft(null);
			return true;
		}
	}
	
	// deleting: find largest from left node (remove)
	private IntTreeNode findLargestRemove(IntTreeNode parent) {
		if (parent.getRight() == null) {
			return parent;
		} else {
			return findLargestRemove(parent.getRight());
		}		
	}
	
	
	// --- traversals --- 
	
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
	
	// finish this one... 
	public void postorderTraversal(IntTreeNode current) {
		if (current.getLeft() != null) {
			// .... 
		}
		
	}
	
	private void evaluate(IntTreeNode current) {
		System.out.println(current.getData());
	}
	
	// --- searches ---
	
	// find smallest  
	public int findSmallest(IntTreeNode root) {
		if (root.getLeft() == null) {
			return root.getData();
		} else {
			return findSmallest(root.getLeft());
		}
	}
	
	// find largest 
	public int findLargest(IntTreeNode root) {
		if (root.getRight() == null) {
			return root.getData();
		} else {
			return findLargest(root.getRight());
		}		
	}
	
	// search method
	public int searchBST(IntTreeNode root, int targetKey) {
		if (root == null) { // empty
			return -1;
		} 
			
		if (targetKey < root.getData()) {
			return searchBST(root.getLeft(), targetKey);
		} else if (targetKey > root.getData()) {
			return searchBST(root.getRight(), targetKey);
		} else { // found target key (root.getData() == targetKey)
			return root.getData();
		}
	}
}
