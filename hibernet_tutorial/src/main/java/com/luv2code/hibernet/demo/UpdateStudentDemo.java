package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
				

		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {								

			int studentId = 1;
			
			
			 // new get a new Session and start transaction
			 
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 
			 // retrieve student based on the id: primary key
			 
			 System.out.println("\nGetting Student with id : " + studentId);
			 
			 
			 Student myStudent = session.get(Student.class, studentId);
			 
			 System.out.println("Updating the Student :  ");
			 myStudent.setFirstName("Scooby");
			 // commit the transaction
			 
			 session.getTransaction().commit();
			 			 	
			 // new Code
			 
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 
			 // Update email for all students
			 System.out.println("Updating email forALL STUDENT : ");
			 
			 session.createQuery("update Student set email='foo@gmail.com'")
			 	.executeUpdate();
			 
			 // commit transaction
			 
			 session.getTransaction().commit();
			 
			 
			 
			 
			 System.out.println("Done !");
	 		
						 
			
		}
		finally {
			session.close();
//			factory.close();
		}
	}

}
