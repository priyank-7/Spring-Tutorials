package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Student;

public class ReadStudentDemo {

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
			 Student tempStudet = new Student("Daffy","Duck","daffy@luv2code.com");
			
			// start a transaction 
			 
			 session.beginTransaction();
			 
			// save the student object
			 
			 session.save(tempStudet);
			 System.out.println("Saving the Student");
			 System.out.println(tempStudet);
			
			// commit object
			 
			 session.getTransaction().commit();
			 
			 
			// New Code
			 
			 
			// find out the student's id: primary key
			 System.out.println("Save student. Generated id :" + tempStudet.getId());
			 
			 // new get a new Session and start transaction
			 
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 
			 // retrieve student based on the id: primary key
			 
			 System.out.println("\nGetting Student with id : " + tempStudet.getId());
			 
			 
			 Student myStudent = session.get(Student.class, tempStudet.getId());
			 
			 System.out.println("Get complete: " + myStudent);
			 // commit the transaction
			 
			 session.getTransaction().commit();
			 			 	
			 
			 System.out.println("Done !");
	 		
						 
			
		}
		finally {
			session.close();
//			factory.close();
		}
	}

}
