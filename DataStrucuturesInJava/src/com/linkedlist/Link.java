package com.linkedlist;

public class Link {
	private String empName;
	private String empAddress;
	private String empID;
	
	private Link nextNodeAddress;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public Link getNextNodeAddress() {
		return nextNodeAddress;
	}

	public void setNextNodeAddress(Link nextNodeAddress) {
		this.nextNodeAddress = nextNodeAddress;
	}
	
	public Link(String strEmpName,String strEmpAddress,String strEmpID){
		this.empName=strEmpName;
		this.empAddress=strEmpAddress;
		this.empID=strEmpID;
	}
	
	public void display()
	{	         
		System.out.println(this.empName + ": " + this.empAddress + " : "+this.empID);
	}
	
}
