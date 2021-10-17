package com.company.transactions;

public class BinaryTreeTransactions {
	// This represents single node of the binary tree
	static class Node {
		int key;
		Node leftNode;
		Node rightNode;
	}

	// This function is used to create a new node
	static Node createNode(int data) {
		Node newNode = new Node();
		newNode.key = data;
		newNode.leftNode = null;
		newNode.rightNode = null;
		return newNode;

	}

	// This function will be used to traverse through the tree to
	// show that it has no left child
	// This function also lists the elements in ascending order
	public void inOrderTraversalOfSkewedTree(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.key + " -> ");
		inOrderTraversalOfSkewedTree(node.rightNode);
	}

	// This function is used to get the left most node which will be the new root
	// node of the skewed tree
	public Node getNewRootNode(Node node) {
		while (node.leftNode != null) {
			node = node.leftNode;
		}
		return node;
	}

	// This function modifies the given function into a skewed tree.
	public static void modifyBST(Node currentNode) {
		if (currentNode == null) {
			return;
		}
		Node tempNode = currentNode;
		Node leftChild = currentNode.leftNode;
		if (currentNode.leftNode != null) {
			if (currentNode.leftNode.rightNode == null) {
				currentNode.leftNode.rightNode = tempNode;
			} else {
				Node leftChildNode = currentNode.leftNode;
				while (leftChildNode.rightNode != null) {
					leftChildNode = leftChildNode.rightNode;
				}
				leftChildNode.rightNode = tempNode;
			}
			currentNode.leftNode = null;
		}
		modifyBST(leftChild);
	}
}