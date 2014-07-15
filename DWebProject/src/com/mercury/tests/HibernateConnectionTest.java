package com.mercury.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mercury.beans.*;
import com.mercury.utils.HibernateUtil;

public class HibernateConnectionTest {
	@SuppressWarnings("unchecked")
	public static void printAll() {
		Session session = HibernateUtil.currentSession();
		
		System.out.println("\n######################################################");
		System.out.println("Users:");
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> userList = query.list();
		for (User u:userList) {
			System.out.println(u);
		}
		
		System.out.println("\n######################################################");
		System.out.println("Cards:");
		hql = "from Card";
		query = session.createQuery(hql);
		List<Card> cardList = query.list();
		for (Card card:cardList) {
			System.out.println(card);
		}

		System.out.println("\n######################################################");
		System.out.println("Station: ");
		hql = "from Station";
		query = session.createQuery(hql);
		List<Station> stationList = query.list();
		for (Station s:stationList) {
			System.out.println(s);
		}
		
		System.out.println("\n######################################################");
		System.out.println("Tickets:");
		hql = "from Ticket";
		query = session.createQuery(hql);
		List<Ticket> ticketList = query.list();
		for (Ticket ticket:ticketList) {
			System.out.println(ticket);
		}
		
		System.out.println("\n######################################################");
		System.out.println("Orders: ");
		hql = "from Order";
		query = session.createQuery(hql);
		List<Order> orders = query.list();
		for (Order order:orders) {
			System.out.println(order);
		}
		
		HibernateUtil.closeSession();
	}
	
	public static void main(String[] args) {
		printAll();
	}
}