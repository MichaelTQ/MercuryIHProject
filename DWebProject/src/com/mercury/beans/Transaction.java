package com.mercury.beans;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="transaction")
public class Transaction {
	private int id;
//	private int userID;
	private User user;
//	private int ticketID;
	private Ticket ticket;
	private Timestamp orderTime;
	
	public Transaction() {}
	public Transaction (User user, Ticket ticket, Timestamp orderTime) {
		this.user = user;
		this.ticket = ticket;
		this.orderTime = orderTime;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tUserID: " + this.user.getId() +
				"\tTicketID: " + this.ticket.getId() + "\tOrderTime: "
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name="ticket_id")
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	@Column(name="order_time")
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
}
