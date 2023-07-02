package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
				

		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// create a student object
			
			 System.out.println("Creating new student Object...");
			 Student tempStudet = new Student("Paul","Wall","paul@luv2code.com");
			
			// start a transaction 
			 
			 session.beginTransaction();
			 
			// save the student object
			 
			 session.save(tempStudet);
			 System.out.println("Saving the Student");
			
			// commit object
			 
			 session.getTransaction().commit();
			 
			 System.out.println("Done !");
			
						 
			
		}
		finally {
			session.close();
//			factory.close();
		}
	}

}
