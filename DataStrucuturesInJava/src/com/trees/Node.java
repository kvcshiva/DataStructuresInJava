package com.trees;

import com.trees.Node;

public class Node {
	private int nodeData;
	
	private Node leftChildNodeRef;
	private Node rightChildNodeRef;
	
	public int getNodeData() {
		return nodeData;
	}
	public void setNodeData(int nodeData) {
		this.nodeData = nodeData;
	}
	
	public Node getLeftChildNodeRef() {
		return leftChildNodeRef;
	}
	public void setLeftChildNodeRef(Node leftChildNodeRef) {
		this.leftChildNodeRef = leftChildNodeRef;
	}
	
	public Node getRightChildNodeRef() {
		return rightChildNodeRef;
	}
	public void setRightChildNodeRef(Node rightChildNodeRef) {
		this.rightChildNodeRef = rightChildNodeRef;
	}
	
	public Node(int intNodeData, Node leftChildNodeRef, Node rightChildNodeRef) {
		this.nodeData = intNodeData;
		this.leftChildNodeRef = leftChildNodeRef;
		this.rightChildNodeRef = rightChildNodeRef;
	}
	
	public void displayTreeNodeInfo() {
		System.out.println(this.nodeData);
	}
}