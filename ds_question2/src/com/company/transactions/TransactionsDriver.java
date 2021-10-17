package com.company.transactions;

import java.util.*;

import com.company.transactions.BinaryTreeTransactions.Node;

public class TransactionsDriver {
	static Scanner scannerObj = new Scanner(System.in);
	static Node tree, newRootNode = null;

	public static void main(String[] args) {
		System.out.println("Welcome to the Application");
		BinaryTreeTransactions binaryTree = new BinaryTreeTransactions();
		System.out.println("Using default Binary search tree");
		tree = BinaryTreeTransactions.createNode(50);
		tree.leftNode = BinaryTreeTransactions.createNode(30);
		tree.rightNode = BinaryTreeTransactions.createNode(60);
		tree.leftNode.leftNode = BinaryTreeTransactions.createNode(10);
		tree.leftNode.rightNode = BinaryTreeTransactions.createNode(40);
		tree.leftNode.leftNode.leftNode = BinaryTreeTransactions.createNode(5);
		tree.leftNode.rightNode.rightNode = BinaryTreeTransactions.createNode(45);
		System.out.println("Converting the tree according to the requirement of NO Left Node ..  ");
		Node newRootNode = binaryTree.getNewRootNode(tree);
		BinaryTreeTransactions.modifyBST(tree);
		binaryTree.inOrderTraversalOfSkewedTree(newRootNode);

	}

}
