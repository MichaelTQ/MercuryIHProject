package com.mercury.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ticket")
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
	
	@Id
	@GenericGenerator(name="kaugen", strategy="increment")
	@GeneratedValue(generator="kaugen")
	@Column(name="id", unique=true, nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="order_number", length=10)
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	@Column(name="from_id", nullable=false)
	public int getFromID() {
		return fromID;
	}
	public void setFromID(int fromID) {
		this.fromID = fromID;
	}
	
	@Column(name="to_id", nullable=false)
	@Check(constraints="from_id > to_id or from_id < to_id")
	public int getToID() {
		return toID;
	}
	public void setToID(int toID) {
		this.toID = toID;
	}
	
	@Column(name="max_num")
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	@Column(name="price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(name="start_time")
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	@Column(name="arrive_time")
	public Timestamp getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Timestamp arriveTime) {
		this.arriveTime = arriveTime;
	}
}
