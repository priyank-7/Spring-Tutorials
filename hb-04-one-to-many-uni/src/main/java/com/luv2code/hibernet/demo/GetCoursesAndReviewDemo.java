package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Course;
import com.luv2code.hibernet.demo.entity.Instructor;
import com.luv2code.hibernet.demo.entity.InstructorDetail;
import com.luv2code.hibernet.demo.entity.Review;
import com.luv2code.hibernet.demo.entity.Student;

public class GetCoursesAndReviewDemo {

	public static void main(String[] args) {
				

		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// start a transaction 
			 session.beginTransaction();
			 
			 // get course 
			 int theId = 10;
			 Course tempCourse = session.get(Course.class, theId);
			 
			 // print the course
			 System.out.println("\n");
			 System.out.println(tempCourse);
			 
			 // print the course reviews
			 System.out.println("\n");
			 System.out.println(tempCourse.getReviews());
			 
			 
			 
			 
			 
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
