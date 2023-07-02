package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Course;
import com.luv2code.hibernet.demo.entity.Instructor;
import com.luv2code.hibernet.demo.entity.InstructorDetail;
import com.luv2code.hibernet.demo.entity.Review;
import com.luv2code.hibernet.demo.entity.Student;

public class GetCoursesForMaryDemo {

	public static void main(String[] args) {
				

		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
											
			// start a transaction 
			 session.beginTransaction();
			 
			
			 // get the Student Mary from database
			 int theStudentId = 1;
			 Student tempStudemt = session.get(Student.class, theStudentId);			 
			 System.out.println("\nLodded Student : " + tempStudemt + "\n");
			 System.out.println("Courses: " + tempStudemt.getCourses());
			 			
			 
			 
			// commit object
			 
			 session.getTransaction().commit();
			 
			 System.out.println("\nDone !\n");  

		}
		finally {
			
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
