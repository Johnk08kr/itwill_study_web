package com.itwill.spring01.web;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring01.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

// REST Service를 하는 컨트롤러 메소드 작성 방법:
// (1) @Controller 클래스에서 @RsponseBody 선언한 메소드를 작성.
// (2) @RestController 클래스의 모든 컨트롤러 메소드들은 REST Service로 구현가능.
// -> 컨트롤러가 리턴하는 값은 (뷰의 이름이 아니라) 응답으로 전송되는 패키지

@Slf4j
@RestController
public class ExampleRestController {
	
	@GetMapping("/rest3")
	public String rest3() {
		log.debug("rest3()");
		
		return "HI!, REST!";
	}
	
	@GetMapping("/rest4")
	public ArrayList<UserDto> user4(){
		log.debug("rest4");
		ArrayList<UserDto> list = new ArrayList();
		list.add(UserDto.builder().username("요한").age(15).build());
		list.add(UserDto.builder().username("권요").age(32).build());
		return list;
	}
	
	
}
