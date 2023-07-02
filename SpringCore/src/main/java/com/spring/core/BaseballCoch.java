package com.spring.core;

public class BaseballCoch implements Coach {
	
	// Define private field
	private FortuneService fortuneservice;
	
	// define a constructor for dependency injection
	public BaseballCoch(FortuneService thefortuneService) {
		fortuneservice = thefortuneService;
	}

	public String getDailyWorkout() {
		return "This is bassball coach";
	}

	public String getDailyFortune() {	
		
		// use my fortuneService to get a fortune		
		return fortuneservice.getFortune();
	}

	
}
