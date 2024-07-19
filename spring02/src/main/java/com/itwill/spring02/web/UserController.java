package com.itwill.spring02.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring02.dto.UserCreateDto;
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
		log.debug("Get signup()");
	}
	
	@PostMapping("/signup")
	public String signup(UserCreateDto dto) {
		log.debug("Post signup({})", dto);
		
		userService.create(dto);
		
		return "redirect:/"; // 홈페이지로 이동.
	}
	
	// TODO: 사용자 아이디 중복체크 REST Controller
	@GetMapping("/checkid")
	@ResponseBody // 메소드 리턴 값이 클라이언트로 전달되는 데이터.
	public ResponseEntity<String> checkId(@RequestParam(name = "userid") String userid) {
		log.debug("checkId(userId={})", userid);
		
		boolean result = userService.checkUserid(userid);
		if (result) {
			return ResponseEntity.ok("Y");
		} else {
			return ResponseEntity.ok("N");
		}
	}
}
