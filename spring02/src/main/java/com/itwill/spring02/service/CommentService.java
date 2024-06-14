package com.itwill.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.spring02.dto.CommentCreateDto;
import com.itwill.spring02.dto.CommentItemDto;
import com.itwill.spring02.dto.CommentUpdateDto;
import com.itwill.spring02.repository.Comment;
import com.itwill.spring02.repository.CommentDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentDao commentDao; // 생성자에 의한 의존성 주입

	public List<CommentItemDto> readByPostId(Integer postId) {

		// 리포지토리(영속성) 계층의 메소드를 호출해서 comment 테이블의 데이터를 검색.
		List<Comment> list = commentDao.selectByPostId(postId);

		return list.stream().map(CommentItemDto::fromEntity).toList();
	}
	
	public CommentItemDto readById(Integer id) {
		log.debug("readById(id={})", id);
		
		Comment commnet = commentDao.selectById(id);
		
		return CommentItemDto.fromEntity(commnet);
	}

	public int create(CommentCreateDto dto) {
		log.debug("create({})", dto);

		int result = commentDao.insert(dto.toEntity());

		return result;
	}

	public int update(CommentUpdateDto dto) {
		log.debug("update({})", dto);
		
		int result = commentDao.update(dto.toEntity());
		
		return result;
	}
	
	public int deleteById(Integer id) {
		log.debug("deleteById({})", id);
		
		int result = commentDao.deleteById(id);
		
		return result;
	}
	
	public int deleteByPostId(Integer postId) {
		log.debug("deleteByPostId({})", postId);
		
		int result = commentDao.deleteByPostId(postId);
		
		return result;
	}
}
