package com.linkedlist;

public class LinkedList {
	static int intTotalNodes;
	private Link firstLink;
	
	public Link getFirstLink() {
		return this.firstLink;
	}

	public void setFirstLink(Link firstLink) {
		this.firstLink = firstLink;
	}

	public LinkedList(){		
		// Here to show the first Link always starts as null		
		this.firstLink=null;		
	}
	
	// Returns true if LinkList is empty	
	public boolean isEmpty(){		
		return(this.firstLink==null);
	}
	
	public void insertNodeAtHead(String strEmpName, String strEmpAddress,String strEmpID){		
		Link newLink = new Link(strEmpName,strEmpAddress,strEmpID);		
		// Connects the firstLink field to the new Link		
		newLink.setNextNodeAddress(this.firstLink);		
		this.firstLink=newLink;		
	}
	
	public void deleteNodeAtHead(){	
		//getting the node at HEAD
		Link nodeAtHead2Delete=this.firstLink;
		if(nodeAtHead2Delete!=null) {
			// make the node AFTER the CURRENT NODE @ HEAD that is to be deleted as the NEW NODE @ HEAD
			this.firstLink=nodeAtHead2Delete.getNextNodeAddress();
			System.out.print("The NODE deleted at HEAD was : ");
			nodeAtHead2Delete.display();
		}
		else
		{
			System.out.print("The list is empty.");
		}
	}
	
	public void listAllNodes(){
		System.out.println("Looping and printing the linked list nodes.");
		Link theLink=this.firstLink;
		
		// Start at the reference stored in firstLink and
		// keep getting the references stored in next for
		// every Link until next returns null		
		while(theLink!=null){			
			theLink.display();			
			//System.out.println("Next Link: " + theLink.getNextNodeAddress());			
			theLink = theLink.getNextNodeAddress();			
		}
		System.out.println("----------------------------------------------");
	}
	
	public void listAllNodesRecursively(Link theLink){		
		if(theLink==null){
			return;
		}
		theLink.display(); // printing the value at that particular node		
		listAllNodesRecursively(theLink.getNextNodeAddress()); // calling the recursive print method by passing the next node's address
	}
	
	public void listAllNodesInReverseRecursively(Link theLink){		
		if(theLink==null){
			return;
		}
		listAllNodesInReverseRecursively(theLink.getNextNodeAddress()); // calling the recursive print method by passing the next node's address
		theLink.display(); // printing the value at that particular node
	}
	
	public void insertNodeAtTail(String strEmpName, String strEmpAddress,String strEmpID){
		System.out.println("Inserting node at the tail.");
		Link theLink=this.firstLink;
		while(theLink.getNextNodeAddress()!=null){ // traversing to the end of the LinkedList and getting the last node	
			theLink=theLink.getNextNodeAddress();
		}
		Link newLink = new Link(strEmpName,strEmpAddress,strEmpID);
		newLink.setNextNodeAddress(null);
		theLink.setNextNodeAddress(newLink);
	}
	
	//-- VJ's Code --
	public void deleteNodeAtTail() {
         Link theLink = this.firstLink;
         if (theLink == null) {// check if the linked list is null
             System.out.print("The list is empty.");
             return;
         }

         System.out.print("The NODE deleted at TAIL was : ");
         if (theLink.getNextNodeAddress() == null) { // if there is only 1 NODE in the LinkedList
             this.firstLink = null;
             theLink.display();
             return;
         }
         
         // if there are more than 1 NODEs in the LinkedList
         while (theLink.getNextNodeAddress().getNextNodeAddress() != null) { // traversing the second last node
              theLink=theLink.getNextNodeAddress();
         }
         theLink.setNextNodeAddress(null);
	}
	
