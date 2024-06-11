package com.itwill.spring02.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@GetMapping("/") // GET 방식의 요청 주소가 context path인 요청을 처리하는 메소드
	public String home() {
		log.debug("home()");
		return "home"; // view(.jsp)이름
	}
}
