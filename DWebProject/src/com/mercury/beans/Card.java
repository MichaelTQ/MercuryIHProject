package com.mercury.beans;

public class Card {
	private int id;
	private String cardNumber;
	private String exMonth;
	private String exYear;
	private String cardType;
	
	public Card() {}
	public Card(int id, String cardNumber, String exMonth,
			String exYear, String cardType) {
		this.id = id;
		this.cardNumber = cardNumber;
		this.exMonth = exMonth;
		this.exYear = exYear;
		this.cardType = cardType;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tCardNumber: " + this.cardNumber
				+ "\tExMonth: " + this.exMonth + "\tExYear: "
				+ this.exYear + "CardType: " + this.cardType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExMonth() {
		return exMonth;
	}
	public void setExMonth(String exMonth) {
		this.exMonth = exMonth;
	}
	public String getExYear() {
		return exYear;
	}
	public void setExYear(String exYear) {
		this.exYear = exYear;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
