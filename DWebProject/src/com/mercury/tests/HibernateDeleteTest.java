package com.mercury.tests;

import java.util.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import com.mercury.beans.*;
import com.mercury.utils.*;

public class HibernateDeleteTest {
	@SuppressWarnings("unchecked")
	public static void resetData() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.and(Restrictions.eq("orderCode", "ADAO42"), 
				Restrictions.eq("ticketNum", 10)));
		List<Order> orders = criteria.list();
		for (Order o:orders) {
			if (o != null) {
				session.delete(o);
			}
		}
		
		criteria = session.createCriteria(Ticket.class);
		criteria.add(Restrictions.or(Restrictions.and(Restrictions.eq("maxNumber", 91), Restrictions.eq("price", 9.9)),
				Restrictions.and(Restrictions.eq("maxNumber", 17), Restrictions.eq("price", 40.5))));
		List<Ticket> tickets = criteria.list();
		for (Ticket t:tickets) {
			if (t != null) {
				session.delete(t);
			}
		}
		
		criteria = session.createCriteria(Station.class);
		criteria.add(Restrictions.or(Restrictions.eq("name", "Test Station"), 
				Restrictions.eq("name", "Test Station 2")));
		List<Station> stations = criteria.list();
		for (Station s:stations) {
			if (s != null) {
				session.delete(s);
			}
		}
		
		criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.or(Restrictions.eq("username", "one_to_many"), 
				Restrictions.eq("username", "transaction_test")));
		List<User> users = criteria.list();
		for (User u:users) {
			if (u != null) {
				session.delete(u);
			}
		}

		tx.commit();
		HibernateUtil.closeSession();
	}
	public static void main(String[] args) {
		resetData();
	}
}
