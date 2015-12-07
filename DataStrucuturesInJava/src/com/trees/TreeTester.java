package com.trees;


public class TreeTester {
	public static void main(String[] args) {
		BinaryTree theBinaryTree = new BinaryTree();
		
		/*
		Node newTreeNode=new Node(10,null,null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(5, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(15, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(0, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(41, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(33, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(23, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(45, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(70, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		
		newTreeNode=new Node(20, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTree(newTreeNode);
		*/
		
		
		Node newTreeNode=new Node(10,null,null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(5, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(6, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(15, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(1, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(4, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(0, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(41, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(33, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(23, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(45, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(70, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		
		newTreeNode=new Node(20, null, null);
		theBinaryTree.insertNewNodeIntoBinaryTreeRecursion(newTreeNode, theBinaryTree.getRootNode());
		/*
		theBinaryTree.listAllTreeNodesByInOrderTraversal(theBinaryTree.getRootNode());
		
		//theBinaryTree.deleteNodeFromBinaryTree(41);
		theBinaryTree.deleteNodeFromBinaryTreeUsingRecursion(15,theBinaryTree.getRootNode(),null);
		System.out.println("-------------------------------------------------------");
		
		theBinaryTree.listAllTreeNodesByInOrderTraversal(theBinaryTree.getRootNode());
		*/
		
		//theBinaryTree.breadthFirstSearchUsingQueueDS(theBinaryTree.getRootNode());
		theBinaryTree.breadthFirstSearch(theBinaryTree.getRootNode());
	}
}
