package com.mercury.tests;

import java.util.List;

import com.mercury.beans.*;
import com.mercury.utils.*;
import org.hibernate.*;
import org.hibernate.Transaction;

public class HibernateRelationshipTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		User user = (User) session.get(User.class, 3);
		if (user != null) {
			session.delete(user);
		}
		tx.commit();
		
		tx = session.beginTransaction();
		user = new User("one_to_many", "1@2.com", "2223330000", "Jack",
				"Smith", "password", 'c', "09003", "5 Indepence Way", "Princeton", "NJ");
		Card card0 = new Card("5105105105105199", user, "8", "2050", "VISA");
		Card card1 = new Card("9999999999310005", user, "10", "2020", "MASTER CARD");
		user.addCard(card0);
		user.addCard(card1);
		session.save(user);
		tx.commit();
		
		System.out.println("Users:");
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> users = query.list();
		for(User u:users) {
			System.out.println(u);
		}
		
		System.out.println("Cards:");
		hql = "from Card";
		query = session.createQuery(hql);
		List<Card> cards = query.list();
		for (Card c:cards) {
			System.out.println(c);
		}
		
		tx = session.beginTransaction();
		Ticket ticketDelete = (Ticket) session.get(Ticket.class, 7);
		session.delete(ticketDelete);
		tx.commit();
		
		tx = session.beginTransaction();
		Station station0 = new Station("Test Station", "NJ", "Washington D.C.");
		Station station1 = new Station("Test Station 2", "NY", "Buffalo");
		Ticket ticket = new Ticket("AABBEED", station0, station1, 17, 40.50, null, null);
		session.save(ticket);
		tx.commit();
		
		System.out.println("Stations:");
		hql = "from Station";
		query = session.createQuery(hql);
		List<Station> stations = query.list();
		for (Station s:stations) {
			System.out.println(s);
		}
		
		System.out.println("Tickets:");
		hql = "from Ticket";
		query = session.createQuery(hql);
		List<Ticket> tickets = query.list();
		for (Ticket t:tickets) {
			System.out.println(t);
		}
		
		tx = session.beginTransaction();
		User newUser = new User("transaction_test", "1@2.com", "2223330000", "Jack",
				"Smith", "password", 'c', "09003", "5 Indepence Way", "Princeton", "NJ");
		Ticket newTicket = new Ticket("BBAAEE", station1, station0, 91, 9.9, null, null);
		com.mercury.beans.Transaction trans = new com.mercury.beans.Transaction(newUser, newTicket, null);
		session.save(trans);
		tx.commit();
		
		System.out.println("Users:");
		hql = "from User";
		query = session.createQuery(hql);
		users = query.list();
		for (User u:users) {
			System.out.println(u);
		}
		
		System.out.println("Tickets:");
		hql = "from Ticket";
		query = session.createQuery(hql);
		tickets = query.list();
		for (Ticket t:tickets) {
			System.out.println(t);
		}
		
		System.out.println("Transactions:");
		hql = "from Transaction";
		query = session.createQuery(hql);
		List<Transaction> transactions = query.list();
		for (Transaction t:transactions) {
			System.out.println(t);
		}
		HibernateUtil.closeSession();
	}
}