	public void insertNodeAtPositionFromHead(String strEmpName,String strEmpAddress,String strEmpID,int intPosition){
		Link theLink = this.firstLink;
		// revised code by VJ
		int intLoopIndex = 1;
		Link newLink = new Link(strEmpName,strEmpAddress,strEmpID);
		
		if(intPosition == 0){
			System.out.println("Invalid entry.");
			return;
		}
		if(intPosition == 1){
			newLink.setNextNodeAddress(theLink);
			firstLink=newLink;
			return;
		}
		
		// traverse to get the node before the user specified position
		while(theLink.getNextNodeAddress() != null && intLoopIndex < intPosition - 1){
			theLink = theLink.getNextNodeAddress();
			intLoopIndex += 1;
		}
		
		if(intLoopIndex != intPosition - 1){
			System.out.println("Invalid entry.");
			return;
		}
		
		newLink.setNextNodeAddress(theLink.getNextNodeAddress()); // make the new node point to the '2ndOfTheOldPair'
		theLink.setNextNodeAddress(newLink);// make the '1stOfTheOldPair' node to point to the newly CREATED & INSERTED node
						
		/* orignal code by SKV
		while(theLink!=null){
			if(intPosition==0){
				// below code similar to INSERT @ HEAD NODE
				Link newLink = new Link(strEmpName,strEmpAddress,strEmpID);		
				newLink.setNextNodeAddress(this.firstLink); // make the newly created & inserted node to point to the old node that was at the head.		
				this.firstLink=newLink; //make HEAD node point to the new node that is created
				return;
			}
			else if(intLoopIndex==intPosition-1){ // we have to traverse to 1 node (call it the '1stOfTheOldPair') less than the given position to insert a new node
				Link newLink = new Link(strEmpName,strEmpAddress,strEmpID);
				newLink.setNextNodeAddress(theLink.getNextNodeAddress()); // make the new node point to the '2ndOfTheOldPair'
				theLink.setNextNodeAddress(newLink);// make the '1stOfTheOldPair' node to point to the newly CREATED & INSERTED node
				return;
			}
			theLink=theLink.getNextNodeAddress();
			intLoopIndex+=1;
		}
		System.out.print("Node index "+intPosition+" does not exist.");
		*/
	}
	
	//ver 1.0 - brute force
	public void insertNodeAtPositionFromTail(String strEmpName,String strEmpAddress,String strEmpID,int intPosition){
		Link theLink = this.firstLink;
		int intTotalNodes = 0;
		while(theLink != null){
			intTotalNodes += 1;
			theLink = theLink.getNextNodeAddress();
		}
		
		if(intPosition > intTotalNodes + 1){
			System.out.println("Invalid entry");
			return;
		}
		intPosition = (intTotalNodes - intPosition) + 2; //calculating the new node position from HEAD
		insertNodeAtPositionFromHead(strEmpName,strEmpAddress,strEmpID,intPosition); // calling the existing insert at given position from HEAD
	}
	
	// ver 2.0 two pointer solution second pointer will always be intPosition behind the first pointer
	// start running the second pointer after the first pointer reaches the intPosition
	public void insertNodeAtPositionFromTailV2(String strEmpName, String strEmpAddress, String strEmpID, int intPosition) {
		Link theLink = this.firstLink;
		Link secondLink = this.firstLink;
		int intTotalNodes = 0;

		if (intPosition == 0) {
			System.out.println("Invalid entry.");
			return;
		}

		while (theLink != null) {
			if (intTotalNodes >= intPosition) {
				secondLink = secondLink.getNextNodeAddress();
			}
			intTotalNodes = intTotalNodes + 1;
			theLink = theLink.getNextNodeAddress();
		}
		
		if (intPosition > (intTotalNodes + 1)) {
			System.out.println("Invalid entry.");
			return;
		}
		
		Link newLink = new Link(strEmpName, strEmpAddress, strEmpID);
		if(intPosition == (intTotalNodes + 1)){
			newLink.setNextNodeAddress(this.firstLink);
			this.firstLink=newLink;
		}
		else
		{
			newLink.setNextNodeAddress(secondLink.getNextNodeAddress());
			secondLink.setNextNodeAddress(newLink);
		}
	}
	
