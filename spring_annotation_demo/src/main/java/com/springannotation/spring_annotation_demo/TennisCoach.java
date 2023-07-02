package com.springannotation.spring_annotation_demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// default constructor
	
	public TennisCoach() {
		System.out.println("TennisCoach >> inside the default constructor"); 
	}
	
	// define init method
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach >> inside of doMyStartupStuff()");
	}
		
	// define my destroy method
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach >> inside of doMyCleanupStuff()");
	}
	
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
	
	
	// define a setter method
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">> inside the default setFortuneService() method");
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneService) {
//		System.out.println(">> inside the default doSomeCrazyStuff() method");
//		fortuneService = theFortuneService;
//	}
	
	
	public String getDailyWorkout() {
		return "Hey, this is tennis coach, and Practice your backhand volly";
	}

	public String getDailyFortune() {		
		return fortuneService.getFortune(); 
	}
	
}
