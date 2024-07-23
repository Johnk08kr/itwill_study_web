package com.itwill.springboot2.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		log.info("home()");
		
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("currentTime", now);
		
		return "index";
	}
}
