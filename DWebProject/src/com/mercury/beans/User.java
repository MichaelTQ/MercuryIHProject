package com.mercury.beans;

import javax.persistence.*;

@Entity
@Table(name="all_user")
public class User {
	// User fields
	private int id;
	private String username;
	private String email;
	private String phone;
	private String firstName;
	private String lastName;
	private String password;
	private char type;
	
	// Address fields
	private String zip_code;
	private String street;
	private String city;
	private String state;
	
	public User() {}
	public User(String email, String username, String phone, 
			String firstName, String lastName, String password,
			char type, String zip_code, String street, String city,
			String state) {
		//this.id = id;
		this.email = email;
		this.username = username;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.type = type;
		
		this.zip_code = zip_code;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "\tUsername: " + this.username + "\tEmail: " +
				this.email + "\tPhone: " + this.phone + "\tFName: " +
				this.firstName + "\tLName: " + this.lastName + "\tPassword: " + 
				this.password + "\n\tAddressID: " + "\tType: " + this.type +
				"\tZipCode: " + this.zip_code + "\tStreet: " + this.street +
				"\tCity: " + this.city + "\tState: " + this.state;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique=true, nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="username", unique=true, nullable=false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="email", unique=true, nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="password", nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="type", nullable=false)
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
	@Column(name="zip_code")
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	
	@Column(name="street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
