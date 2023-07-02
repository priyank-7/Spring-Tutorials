package com.web.thymeleaf.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {

	@GetMapping("/about")
	public String about(Model model) {
	
		System.out.println("In side about handler");
		// adding data in model
//		model.addAttribute("name","Priyank Patel");
//		model.addAttribute("CurrentDate",new Date().toLocaleString());
		return "about";
	}
}
