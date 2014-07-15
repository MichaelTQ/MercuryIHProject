package com.mercury.tests;


import com.mercury.beans.*;
import com.mercury.utils.*;
import org.hibernate.*;

public class HibernateRelationshipTest {
	public static void main(String[] args) {
		HibernateDeleteTest.resetData();
		
		Session session = HibernateUtil.currentSession();
		
		Transaction tx = session.beginTransaction();
		User user = new User("one_to_many", "1@2.com", "2223330000", "Jack",
				"Smith", "password", 'c', "09003", "5 Indepence Way", "Princeton", "NJ");
		Card card0 = new Card("5105105105105199", user, "8", "2050", "VISA");
		Card card1 = new Card("9999999999310005", user, "10", "2020", "MASTER CARD");
		user.addCard(card0);
		user.addCard(card1);
		session.save(user);
		tx.commit();
		
		tx = session.beginTransaction();
		Station station0 = new Station("Test Station", "NJ", "Washington D.C.");
		Station station1 = new Station("Test Station 2", "NY", "Buffalo");
		Ticket ticket = new Ticket(station0, station1, 17, 40.50, null, null);
		session.save(ticket);
		tx.commit();
		
		tx.begin();
		User newUser = new User("transaction_test", "trans@2.com", "2223330000", "Jack",
				"Smith", "password", 'c', "09003", "5 Indepence Way", "Princeton", "NJ");
		Ticket newTicket = new Ticket(station1, station0, 91, 9.9, null, null);
		Order order = new Order(newUser, newTicket, null, "ADAO42", 10);
		session.save(order);
		tx.commit();
		
		HibernateConnectionTest.printAll();
		HibernateUtil.closeSession();
	}
}
