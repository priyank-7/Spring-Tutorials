package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Course;
import com.luv2code.hibernet.demo.entity.Instructor;
import com.luv2code.hibernet.demo.entity.InstructorDetail;
import com.luv2code.hibernet.demo.entity.Student;

public class CreateCoursesDemo {

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
			 
			 
			 // get the instructor from db
			 int theId = 1;
			 Instructor tempInstructor = session.get(Instructor.class, theId);
			 
			 
			 // create some course
			 Course tempCourse1 = new Course("How to make good videos");
			 Course tempCourse2 = new Course("Masters In Fack Expression");
			 
			 
			 // add courses to instructor
			 tempInstructor.add(tempCourse1);
			 tempInstructor.add(tempCourse2);
			 
			 tempCourse1.setInstructor(tempInstructor);
			 tempCourse2.setInstructor(tempInstructor);
			 
			 System.out.println(tempCourse1);
			 System.out.println(tempCourse2);

			 
//			  save the courses
			 session.save(tempCourse1);
			 session.save(tempCourse2);
//			 
			 
			 System.out.println(tempInstructor);
			 
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
