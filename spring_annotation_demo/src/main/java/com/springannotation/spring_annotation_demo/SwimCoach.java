package com.springannotation.spring_annotation_demo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	
	public SwimCoach(FortuneService thefortuneService) {
		fortuneService = thefortuneService;
	}
	
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
