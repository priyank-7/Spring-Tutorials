package com.springannotation.spring_annotation_demo;

import org.springframework.stereotype.Component;

@Component
public class DataBaseFortuneService implements FortuneService {

	public String getFortune() {
		return "This is DataBaseFortuneService";
	}

}
