package com.mercury.tests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;
import org.hibernate.Transaction;

public class HibernateConnectionTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		User user = new User("test03", "123@123.com", "5503334444", "John", "Doe",
					"12345", 'c', "08000", "321 1st street", "Hoboken", "NJ");
		session.delete(user);
		tx.commit();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> userList = query.list();
		
		for (User u:userList) {
			System.out.println(u);
		}
		System.out.println(userList.size());
		
		HibernateUtil.closeSession();
	}
}