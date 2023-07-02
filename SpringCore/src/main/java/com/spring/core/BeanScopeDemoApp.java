package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// Load the spring configuration file
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean_Scope_applicationContext.xml");
				
		// retrieve bean from spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		// Check if they are the same bean
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory location for theCoach: "+ theCoach);
		
		System.out.println("\nMemory location for alphaCoach: "+ alphaCoach);
		
		// Cloase the context
		context.close();

	}

}
