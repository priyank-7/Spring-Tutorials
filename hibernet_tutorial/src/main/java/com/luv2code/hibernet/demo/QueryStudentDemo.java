package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Student;

import java.util.*;

public class QueryStudentDemo {

	public static void main(String[] args) {
				

		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {	
			
			// start a transaction 
			 
			 session.beginTransaction();	
			 
			 // Query student
			 
			 List<Student> theStudent = session.createQuery("from Student").getResultList();			 
			 // display the student			 
			 displayStudents(theStudent);
			 System.out.println("\n");
			 
			 // query students : lastName : 'Doe'			 
			 theStudent = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			 // display students
			displayStudents(theStudent);
			System.out.println("\n");
			
			
			// query students : lastName='Doe' OR firstName='Daffy'
			theStudent = 
					session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName='Daffy'").getResultList();
			// display result
			displayStudents(theStudent);
			System.out.println("\n");
			
			
			// query student where email LIME '%luv2code.com'
			theStudent = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			// deisplay result 
			displayStudents(theStudent);
			
			
			 
			// commit object
			 
			 session.getTransaction().commit();
			 
			 System.out.println("Done !"); 
			
						 
			
		}
		finally {
			session.close();
//			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
