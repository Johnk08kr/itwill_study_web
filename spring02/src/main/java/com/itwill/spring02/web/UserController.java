package com.itwill.spring02.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring02.repository.User;
import com.itwill.spring02.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@GetMapping("/signup")
	public void signup() {

	}

	@PostMapping("/signup")
	public String signupUser(@RequestParam(name = "userid") String userid, @RequestParam(name="password") String password,
			@RequestParam(name="email") String email) {
		log.debug("signupUser()");
		
		User user = User.builder().userid(userid).password(password).email(email).build();
		userService.createUser(user);
		
		return "redirect:/user/signin";
	}
	
	@GetMapping("/signin")
	public void signinUser() {
		
	}
	
//	@PostMapping("/signin")
//	public void signinUser() {
//		
//	}
}
