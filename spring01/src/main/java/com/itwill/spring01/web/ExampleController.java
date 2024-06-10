package com.itwill.spring01.web;

import java.time.LocalDateTime;

import org.springframework.core.style.DefaultValueStyler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring01.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

// POCO(Plain Old C# Object)
// POJO(Plain Old Java Object): 간단한 오래된 자바 객체.
// 특정 클래스를 상속하거나, 특정 인터페이스를 구현할 필요가 없는
// (상위 타입의 특정 메소드들을 반드시 재정의할 필요가 없는) 평범한 자바 객체.

@Slf4j // -> private static final Logger log =
		// LoggerFactory.getLogger(ExampleController.class) 삽입.
@Controller // -> dispathcer servlet에 컨트롤러 컴포넌트임을 알려줌.
// (1) servlet-context.xml 에서는 <context:component-scan ... /> 설정
// (2) 컨트롤러 클래스에서는 @Controller 사용.
//-> dispathcer servlet이 컨트롤러 객체를 생성, 관리
// 스프링 MVC 프레임워크에서는 POJO로 작성된 클래스를 컨트롤러로 사용할 수 있음.
// (비교) HttpServlet을 상속받는 클래스에서는 doGet(req, resp) 또는 doPost(req, resp)를 
// 반드시 override 해야 웹 서비스(요청 처리)가 가능.
public class ExampleController {

	@GetMapping("/")
	public String home(Model model) {
		log.debug("home()");

		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("now", now);
		// Model 객체는 컨트롤러에서 뷰로 데이터를 전달할 때 사용.
		// request.setAttribute(name, object)와 비슷한 기능.

		return "home"; // .jsp이름
		// -> 컨트롤러 메소드가 문자열을 리턴하면, dispathcer servlet이 뷰의 이름을 찾음
	}

	@GetMapping("/example")
	public void controllerExample() {
		log.debug("controllerExample()");
		// 컨트롤러 메소드가 리턴 값이 없는 경우,
		// 요청 주소가 뷰의 이름이 됨.
	}

	@GetMapping("/ex01")
	public void example01(@RequestParam(name = "username") String username,
			@RequestParam(name = "age", defaultValue = "0") int age, Model model) {
		log.debug("example01(username={}, age={})", username, age);
		// 컨트롤러 메소드 파라미터를 선언할 때 @requestParam 사용하면,
		// 디스패처 서블릿이 컨트롤러 메소드를 호출할 때
		// (1) request.getParameter("username"), request.getParameter("age") 호출해서
		// 요청 파라미터 값들을 읽고,
		// (2) 컨트롤러 메소드의 argument로 전달해줌.

		UserDto user = UserDto.builder().username(username).age(age).build();

		// UserDto 객체를 뷰로 전달.
		model.addAttribute("user", user);
	}

	@PostMapping("/ex02")
	public String ex02(@ModelAttribute(name = "user") UserDto dto) { //-> model.addAttribute("user", dto);
		log.debug("ex02(dto={})", dto);
		// 디스패처 서블릿은 컨트롤러 메소드를 호출하기 위해서
		// UserDto 클래스 기본 생성자를 호출하고, 요청 파라미터 이름으로 setter를 찾아서 호출.
		// 생성된 객체를 컨트롤러 메소드의 argument로 전달.
		
		return "ex01";
	}
	
	@GetMapping("/test")
	public void test() {
		log.debug("test()");
	}
	
	@GetMapping("/testForward")
	public String forward() {
		log.debug("forward()");
		return "forward:/test";
		// 컨트롤러 메소드가 'forward:'으로 시작하는 문자열을 리턴 -> 포워드 방식의 이동
		// forward: 최초 요청 주소가 바뀌지 않음.
	}
	
	@GetMapping("/testRedirect")
	public String redirect() {
		log.debug("redirect()");
		return "redirect:/test";
		// 컨트롤러 메소드가 'redirect:'으로 시작하는 문자열을 리턴 -> 리다이렉트 방식의 이동
		// redirect: 요청 주소 바뀜.
	}
	
	@GetMapping("/rest1")
	@ResponseBody
	//-> 컨트롤러 메소드가 리턴하는 값이 뷰를 찾기 위한 문자열이 아니라,
	// 	 클라이언트로 직접 응답되는 데이터. 
	//   응답 패킷(response packet)의 몸통(body)에 포함되는 데이터.
	public String rest1() {
		log.debug("rest1()");
		
		return "hi";
	}
	
	@GetMapping("/rest2")
	@ResponseBody
	public UserDto rest2() {
		log.debug("rest()");
		UserDto user = UserDto.builder().username("Johnk").age(32).build();
		return user;
		//-> REST 컨트롤러가 리턴한 자바 객체를 jackson-databind 라이브러리에서 
		// JSON(JavaScript Object Notation) 형식의 문자열로 변환하고,
		// 클라이언트로 응답을 보냄.
	}
}
