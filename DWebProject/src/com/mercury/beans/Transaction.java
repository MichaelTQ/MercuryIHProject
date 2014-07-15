package com.mercury.beans;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="transaction")
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
	
	@Column(name="user_id", nullable=false)
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	@Column(name="ticket_id", nullable=false)
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	@Column(name="order_time")
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
}
