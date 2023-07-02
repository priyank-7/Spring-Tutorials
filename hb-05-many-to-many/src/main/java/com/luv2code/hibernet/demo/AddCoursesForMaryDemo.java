package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Course;
import com.luv2code.hibernet.demo.entity.Instructor;
import com.luv2code.hibernet.demo.entity.InstructorDetail;
import com.luv2code.hibernet.demo.entity.Review;
import com.luv2code.hibernet.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			 
			 
			 // Create a course			 			
			 Course tempCourse = new Course("Pacman - How to Score Million Points");
			 
			 // save the course
			 System.out.println("\nSaving the Course\n");			 
			 session.save(tempCourse);			
			 System.out.println("Save the Course : " + tempCourse);
			 
			 
			 // Create the students
			 Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
			 Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			 
			 // add the Students
			 tempCourse.addStudent(tempStudent1);
			 tempCourse.addStudent(tempStudent2);
			 
			 // save the Students
			 System.out.println("\nSaving Students....\n");
			 session.save(tempStudent1);
			 session.save(tempStudent2);
			 System.out.println("\nSaved students: " + tempCourse.getStudents());
			 			
			 
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
