package com.itwill.springboot5.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostCreateItemDto;
import com.itwill.springboot5.dto.PostListItemDto;
import com.itwill.springboot5.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
	
	private final PostRepository postRepo;
	
	public List<PostListItemDto> read() {
		log.info("read()");
		// TODO: 영속성(persistence/repository) 계층의 메소드를 호출해서 엔티티들의 리스트를 가져옴
		List<Post> list = postRepo.findAll();
		
		// List<Post> 객체를 List<PostListItemDto> 타입으로 변환 후 리턴.
		List<PostListItemDto> postList = list.stream().map(PostListItemDto::fromEntity).toList();
		return postList;
	}
	
//	public PostCreateItemDto create() {
//		log.info("create()");
//	}
}
