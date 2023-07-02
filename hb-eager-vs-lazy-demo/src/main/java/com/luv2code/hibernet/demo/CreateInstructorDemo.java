package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Course;
import com.luv2code.hibernet.demo.entity.Instructor;
import com.luv2code.hibernet.demo.entity.InstructorDetail;
import com.luv2code.hibernet.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
				

		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Create the Objects		
						
			Instructor tempInstructor = 
					new Instructor("Lana", "Rhodes", "lana@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com", 
							"Love to making Videos");
			
			// Associates the Objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			// start a transaction 
			 session.beginTransaction();
			 
			
			 // Save the Instructor
			 //
			 // Note: This will ALSO save the details object
			 // because of CascadeType.All
			 //
			 System.out.println("Saving Instructor Detail : " + tempInstructor);
			 session.save(tempInstructor);
			 
			 
			// commit object
			 
			 session.getTransaction().commit();
			 
			 System.out.println("Done !");  
			
						 
			
		}
		finally {
			
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
