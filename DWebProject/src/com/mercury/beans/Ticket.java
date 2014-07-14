package com.mercury.beans;

import java.sql.Timestamp;

public class Ticket {
	private int id;
	private String orderNumber;
	private int fromID;
	private int toID;
	private int maxNumber;
	private double price;
	private Timestamp startTime;
	private Timestamp arriveTime;
	
	public Ticket() {}
	public Ticket(int id, String orderNumber, int fromID,
			int toID, int maxNumber, double price,
			Timestamp startTime, Timestamp arriveTime) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.fromID = fromID;
		this.toID = toID;
		this.maxNumber = maxNumber;
		this.price = price;
		this.startTime = startTime;
		this.arriveTime = arriveTime;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tOrderNumber: " + this.orderNumber
				+ "\tfromID: " + this.fromID + "\ttoID: " + this.toID
				+ "\tmaxNumber: " + this.maxNumber + "\tPrice: "
				+ this.price + "\tStartTime: " + this.startTime
				+ "\tArriveTime: " + this.arriveTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getFromID() {
		return fromID;
	}
	public void setFromID(int fromID) {
		this.fromID = fromID;
	}
	public int getToID() {
		return toID;
	}
	public void setToID(int toID) {
		this.toID = toID;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Timestamp arriveTime) {
		this.arriveTime = arriveTime;
	}
}
