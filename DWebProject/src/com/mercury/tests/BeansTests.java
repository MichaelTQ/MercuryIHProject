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
		System.out.println(new Card(0, "1234000043219999", "12", "2050", "Visa"));
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
		System.out.println(new Ticket(0, "BAI7D31I", 0, 2, 35, 24.5,
				tsStart, tsArrive));
		System.out.println(new Transaction(0, 2, 4, tsStart));
	}

}
