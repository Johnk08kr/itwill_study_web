package com.itwill.springboot5.web;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.*;
import com.itwill.springboot5.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {
	private final PostService postService;

	@GetMapping("/list")
	public void list(@RequestParam(name = "p", defaultValue = "0") int pageNo, Model model) {
		log.info("list(pageNo={})", pageNo);

		// 서비스 계층의 메서드를 호출 -> 뷰에 포스트 목록 전달
		Page<PostListItemDto> list = postService.read(pageNo, Sort.by("id").descending());
		model.addAttribute("page", list);

		// pagination fragment에서 사용하기 위한 현재 요청 주소 정보
		model.addAttribute("baseUrl", "/post/list");
	}

	// @PreAuthorize("isAuthenticated()") //-> role에 상관없이 아이디/비밀번호로만 인증.
	@PreAuthorize("hasRole('USER')") //-> role이 일치하는 아이디/비밀번호 인증.
	@GetMapping("/create")
	public void create() {
		log.info("create()");
	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping("/create")
	public String create(PostCreateItemDto dto) {
		log.info("POST create(dto={})", dto);
		postService.create(dto);
		return "redirect:/post/list";
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/details/{id}")
	public String detail(@PathVariable Long id, Model model) {
		log.info("POST detail(id={})", id);
		Post post = postService.readById(id);

		model.addAttribute("post", post);

		return "post/details";
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		log.info("POST delete(id={})", id);
		postService.delete(id);

		return "redirect:/post/list";
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		log.info("POST update(id={})", id);
		Post post = postService.readById(id);

		model.addAttribute("post", post);

		return "post/update";
	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping("/update")
	public String update(PostUpdateItemDto dto) {
		log.info("update(dto={})", dto);

		postService.update(dto);

		return "redirect:/post/details/" + dto.getId();
	}

	@GetMapping("/search")
	public String search(PostSearchRequestDto dto, Model model) {
		log.info("search(dto={})", dto);

		Page<PostListItemDto> result = postService.search(dto, Sort.by("id").descending());
		model.addAttribute("page", result);

		// pagination fragment에서 사용할 현재 요청 주소 정보
		model.addAttribute("baseUrl", "/post/search");

		return "post/list";
	}
}
