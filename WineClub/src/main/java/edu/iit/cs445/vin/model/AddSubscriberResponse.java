package edu.iit.cs445.vin.model;

// Boundary class for the response generated by adding a subscriber
// TO-DO: make it into an abstract class used by AddSubscriber and extended by 
// the TestDriver

public class AddSubscriberResponse {
	private int ID;
	private boolean status;
	private String failureDescription;
	
	public AddSubscriberResponse(int id, boolean s, String f) {
		this.ID = id;
		this.status = s;
		this.failureDescription = f;
	}
	
	public void printResponse() {
		System.out.println("ID: " + this.ID + "\tStatus: " + this.status + "\tDescription: " + this.failureDescription);
	}

	public int getID() {
		return ID;
	}

	public boolean isStatus() {
		return status;
	}

	public String getFailureDescription() {
		return failureDescription;
	}
}
