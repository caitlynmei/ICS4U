package com.bayviewglen.daySevenTrees;

public class BinarySearchTreeTesting {
	
	IntTreeNode root;
	
	public BinarySearchTreeTesting() {
		super();
		this.root = null;
	}
	
	public BinarySearchTreeTesting(IntTreeNode root) {
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
		} else if (value > root.getData()) { // right side
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
	/* initial method I started with 
	// private delete method (takes in node)
		private boolean delete(IntTreeNode root, int dltKey) { // change root to parent 
			IntTreeNode current = root;
			boolean isLeft = false;
			
			if (current == null) {
				return false;
				
			} else if (dltKey < current.getData()) { // left
				return delete(current.getLeft(), dltKey);
			} else if (dltKey > current.getData()) { // right 
				return delete(current.getRight(), dltKey);
				
			} else if (current.getData() != dltKey){ 
				return false;
			} else { // dltKey found
				if (current.getLeft() == null && current.getRight() == null) { // no children, node is a leaf
					// track if on left or right side 
				} else if (root.getLeft() == null) { 
					root = root.getRight();
				} else if (root.getRight() == null) {
					root = root.getLeft();
				} else if (root.getRight() != null && root.getLeft() != null){ // have L and R children --> find largest node on the left side 
					//root = root.getLeft();
					IntTreeNode tempLeft = root.getLeft();
					IntTreeNode largestLeft = findLargestRemove(tempLeft);
					
					// find largest node from the parent.getLeft() side and replaces the parent with the greatest left node 
					int tempData = largestLeft.getData(); 
					
					root.setData(tempData); // replace root with data from largest node on left 
					tempLeft.setRight(null);  // null the largest node on left of root
					//largestLeft = null;
				}
				return true;
			}
		}
		*/

		private boolean delete(IntTreeNode root, int dltKey) { // change root to parent 
			IntTreeNode parent = searchParent(root, dltKey);
			
			// checking
			if (parent != null) {
				System.out.println("Parent: " + parent.getData());
			} else {
				System.out.println("Parent Null");
			}
			
			//boolean isLeft = false;
			
			if (parent == null && root.getData() != dltKey) {
				return false;
			// if root is the one you want to delete 
				/*
			} else if (dltKey < parent.getLeft().getData()) { // left
				return delete(parent.getLeft(), dltKey);
			} else if (dltKey > parent.getData()) { // right 
				return delete(parent.getRight(), dltKey);
			*/
			} else if (parent == null && root.getData() == dltKey) {
				parent = root;
				return deleteRoot(parent, dltKey);
			} else { // dltKey found		
				// node on left
				if (parent.getLeft().getData() == dltKey) { 
					// Case 1: no children
					if (parent.getLeft().getLeft() == null && parent.getLeft().getRight() == null) { 
						parent.setLeft(null);
					// Case 2: one child 
					} else if (parent.getLeft().getLeft() == null) { 
						parent.setLeft(parent.getLeft().getRight());
					} else if (parent.getLeft().getRight() == null) {
						parent.setRight(parent.getLeft().getRight());
					// Case 3: 2 children
					} else if (parent.getLeft().getLeft() != null && parent.getLeft().getRight() != null) {
						IntTreeNode largestLeft = findLargestRemove(parent.getLeft().getLeft());						
						parent.getLeft().setData(largestLeft.getData());
						delete(largestLeft, dltKey);						
					}
				// node on right		
				} else if (parent.getRight().getData() == dltKey) { 
					// Case 1: no children
					if (parent.getRight().getLeft() == null && parent.getRight().getRight() == null) { 
						parent.setRight(null);
					// Case 2: one child 
					} else if (parent.getRight().getLeft() == null) { 
						parent.setRight(parent.getRight().getRight());
					} else if (parent.getRight().getRight() == null) {
						parent.setRight(parent.getRight().getRight());
					// Case 3: 2 children
					} else if (parent.getRight().getLeft() != null && parent.getRight().getRight() != null) {
						IntTreeNode largestLeft = findLargestRemove(parent.getRight().getLeft());						
						parent.getRight().setData(largestLeft.getData());
						delete(largestLeft, dltKey);						
					}
				}
				return true;
			}
		}
		
	
	// deleting: if dltKey is root
	public boolean deleteRoot(IntTreeNode parent, int dltKey) {
		// node on left
			// Case 1: no children
			if (parent.getLeft() == null && parent.getRight() == null) { 
				parent = null;
			// Case 2: one child 
			} else if (parent.getLeft() == null) { 
				parent = parent.getRight();
			} else if (parent.getRight() == null) {
				parent = parent.getLeft();
			// Case 3: 2 children
			} else if (parent.getLeft() != null && parent.getRight() != null) {
				IntTreeNode largestLeft = findLargestRemove(parent.getLeft());						
				parent.setData(largestLeft.getData());
				delete(largestLeft, largestLeft.getData());						
			}
		return true;
	}
		
	// deleting: check if dltKey is found
	public IntTreeNode searchParent(IntTreeNode current, int targetKey) {	
		if ((current.getLeft() != null && targetKey == current.getLeft().getData())
				|| (current.getRight() != null && targetKey == current.getRight().getData())) {
			return current;
		} else if (targetKey > current.getData() && current.getRight() != null) {
			return searchParent(current.getRight(), targetKey);
		} else if (targetKey < current.getData() && current.getLeft() != null) {
			return searchParent(current.getLeft(), targetKey);
		} else {
			return null;
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
			return 0;
		} 
			
		if (targetKey < root.getData()) {
			return searchBST(root.getLeft(), targetKey);
		} else if (targetKey > root.getData()) {
			return searchBST(root.getRight(), targetKey);
		} else { // found target key (root.getData() == targetKey)
			return root.getData(); // return contact 
		}
	}
}
