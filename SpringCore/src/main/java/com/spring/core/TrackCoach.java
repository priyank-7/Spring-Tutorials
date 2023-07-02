package com.spring.core;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {	
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "This is track coatch";
	}

	public String getDailyFortune() {
		return "Just do it "+fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach : inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach : inside method doMyCleanupStuff");

	}
}
