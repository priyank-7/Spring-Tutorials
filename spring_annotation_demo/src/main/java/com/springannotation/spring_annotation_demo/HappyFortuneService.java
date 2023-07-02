package com.springannotation.spring_annotation_demo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	public String getFortune() {
		return "This is HappyFortune Service, Today is your lucky day";
	}

}
