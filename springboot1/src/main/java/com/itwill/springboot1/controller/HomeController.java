package com.itwill.springboot1.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.springboot1.dto.Author;
import com.itwill.springboot1.dto.Book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/") // context path로 들어오는 GET 방식 요청을 처리하는 메소드
	public String home(Model model) {
		log.info("home()");
		
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("currentTime", now);
		
		Author author = Author.builder().firstName("찰스").lastName("다윈").build();
		Book book = Book.builder().id(1).title("종의 기원").author(author).build();
		log.info("book:{}", book);
		model.addAttribute("book", book);

		return "index"; // view return (src/main/resource/templates/~.html)
	}

	@GetMapping("/book/list")
	public void bookList(Model model) {
		// return 타입이 void인 경우 view의 이름은 요청 주소와 같음
		log.info("bookList()");

		// 도서 목록 더미 테이더 저장하기 위한 리스트
		ArrayList<Book> list = new ArrayList<>();
		
		// 더미 데이터 5개를 리스트에 저장.
		for(int i = 1; i <= 5; i++){
			Author author = Author.builder().firstName("name-" + i).lastName("lastName").build();
			Book book = Book.builder().id(i).title("title-" + i).author(author).build();
			list.add(book);
		}

		Book b = Book.builder().id(10).title("종의 기원").build(); // author = null
		list.add(b);

		// 도서 목록을 뷰에 전달
		model.addAttribute("bookList", list);
	}
	
}