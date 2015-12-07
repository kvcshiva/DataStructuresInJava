package com.linkedlist;

public class LinkedListTester {
public static void main(String[] args) {
		
		LinkedList theLinkedList = new LinkedList();
		
		// Insert Link and add a reference to the book Link added just prior
		// to the field next
		theLinkedList.insertNodeAtHead("Employee 1","Address 1","EMP1");
		theLinkedList.insertNodeAtHead("Employee 2","Address 2","EMP2");
		theLinkedList.insertNodeAtHead("Employee 3","Address 3","EMP3");
		theLinkedList.insertNodeAtHead("Employee 4","Address 4","EMP4");
		theLinkedList.insertNodeAtHead("Employee 5","Address 5","EMP5");
		
		//theLinkedList.listAllNodes();
		
		//System.out.println("Printing the linked list nodes using recursion.");
		//theLinkedList.listAllNodesRecursively(theLinkedList.getFirstLink());
		
		//System.out.println("Printing the linked list nodes in reverse using recursion.");
		//theLinkedList.listAllNodesInReverseRecursively(theLinkedList.getFirstLink());
				
		//theLinkedList.insertNodeAtTail("Employee 5","Address 5","EMP5");
		
		//theLinkedList.insertNodeAtPosition("Employee 5","Address 5","EMP5",0);
		//theLinkedList.insertNodeAtPositionFromTailV2("Employee 5","Address 5","EMP5",1);
		//theLinkedList.getFirstLink().display();
		
		//theLinkedList.insertNodeAtPositionFromTailRecursively(theLinkedList.getFirstLink(),"Employee 5","Address 5","EMP5",0,0);
		//theLinkedList.listAllNodes();
		
		//theLinkedList.findNodeAtPosition(3);
		
		// DELETING NODE @ HEAD
		/*theLinkedList.deleteNodeAtHead();		
		theLinkedList.deleteNodeAtHead();		
		theLinkedList.deleteNodeAtHead();
		theLinkedList.deleteNodeAtHead();
		theLinkedList.deleteNodeAtHead();*/
		
		// DELETING NODE @ TAIL
		/*
		theLinkedList.deleteNodeAtTail();
		theLinkedList.deleteNodeAtTail();
		theLinkedList.deleteNodeAtTail();
		theLinkedList.deleteNodeAtTail();
		*/
		
		//DELETE a NODE @ GIVEN POSITION from HEAD
		//theLinkedList.deleteNodeAtGivenPositionFromHead(5);
		//theLinkedList.deleteNodeAtGivenPositionFromTailV2(5);
		theLinkedList.deleteNodeAtGivenPositionFromTailRecursively(theLinkedList.getFirstLink(),1,0);
		//theLinkedList.reverseALinkedList();
		
		//theLinkedList.reverseALinkedListRecursivePush(null,theLinkedList.getFirstLink(),null);
		theLinkedList.listAllNodes();
	}
}
