package com.mercury.tests;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.mercury.beans.*;


public class BeansTests {

	@Test
	public void testToStrings() {
		System.out.println(new User("test0", "test@gmail.com", "2014449999",
				"John", "Doe", "mercury", 'c', "07030", "322 1st street", "Hoboken", "NJ"));
		User tmpUser = new User();
		tmpUser.setId(10);
		System.out.println(new Card("1234000043219999", tmpUser, "12", "2050", "Visa"));
		Timestamp timestamp = new Timestamp(new Date().getTime());
		timestamp.setNanos(0);
		System.out.println("java.sql.Timestamp Now: " + timestamp);
		Calendar cStart = Calendar.getInstance();
		cStart.set(2011, 0, 1, 14, 0);
		Timestamp tsStart = new Timestamp(cStart.getTimeInMillis());
		tsStart.setNanos(0);
		Calendar cArrive = Calendar.getInstance();
		cArrive.set(2011, 0, 1, 20, 0);
		Timestamp tsArrive = new Timestamp(cArrive.getTimeInMillis());
		tsArrive.setNanos(0);
		Station from = new Station("Princeton", "NJ", "Princeton");
		from.setId(10);
		Station to = new Station("Hoboken Terminal", "NJ", "Hoboken");
		to.setId(11);
		System.out.println(from);
		System.out.println(to);
		Ticket ticket = new Ticket(from, to, 35, 24.5, tsStart, tsArrive);
		System.out.println(new Ticket(from, to, 35, 24.5, tsStart, tsArrive));
		System.out.println(new Order(tmpUser, ticket, null, "ADAO42", 2));
	}

}
