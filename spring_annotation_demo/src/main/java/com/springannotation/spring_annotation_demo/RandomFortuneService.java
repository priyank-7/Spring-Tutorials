package com.springannotation.spring_annotation_demo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// Creating an array of String
	private String [] data = {
			"Bewere of the wolf in sheep's cloathing",
			"Diligence is the mother of good luck",
			"The journy is the reward"
	};
	
	// create a random number generator
	private Random myRandom = new Random();
	
	public String getFortune() {	
		// Pick a random String from an array
		
		int index = myRandom.nextInt(data.length);
		
		String thefortune = data[index];

		return thefortune;
	}

}
