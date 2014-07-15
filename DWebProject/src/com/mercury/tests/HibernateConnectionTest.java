package com.mercury.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mercury.beans.*;
import com.mercury.utils.HibernateUtil;

public class HibernateConnectionTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		
		System.out.println("Users:");
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> userList = query.list();
		for (User u:userList) {
			System.out.println(u);
		}
		
		System.out.println("\nCards:");
		hql = "from Card";
		query = session.createQuery(hql);
		List<Card> cardList = query.list();
		for (Card card:cardList) {
			System.out.println(card);
		}
		
		System.out.println("\nTickets:");
		hql = "from Ticket";
		query = session.createQuery(hql);
		List<Ticket> ticketList = query.list();
		for (Ticket ticket:ticketList) {
			System.out.println(ticket);
		}
		
		System.out.println("\nTransactions: ");
		hql = "from Transaction";
		query = session.createQuery(hql);
		List<Transaction> transactionList = query.list();
		for (Transaction ts:transactionList) {
			System.out.println(ts);
		}
		HibernateUtil.closeSession();
	}
}