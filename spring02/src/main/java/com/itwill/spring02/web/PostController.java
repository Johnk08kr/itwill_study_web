package com.itwill.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring02.dto.PostCreateDto;
import com.itwill.spring02.dto.PostListDto;
import com.itwill.spring02.dto.PostSearchDto;
import com.itwill.spring02.dto.PostUpdateDto;
import com.itwill.spring02.repository.Post;
import com.itwill.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드 초기화하는 생성자
@Controller
@RequestMapping("/post") // PostController의 모든 메소드들의 매핑 주소는 "/post" 로 시작.
public class PostController {

	private final PostService postService; // 생성자에 의한 의존성 주입

	@GetMapping("/list")
	public void list(Model model) {
		log.debug("list()");

		// 서비스 컴포넌트의 메소드를 호출, 포스트 목록을 읽어서, 뷰에 전달.
		List<PostListDto> list = postService.read();
		model.addAttribute("posts", list);
	}

	@GetMapping({ "/detail", "/update" })
	// 2개의 요청주소를 처리
	public void detail(@RequestParam(name = "id") int id, Model model) {
		log.debug("detail()");

		Post post = postService.readById(id);
		model.addAttribute("post", post);
	}

	@GetMapping("/create")
	public void create() {
		log.debug("create() GET");
	}

	@PostMapping("/create")
	public String create(PostCreateDto post) {
		log.debug("POST: create(dto={}", post);

		postService.createPost(post);

		return "redirect:/post/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") int id) {
		log.debug("delete(id={}", id);
		postService.deletePost(id);
		return "redirect:/post/list";
	}

	@PostMapping("/update")
	public String update(PostUpdateDto post) {
		log.debug("POST: update(dto={})", post);
		postService.updatePost(post);
		return "redirect:/post/detail?id=" + post.getId();
	}

	@GetMapping("/search")
	public String search(PostSearchDto dto, Model model) {
		log.debug("search(dto={})", dto);
		List<PostListDto> list = postService.searchPost(dto);

		model.addAttribute("posts", list);
		return "post/list";
	}
}
