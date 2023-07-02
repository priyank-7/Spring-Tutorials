package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Course;
import com.luv2code.hibernet.demo.entity.Instructor;
import com.luv2code.hibernet.demo.entity.InstructorDetail;
import com.luv2code.hibernet.demo.entity.Student;

public class DeleteCoursesDemo {

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
			
			
			
		
			// start a transaction 
			 session.beginTransaction();
			 
			 
			 // get  the course 
			 int theId = 14;
			 Course tempCourse = session.get(Course.class, theId);
			 
			 
			 // delete the course
			 System.out.println("Deleting Course : " + tempCourse);
			 
			 session.delete(tempCourse);
			 
			// commit transaction
			 
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
