package com.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterSemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
		// retrieve bean from spring container
		
		CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);
		
		// call method on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		// call our new method to get the literal values
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(theCoach.getTeam());
		
		
		// close the context
		
		context.close(); 

	}

}
