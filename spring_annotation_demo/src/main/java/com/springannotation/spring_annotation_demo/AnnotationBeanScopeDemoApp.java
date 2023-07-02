package com.springannotation.spring_annotation_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieving bean from spring container
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class );
		
		// Check if they are the same 
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\npointing to the same object: "+result);
		
		System.out.println("\nMemory location for theCoach: " + theCoach);
		
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach);
		
		// close the context
		
		context.close();
	}

}
