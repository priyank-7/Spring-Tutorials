package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Course;
import com.luv2code.hibernet.demo.entity.Instructor;
import com.luv2code.hibernet.demo.entity.InstructorDetail;
import com.luv2code.hibernet.demo.entity.Review;
import com.luv2code.hibernet.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			 int theStudentId = 2;
			 Student tempStudemt = session.get(Student.class, theStudentId);			 
			 System.out.println("\nLodded Student : " + tempStudemt + "\n");
			 System.out.println("Courses: " + tempStudemt.getCourses());
			 
			 // Create more Courses
			 Course tempCourse1 = new Course("Rubik's Cube - How to speed Cube");
			 Course tempCourse2 = new Course("Atari 2600 - Game Devlopement");
			 
			 // add Student to that Courses
			 tempCourse1.addStudent(tempStudemt);
			 tempCourse2.addStudent(tempStudemt);
			 
			 // Save the courses
			 System.out.println("\nSaving The Courses ....");
			 session.save(tempCourse1);
			 session.save(tempCourse2);
			 			 		
			 
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