	// insert at a position from tail using Recursion -- VJ's Code --
	public void insertNodeAtPositionFromTailRecursively(Link theLink, String strEmpName, String strEmpAddress, String strEmpID, int intPosition, int intRecursiveCallIndex) {
		if (theLink == null) {
			intTotalNodes = intRecursiveCallIndex;
			intRecursiveCallIndex--;
			return;
		}

		intRecursiveCallIndex = intRecursiveCallIndex + 1;
		insertNodeAtPositionFromTailRecursively(theLink.getNextNodeAddress(),strEmpName, strEmpAddress, strEmpID, intPosition,intRecursiveCallIndex);

		if ((intPosition == (intTotalNodes + 1)) && (intRecursiveCallIndex == 1)) { // Change this if condition for insertion from tail
			Link newLink = new Link(strEmpName, strEmpAddress, strEmpID);
			newLink.setNextNodeAddress(firstLink);
			firstLink = newLink;
		}

		if (intRecursiveCallIndex == intTotalNodes - (intPosition - 1)) { // change this if condition for insertion from tail
			Link newLink = new Link(strEmpName, strEmpAddress, strEmpID);
			newLink.setNextNodeAddress(theLink.getNextNodeAddress());
			theLink.setNextNodeAddress(newLink);
		}
		intRecursiveCallIndex = intRecursiveCallIndex - 1;
	}

	public void findNodeAtPosition(int intPosition){
		System.out.println("Printing the node details at given position.");
		Link theLink=this.firstLink;
		int intLoopIndex=0;
		
		while(theLink!=null){
			if(intLoopIndex==intPosition){
				System.out.print("The NODE @ position "+intPosition+" is => ");
				theLink.display();
				return;
			}
			theLink=theLink.getNextNodeAddress();
			intLoopIndex+=1;
		}
		System.out.print("Node index "+intPosition+" does not exist.");
	}
	

	public void deleteNodeAtGivenPositionFromHead(int intPosition){
		Link theLink = this.firstLink;
		int intLoopIndex = 1;
		
		if(intPosition == 0){
			System.out.println("Invalid entry.");
			return;
		}
		if(intPosition == 1){
			firstLink=theLink.getNextNodeAddress();
			return;
		}
		
		// traverse to get the node before the user specified position
		while(theLink.getNextNodeAddress() != null && intLoopIndex < (intPosition - 1)){
			theLink = theLink.getNextNodeAddress();
			intLoopIndex += 1;
		}
		
		if((intLoopIndex != intPosition - 1) || theLink.getNextNodeAddress() == null){
			System.out.println("Invalid entry.");
			return;
		}
		
		theLink.setNextNodeAddress(theLink.getNextNodeAddress().getNextNodeAddress());
	}
	
	//ver 1.0 - brute force
	public void deleteNodeAtGivenPositionFromTail(int intPosition){
		if(intPosition == 0){
			System.out.println("Invalid entry.");
			return;
		}
		Link theLink = this.firstLink;
		int intTotalNodes = 0;
		while(theLink != null){
			intTotalNodes += 1;
			theLink = theLink.getNextNodeAddress();
		}
		
		if(intPosition > intTotalNodes + 1){
			System.out.println("Invalid entry");
			return;
		}
		intPosition = (intTotalNodes - intPosition) + 1; //calculating the new node position from HEAD
		deleteNodeAtGivenPositionFromHead(intPosition); // calling the existing delete at given position from HEAD
	}
	
