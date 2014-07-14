package com.mercury.beans;

import java.sql.Timestamp;

public class Transaction {
	private int id;
	private int userID;
	private int ticketID;
	private Timestamp orderTime;
	
	public Transaction() {}
	public Transaction (int id, int userID, int ticketID,
			Timestamp orderTime) {
		this.id = id;
		this.userID = userID;
		this.ticketID = ticketID;
		this.orderTime = orderTime;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tUserID: " + this.userID +
				"\tTicketID: " + this.ticketID + "\tOrderTime: "
				+ this.orderTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
}
