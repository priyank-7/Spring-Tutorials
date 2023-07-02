package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// Load the spring Configuration
		ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// retrieve bean from spring container
		Coach theCoach = contex.getBean("myCoach", Coach.class);
		
		// Call method on  the bean 
		System.out.println(theCoach.getDailyWorkout());
		
		//	Call new method for fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		contex.close();
	}

}
