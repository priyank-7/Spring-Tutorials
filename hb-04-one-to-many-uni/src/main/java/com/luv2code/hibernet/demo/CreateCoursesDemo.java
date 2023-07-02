package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Course;
import com.luv2code.hibernet.demo.entity.Instructor;
import com.luv2code.hibernet.demo.entity.InstructorDetail;
import com.luv2code.hibernet.demo.entity.Review;
import com.luv2code.hibernet.demo.entity.Student;

public class CreateCoursesDemo {

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
			 
			 
			 // create Course
			 Course tempcourse = new Course("Pacman - How to Score One Million Points");
			 
			 // add some Reviews
			 tempcourse.addReview(new Review("Great Course ... loves it"));
			 tempcourse.addReview(new Review("Cool course, job wel done"));
			 tempcourse.addReview(new Review("What a dumb course, you are an idiot!"));
			 
			 // save the reviews ....  and leverage the cascade all :-)
			 System.out.println("Saving the Course ");
			 System.out.println();
			 System.out.println(tempcourse);
			 System.out.println();
			 System.out.println(tempcourse.getReviews());
			 System.out.println();
			 session.save(tempcourse);
			 
			 
			 
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
