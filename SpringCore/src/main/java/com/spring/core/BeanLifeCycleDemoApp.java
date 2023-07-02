package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean_LifeCycle_applicationContext.xml");
				
		// retrieve bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		// Close the context
		context.close();
		
		
		// If the scope is "Prototype" the method at destroy time will not run 

	}

}
