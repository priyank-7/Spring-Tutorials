package com.springannotation.spring_annotation_demo;

import org.springframework.stereotype.Component;

@Component
public class RestFortuneService implements FortuneService {

	public String getFortune() {		
		return "This is RestFortuneService";
	}

}