	// ver 2.0
	public void deleteNodeAtGivenPositionFromTailV2(int intPosition) {
		// here two pointers are used, the secondPointer starts running after the firstPointer crosses the intPosition
		// so, when the firstPointer reaches the end (null) the secondPointer will be at the (intPosition + 1) which is to be deleted
		// from the LinkedList
		Link theLink = this.firstLink;
		Link secondLink = this.firstLink;
		int intTotalNodes = 0;

		if (intPosition == 0) { // if the position entered is 0 then invalid position
			System.out.println("Invalid entry.");
			return;
		}
		
		while (theLink != null) {
			if (intTotalNodes >= intPosition + 1) {
				secondLink = secondLink.getNextNodeAddress();
			}
			intTotalNodes = intTotalNodes + 1;
			theLink = theLink.getNextNodeAddress();
		}
		
		if (intPosition >= (intTotalNodes + 1)) {
			System.out.println("Invalid entry.");
			return;
		}
		
		if (intPosition == intTotalNodes) { // if last node FROM TAIL (the node at the HEAD) is to be deleted
			this.firstLink=secondLink.getNextNodeAddress();
		}
		else{ // for all other nodes to be deleted from the TAIL
			secondLink.setNextNodeAddress(secondLink.getNextNodeAddress().getNextNodeAddress());
		}
	}
	
	public void deleteNodeAtGivenPositionFromTailRecursively(Link theLink, int intPositionFromTail, int intRecursiveCallIndex) {
		// EXIT Condition : iterate/call the method recursively till the Last Node in the LL has been reached 
		if (theLink == null) {
			intTotalNodes = intRecursiveCallIndex;
			return; // to terminate the push and start the pop(s)
		}
		
		// for computing the total no. of nodes in the LL
		intRecursiveCallIndex = intRecursiveCallIndex + 1; // this also serves as a marker to every node / function call during the push
		
		// call the method recursively with next node of the current node
		deleteNodeAtGivenPositionFromTailRecursively(theLink.getNextNodeAddress(),intPositionFromTail,intRecursiveCallIndex);
				
		//if the Node at head / First Node (traversing from tail while the method is popping) is to be deleted,
		//corner case that is to be handled explicitly
		if (intPositionFromTail == intTotalNodes) {
			this.firstLink=theLink.getNextNodeAddress(); // make the HEAD ptr point to the next node of the First Node
		}

		//Check if the node/method call has been reached (while popping) which was loaded during the pushes
		// this is also similar to the brute force technique
		if (intRecursiveCallIndex == intTotalNodes - intPositionFromTail) {
			theLink.setNextNodeAddress(theLink.getNextNodeAddress().getNextNodeAddress());
		}
	}
	
	public void reverseALinkedList() {
		Link currentLink = this.firstLink;
		Link prevLink = null;
		Link nextLink = null;
		
		if(currentLink == null){
			System.out.println("LinkedList is empty.");
			return;
		}

		while (currentLink != null) {
			nextLink = currentLink.getNextNodeAddress();
			currentLink.setNextNodeAddress(prevLink);
			prevLink = currentLink; // for the next loop make the currentLink as the prevLink
			currentLink = nextLink; // for the next loop make the nextLink as the currentLink
		}
		this.firstLink = prevLink; // make the last node as the HEAD node
	}
	
	public void reverseALinkedListRecursivePop(Link currentLink){
		if(currentLink.getNextNodeAddress() == null){  // base case or stop condition for the recursive method
			this.firstLink=currentLink; // make the last node as the head node
			return;
		}
		
		reverseALinkedListRecursivePop(currentLink.getNextNodeAddress());
		currentLink.getNextNodeAddress().setNextNodeAddress(currentLink); // for every current link get the NEXT NODE and make it to point to the currentLink itself
		currentLink.setNextNodeAddress(null); // destroying the old link of currentLink which WAS pointing to the next node
	}
	
	public void reverseALinkedListRecursivePush(Link prevLink, Link currentLink, Link nextLink){
		if(currentLink.getNextNodeAddress() == null){  // base case or stop condition for the recursive method
			this.firstLink = currentLink; // make the last node as the head node
			firstLink.setNextNodeAddress(prevLink);
			return;
		}

		nextLink = currentLink.getNextNodeAddress();
		currentLink.setNextNodeAddress(prevLink);
		prevLink = currentLink; // for the next loop make the currentLink as the prevLink
		currentLink = nextLink; // for the next loop make the nextLink as the currentLink

		reverseALinkedListRecursivePush(prevLink, currentLink, nextLink);
	}
}