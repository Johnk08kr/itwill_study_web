package com.itwill.springboot5.web;

import org.springframework.data.domain.Page;
<<<<<<< HEAD
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
=======
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
>>>>>>> dfdd8a5220b4c2bb23c0b91944d326868c9b5b5c
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.dto.CommentRegisterDto;
import com.itwill.springboot5.dto.CommentUpdateDto;
import com.itwill.springboot5.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comment")
public class CommentController {
	private final CommentService commentService;

	@PreAuthorize("hasRole('USER')")
	@PostMapping
	public ResponseEntity<Comment> registerComment(@RequestBody CommentRegisterDto dto) {
		log.info("registerComment(dto={})", dto);

		// 서비스 계층의 메소드 호출(댓글 등록 서비스 실행)
		Comment entity = commentService.create(dto);
		log.info("Success Save: {}", entity);

		return ResponseEntity.ok(entity);
	}

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/all/{postId}")
	public ResponseEntity<Page<Comment>> getCommentList(@PathVariable Long postId,
			@RequestParam(name = "p", defaultValue = "0") int pageNo) {
		log.info("getCommentList(postId={}, pageNo={})", postId, pageNo);
		Page<Comment> data = commentService.readCommentList(postId, pageNo);

		return ResponseEntity.ok(data);
	}

	@PreAuthorize("hasRole('USER')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteComment(@PathVariable Long id) {
		log.info("deleteComment(id={})", id);

		commentService.delete(id);

		return ResponseEntity.ok(id); // 삭제한 댓글 아이디를 응답으로 보냄.
	}

	@PreAuthorize("hasRole('USER')")
	@PatchMapping("/{id}")
	public ResponseEntity<Long> updateComment(@PathVariable Long id, @RequestBody CommentUpdateDto dto) {
		log.info("updateComment(id={}, dto={})", id, dto);
		
<<<<<<< HEAD
		// pagination fragment에서 사용하기 위한 정보 현재 요청 주소 정보
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
		log.info("search(dto={}", dto);

		Page<PostListItemDto> result = postService.search(dto, Sort.by("id").descending());
		model.addAttribute("page", result);
=======
		commentService.update(dto);
>>>>>>> dfdd8a5220b4c2bb23c0b91944d326868c9b5b5c
		
		return ResponseEntity.ok(id); // 업데이트한 댓글의 아이디를 응답으로 보냄.
	}
}
