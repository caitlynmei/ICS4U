package com.bayviewglen.daySevenTrees;

public class BinarySearchTree {

	ContactTreeNode root;

	public BinarySearchTree() {
		super();
		this.root = null;
	}

	public BinarySearchTree(ContactTreeNode root) {
		super();
		this.root = root;
	}

	// --- Getters and Setters ---

	public ContactTreeNode getRoot() {
		return root;
	}

	public void setRoot(ContactTreeNode root) {
		this.root = root;
	}

	// --- insertions ---

	// public add method from driver
	public void add(Contact value) {
		root = add(root, value);
	}

	// private add method (takes in node)
	private ContactTreeNode add(ContactTreeNode root, Contact value) {
		if (root == null) {
			root = new ContactTreeNode(value);
			return root;
		} else if (value.compareTo(root.getData()) < 0) { // left side
			root.setLeft(add(root.getLeft(), value));
		} else if (value.compareTo(root.getData()) >= 0) { // right side
			root.setRight(add(root.getRight(), value));
		}

		return root;
	}

	// --- delete ---

	// public delete method from driver
	public boolean delete(String dltKey) {
		if (root == null) {
			return false;
		} else if (root.getData().getFullName().equals(dltKey)) { // if root == dltKey
			return deleteRoot(dltKey);
		} else {
			return delete(root, dltKey);
		}
	}

	// private delete method (takes in node)
	private boolean delete(ContactTreeNode root, String dltKey) { // change root to parent
		ContactTreeNode parent = searchParent(root, dltKey);

		/*
		// checking (testing)
		if (parent != null) {
			System.out.println("Parent: " + parent.getData().getFullName());
		} else {
			System.out.println("Parent Null");
		}
		*/

		if (parent == null) { // dltKey not found
			return false;
		} else { // dltKey found
			// node on left
			if ((parent.getLeft() != null) && (parent.getLeft().getData().getFullName().equals(dltKey))) {
				// Case 1: no children
				if (parent.getLeft().getLeft() == null && parent.getLeft().getRight() == null) {
					parent.setLeft(null);
					// Case 2: one child
				} else if (parent.getLeft().getLeft() == null) {
					parent.setLeft(parent.getLeft().getRight());
				} else if (parent.getLeft().getRight() == null) {
					parent.setLeft(parent.getLeft().getLeft());
					// Case 3: 2 children
				} else if (parent.getLeft().getLeft() != null && parent.getLeft().getRight() != null) {
					ContactTreeNode largestLeft = findLargestRemove(parent.getLeft());
					parent.getLeft().setData(largestLeft.getData());
					findLargestParent(parent.getLeft(), largestLeft).setRight(null);
				}
				// node on right
			} else if ((parent.getRight() != null) && (parent.getRight().getData().getFullName().equals(dltKey))) {
				// Case 1: no children
				if (parent.getRight().getLeft() == null && parent.getRight().getRight() == null) {
					parent.setRight(null);
					// Case 2: one child
				} else if (parent.getRight().getLeft() == null) {
					parent.setRight(parent.getRight().getRight());
				} else if (parent.getRight().getRight() == null) {
					parent.setRight(parent.getRight().getLeft());
					// Case 3: 2 children
				} else if (parent.getRight().getLeft() != null && parent.getRight().getRight() != null) {
					ContactTreeNode largestLeft = findLargestRemove(parent.getRight());
					parent.getRight().setData(largestLeft.getData());
					findLargestParent(parent.getRight(), largestLeft).setRight(null);
				}
			}
			return true;
		}
	}

	// deleting: if dltKey is root
	public boolean deleteRoot(String dltKey) {
		// Case 1: no children
		if (root.getLeft() == null && root.getRight() == null) {
			root = null;
			// Case 2: one child
		} else if (root.getLeft() == null) {
			root.setData(root.getRight().getData());
			root.setRight(null);
		} else if (root.getRight() == null) {
			root.setData(root.getLeft().getData());
			root.setLeft(null);
			// Case 3: 2 children
		} else if (root.getLeft() != null && root.getRight() != null) {
			ContactTreeNode largestLeft = findLargestRemove(root.getLeft());
			root.setData(largestLeft.getData());
			if (root.getLeft().getRight() != null) {
				findLargestParent(root.getLeft(), largestLeft).setRight(null);
			} else {
				root.setLeft(null);
			}
		}
		return true;
	}

	// deleting: check if dltKey is found
	public ContactTreeNode searchParent(ContactTreeNode current, String targetKey) {
		if ((current.getLeft() != null && targetKey.equals(current.getLeft().getData().getFullName()))
				|| (current.getRight() != null && targetKey.equals(current.getRight().getData().getFullName()))) {
			return current;
		} else if ((targetKey.compareTo(current.getData().getFullName()) > 0) && (current.getRight() != null)) {
			return searchParent(current.getRight(), targetKey);
		} else if ((targetKey.compareTo(current.getData().getFullName()) < 0) && (current.getLeft() != null)) {
			return searchParent(current.getLeft(), targetKey);
		} else {
			return null;
		}
	}

	// deleting: find largest from left node
	private ContactTreeNode findLargestRemove(ContactTreeNode current) {
		if (current.getRight() == null) {
			return current;
		} else {
			return findLargestRemove(current.getRight());
		}
	}

	// deleting: find the parent of the largest left node
	private ContactTreeNode findLargestParent(ContactTreeNode parent, ContactTreeNode largestLeft) {
		if (parent.getRight() == largestLeft) {
			return parent;
		} else {
			return findLargestRemove(parent.getRight());
		}
	}

	// --- traversals ---

	// inOrder traversal
	public void inorderTraversal(ContactTreeNode current) {
		if (current.getLeft() != null) { // left subtree
			inorderTraversal(current.getLeft());
		}

		evaluate(current); // process root

		if (current.getRight() != null) {
			inorderTraversal(current.getRight());
		}

	}

	// preOrder traversal
	public void preorderTraversal(ContactTreeNode current) {
		if (current.getLeft() != null) { // left subtree
			inorderTraversal(current.getLeft());
		}
		// no else if, or you won't get to the right child
		if (current.getRight() != null) {
			inorderTraversal(current.getRight());
		}

		evaluate(current); // process root
	}

	// postOrder traversal
	public void postorderTraversal(ContactTreeNode current) {
		if (current.getLeft() != null) {
			postorderTraversal(current.getLeft());
		}

		if (current.getRight() != null) {
			postorderTraversal(current.getRight());
		}

		evaluate(current); // process root
	}

	// evaluating node from traversals
	private void evaluate(ContactTreeNode current) {
		System.out.println("- " + current.getData().getLname() + ", " + current.getData().getFname() + " ("
				+ current.getData().getPhone() + ")");
	}

	// --- searches ---

	// find smallest
	public Contact findSmallest(ContactTreeNode root) {
		if (root.getLeft() == null) {
			return root.getData();
		} else {
			return findSmallest(root.getLeft());
		}
	}

	// find largest
	public Contact findLargest(ContactTreeNode root) {
		if (root.getRight() == null) {
			return root.getData();
		} else {
			return findLargest(root.getRight());
		}
	}

	// search method
	public Contact searchBST(ContactTreeNode root, String targetKey) {
		if (root == null) { // empty
			return null;
		} else if ((targetKey.compareTo(root.getData().getFullName()) < 0)) {
			return searchBST(root.getLeft(), targetKey);
		} else if ((targetKey.compareTo(root.getData().getFullName()) > 0)) {
			return searchBST(root.getRight(), targetKey);
		} else { // found target key (root.getData() == targetKey)
			return root.getData(); // return contact
		}
	}
}
