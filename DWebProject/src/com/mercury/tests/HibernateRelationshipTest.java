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
		HibernateUtil.closeSession();
	}
}
