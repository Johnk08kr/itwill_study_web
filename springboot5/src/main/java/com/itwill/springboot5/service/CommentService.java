package com.itwill.springboot5.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.CommentRegisterDto;
import com.itwill.springboot5.repository.CommentRepository;
import com.itwill.springboot5.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {
	private final CommentRepository commentRepo;
	private final PostRepository postRepo;

	public Comment create(CommentRegisterDto dto) {
		log.info("create(dto={})", dto);

		// 댓글이 달릴 포스트 엔터티를 검색
		Post post = postRepo.findById(dto.getPostId()).orElseThrow();

		// 테이블에 저장할 Comment 타입의 엔터티를 생성
		Comment entity = Comment.builder().post(post).ctext(dto.getCtext()).writer(dto.getWriter()).build();

		commentRepo.save(entity);

		return entity;
	}
	
	@Transactional(readOnly = true)
	public Page<Comment> readCommentList(Long postId, int pageNo) {
		log.info("readCommentList(postId={}, pageNo={})", postId, pageNo);
		
		// 댓글이 달려있는 포스트 엔터티 검색
		Post post = postRepo.findById(postId).orElseThrow();

		// 페이징 처리와 정렬을 하기 위한 Pageable 객체 생성
		Pageable pageable = PageRequest.of(pageNo, 5, Sort.by("modifiedTime").descending());
		
		// DB에서 검색(select)
//		Page<Comment> data = commentRepo.findByPostId(postId, pageable);
		Page<Comment> data = commentRepo.findByPost(post, pageable);
		log.info("data.number={}, data.totalPages={}", data.getNumber(), data.getTotalPages());
		
		return data;
	}
}
