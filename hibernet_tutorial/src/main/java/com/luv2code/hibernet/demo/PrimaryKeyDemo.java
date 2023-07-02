package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// create 3 student objects

			System.out.println("Creating 3 student Object...");
			Student tempStudet1 = new Student("John", "Doe", "john@luv2code.com");
			Student tempStudet2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student tempStudet3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

			// start a transaction

			session.beginTransaction();

			// save the student object

			System.out.println("Saving the Student");
			session.save(tempStudet1);			
			session.save(tempStudet2);			
			session.save(tempStudet3);			

			// commit object

			session.getTransaction().commit();

			System.out.println("Done !");

		} finally {
			session.close();
//					factory.close();
		}
	}

}
