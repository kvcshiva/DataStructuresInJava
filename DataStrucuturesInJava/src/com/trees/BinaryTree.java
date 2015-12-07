package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private Node rootNode;

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public BinaryTree() {
		this.rootNode = null;
	}
	
	// INSERT NODE into TREE
	public void insertNewNodeIntoBinaryTree(Node newTreeNode) {
		if(this.rootNode == null) { // if the tree is empty then make the new node as the root node
			this.rootNode = newTreeNode;
			return;
		}
		
		Node currentTreeNode = rootNode;
		Node parentNodeForNewNode = null;
		
		while(currentTreeNode != null) {
			// if the NEW tree node's value < current node's value THEN traverse to the LEFT part of the tree
			if(newTreeNode.getNodeData() < currentTreeNode.getNodeData()) {
				parentNodeForNewNode = currentTreeNode;
				currentTreeNode = currentTreeNode.getLeftChildNodeRef();
			}
			// if the NEW tree node's value > current node's value THEN traverse to the RIGHT part of the tree
			else if(newTreeNode.getNodeData() > currentTreeNode.getNodeData()) {
				parentNodeForNewNode = currentTreeNode;
				currentTreeNode = currentTreeNode.getRightChildNodeRef();
			}
		}
		
		if(newTreeNode.getNodeData() < parentNodeForNewNode.getNodeData()) {
			parentNodeForNewNode.setLeftChildNodeRef(newTreeNode);
		}
		else {
			parentNodeForNewNode.setRightChildNodeRef(newTreeNode);
		}
	}
	
	// INSERT NODE into TREE using Recursion
	Node parentNodeForNewNode4Recursion=null;
	public void insertNewNodeIntoBinaryTreeRecursion(Node newTreeNode, Node currentTreeNode) {
		// base condition : iterate till leaf node is reached i.e where the node has no children 
		// AND if all the conditions of node insertion are satisfied then insert the new node 
		
		// set the nextNode in the tree as currentTreeNode
		// check if the newNode goes to the left or right by comparing its value to the nextNode
		// insertNewNodeIntoBinaryTreeRecursion(newTreeNode,currentTreeNode);
		
		if(this.rootNode == null) { // if the tree is empty then make the new node as the root node
			this.rootNode = newTreeNode;
			return;
		}
		else if(currentTreeNode == null) {
			if(newTreeNode.getNodeData() < parentNodeForNewNode4Recursion.getNodeData()) {
				parentNodeForNewNode4Recursion.setLeftChildNodeRef(newTreeNode);
			}
			else {
				parentNodeForNewNode4Recursion.setRightChildNodeRef(newTreeNode);
			}
			return;
		}
		
		if(newTreeNode.getNodeData() < currentTreeNode.getNodeData()) {
			parentNodeForNewNode4Recursion = currentTreeNode;
			currentTreeNode = currentTreeNode.getLeftChildNodeRef();
		}
		else if(newTreeNode.getNodeData() > currentTreeNode.getNodeData()) {
			parentNodeForNewNode4Recursion = currentTreeNode;
			currentTreeNode = currentTreeNode.getRightChildNodeRef();
		}
		
		insertNewNodeIntoBinaryTreeRecursion(newTreeNode,currentTreeNode);
	}
	
	// List all Tree Nodes using INORDER traversal
	public void listAllTreeNodesByInOrderTraversal(Node treeNode) {
		if(treeNode != null) {
			listAllTreeNodesByInOrderTraversal(treeNode.getLeftChildNodeRef());
			treeNode.displayTreeNodeInfo();
			listAllTreeNodesByInOrderTraversal(treeNode.getRightChildNodeRef());
		}
	}
	
	// DELETE NODE from a TREE
	public void deleteNodeFromBinaryTree(int intValue2Delete) {
		if(this.rootNode == null) { // if the tree is empty return with suitable message
			System.out.println("The tree is empty.");
			return;
		}
		
		Node currentTreeNode = rootNode;
		Node parentNode = null;
		try {
			while(currentTreeNode != null) {
				if(intValue2Delete < currentTreeNode.getNodeData()) {
					parentNode = currentTreeNode;
					currentTreeNode = currentTreeNode.getLeftChildNodeRef();
				}
				else if(intValue2Delete > currentTreeNode.getNodeData()) {
					parentNode = currentTreeNode;
					currentTreeNode = currentTreeNode.getRightChildNodeRef();
				}
				else if(intValue2Delete == currentTreeNode.getNodeData()) {
					//CASE 1: if the node to be deleted is a LEAF NODE
					if(currentTreeNode.getLeftChildNodeRef() == null && currentTreeNode.getRightChildNodeRef() == null) {
						if(parentNode.getLeftChildNodeRef() != null && (intValue2Delete == parentNode.getLeftChildNodeRef().getNodeData())) {
							parentNode.setLeftChildNodeRef(null);
						}
						else if(parentNode.getRightChildNodeRef() !=null && (intValue2Delete == parentNode.getRightChildNodeRef().getNodeData())){
							parentNode.setRightChildNodeRef(null);
						}
					}
					//CASE 2: Node 2B Deleted with only ONE CHILD NODE (either left/right child node)
					else if(currentTreeNode.getLeftChildNodeRef() == null ) { // if there is only RIGHT node for the NODE to be DELETED
						
						// check to which side the Node to be deleted lies to it's Parent Node
						if(parentNode.getLeftChildNodeRef() != null && (intValue2Delete == parentNode.getLeftChildNodeRef().getNodeData())) {
							parentNode.setLeftChildNodeRef(currentTreeNode.getRightChildNodeRef());
						}
						else if(parentNode.getRightChildNodeRef() !=null && (intValue2Delete == parentNode.getRightChildNodeRef().getNodeData())){
							parentNode.setRightChildNodeRef(currentTreeNode.getRightChildNodeRef());
						}
					}						
					else if(currentTreeNode.getRightChildNodeRef() == null) { // if there is only LEFT node for the NODE to be DELETED
						// check to which side the Node to be deleted lies to it's Parent Node
						if(parentNode.getLeftChildNodeRef() != null && (intValue2Delete == parentNode.getLeftChildNodeRef().getNodeData())) {
							parentNode.setLeftChildNodeRef(currentTreeNode.getLeftChildNodeRef());
						}
						else if(parentNode.getRightChildNodeRef() !=null && (intValue2Delete == parentNode.getRightChildNodeRef().getNodeData())){
							parentNode.setRightChildNodeRef(currentTreeNode.getLeftChildNodeRef());
						}
					}
					//CASE 3: Node 2B Deleted having BOTH left & right CHILD NODES
					else {
						//replace the VALUE of the node to be deleted with the value of the LEFT SUBTREE's MAX NODE (i.e, the RIGHT MOST NODE in the Left Subtree)
						Node internalTreeNode = currentTreeNode.getLeftChildNodeRef();
						Node internalParentNode = null;
						while (internalTreeNode.getRightChildNodeRef() != null) { // get the MAX value node in the LEFT SUBTREE
							internalParentNode = internalTreeNode;
							internalTreeNode = internalTreeNode.getRightChildNodeRef();
						}
						
						// swap the VALUES of the NODE to be deleted and the MAX valued node from LEFT SUBTREE
						currentTreeNode.setNodeData(internalTreeNode.getNodeData());
						
						if(internalParentNode == null) {
							currentTreeNode.setLeftChildNodeRef(internalTreeNode.getLeftChildNodeRef());
							return;
						}
						
						if (internalTreeNode.getLeftChildNodeRef() == null) {
							internalParentNode.setRightChildNodeRef(null);
						}
						else {
							internalParentNode.setRightChildNodeRef(internalTreeNode.getLeftChildNodeRef());
						}
					}
					return;
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// DELETE NODE from a TREE using RECURSION
	public void deleteNodeFromBinaryTreeUsingRecursion(int intValue2Delete,Node currentTreeNode,Node parentNode) {
		if(currentTreeNode == null) {
			return;
		}
		
		if(intValue2Delete < currentTreeNode.getNodeData()) {
			parentNode = currentTreeNode;
			currentTreeNode = currentTreeNode.getLeftChildNodeRef();
		}
		else if(intValue2Delete > currentTreeNode.getNodeData()) {
			parentNode = currentTreeNode;
			currentTreeNode = currentTreeNode.getRightChildNodeRef();
		}
		else if(intValue2Delete == currentTreeNode.getNodeData()) {
			//CASE 1: if the node to be deleted is a LEAF NODE
			if(currentTreeNode.getLeftChildNodeRef() == null && currentTreeNode.getRightChildNodeRef() == null) {
				if(parentNode.getLeftChildNodeRef() != null && (intValue2Delete == parentNode.getLeftChildNodeRef().getNodeData())) {
					parentNode.setLeftChildNodeRef(null);
				}
				else if(parentNode.getRightChildNodeRef() !=null && (intValue2Delete == parentNode.getRightChildNodeRef().getNodeData())){
					parentNode.setRightChildNodeRef(null);
				}
			}
			//CASE 2: Node 2B Deleted with only ONE CHILD NODE (either left/right child node)
			else if(currentTreeNode.getLeftChildNodeRef() == null ) { // if there is only RIGHT node for the NODE to be DELETED
				
				// check to which side the Node to be deleted lies to it's Parent Node
				if(parentNode.getLeftChildNodeRef() != null && (intValue2Delete == parentNode.getLeftChildNodeRef().getNodeData())) {
					parentNode.setLeftChildNodeRef(currentTreeNode.getRightChildNodeRef());
				}
				else if(parentNode.getRightChildNodeRef() !=null && (intValue2Delete == parentNode.getRightChildNodeRef().getNodeData())){
					parentNode.setRightChildNodeRef(currentTreeNode.getRightChildNodeRef());
				}
			}						
			else if(currentTreeNode.getRightChildNodeRef() == null) { // if there is only LEFT node for the NODE to be DELETED
				// check to which side the Node to be deleted lies to it's Parent Node
				if(parentNode.getLeftChildNodeRef() != null && (intValue2Delete == parentNode.getLeftChildNodeRef().getNodeData())) {
					parentNode.setLeftChildNodeRef(currentTreeNode.getLeftChildNodeRef());
				}
				else if(parentNode.getRightChildNodeRef() !=null && (intValue2Delete == parentNode.getRightChildNodeRef().getNodeData())){
					parentNode.setRightChildNodeRef(currentTreeNode.getLeftChildNodeRef());
				}
			}
			//CASE 3: Node 2B Deleted having BOTH left & right CHILD NODES
			else {
				//replace the VALUE of the node to be deleted with the value of the LEFT SUBTREE's MAX NODE (i.e, the RIGHT MOST NODE in the Left Subtree)
				Node internalTreeNode = currentTreeNode.getLeftChildNodeRef();
				Node internalParentNode = null;
				while (internalTreeNode.getRightChildNodeRef() != null) { // get the MAX value node in the LEFT SUBTREE
					internalParentNode = internalTreeNode;
					internalTreeNode = internalTreeNode.getRightChildNodeRef();
				}
				
				// swap the VALUES of the NODE to be deleted and the MAX valued node from LEFT SUBTREE
				currentTreeNode.setNodeData(internalTreeNode.getNodeData());
				
				if(internalParentNode == null) {
					currentTreeNode.setLeftChildNodeRef(internalTreeNode.getLeftChildNodeRef());
					return;
				}
				
				if (internalTreeNode.getLeftChildNodeRef() == null) {
					internalParentNode.setRightChildNodeRef(null);
				}
				else {
					internalParentNode.setRightChildNodeRef(internalTreeNode.getLeftChildNodeRef());
				}
			}
			return;
		}
		
		deleteNodeFromBinaryTreeUsingRecursion( intValue2Delete, currentTreeNode, parentNode);
	}
	
	//Breadth First Search v1.0 using Java's inbuilt Queue data structure
	public void breadthFirstSearchUsingQueueDS(Node root) {
		Queue queue=new LinkedList();
	    if (root == null)
	        return;
	    queue.clear();
	    queue.add(root);
	    while(!queue.isEmpty()) {
	        Node node = (Node)queue.remove();
	        System.out.print(node.getNodeData() + " ");
	        if(node.getLeftChildNodeRef() != null) 
	        	queue.add(node.getLeftChildNodeRef());
	        if(node.getRightChildNodeRef() != null) 
	        	queue.add(node.getRightChildNodeRef());
	    }    	    
	}
	
	//Breadth First Search v2.0 using ArrayList
	public void breadthFirstSearch(Node root) {
		if (root == null)
	        return;
		
		ArrayList<Node> aLst = new ArrayList<Node>();
		int intListIndex = 0;
		
		aLst.add(root);
		while(intListIndex <= aLst.size()) {
			Node node = aLst.get(intListIndex);
			System.out.print(node.getNodeData() + " ");
	        if(node.getLeftChildNodeRef() != null) 
	        	aLst.add(node.getLeftChildNodeRef());
	        if(node.getRightChildNodeRef() != null) 
	        	aLst.add(node.getRightChildNodeRef());
	        
	        intListIndex += 1;
		}
	}
}