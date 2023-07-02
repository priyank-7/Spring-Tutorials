package com.luv2code.springdemo;

public class Cricketcoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "Practice for fast bowling";
	}
	
	@Override
	public String getDailyFortune() {
		return null;
	}
}
