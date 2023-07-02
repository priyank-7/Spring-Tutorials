package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernet.demo.entity.Student;

public class DeleteStudentDemo {

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
			 
			 
			 // delete thr Student 
//			 System.out.println("Delete student : " + myStudent);
//			 session.delete(myStudent);
			 
			 
			 // deleting student with id = 2;
			 System.out.println("Deleting Studenrt Id = 17;");
			 session.createQuery("delete from Student where id=17").executeUpdate();
			 
			 			 			
			 // commit the transaction			 
			 session.getTransaction().commit();
			 		
			 
			 // new Code			 			 			 
			 System.out.println("Done !");
	 		
						 
			
		}
		finally {
			session.close();
//			factory.close();
		}
	}

}
