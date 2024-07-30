package com.itwill.springboot5.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot5.domain.Post;
import com.itwill.springboot5.dto.PostCreateItemDto;
import com.itwill.springboot5.dto.PostListItemDto;
import com.itwill.springboot5.dto.PostUpdateItemDto;
import com.itwill.springboot5.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
	
	private final PostRepository postRepo;
	
	@Transactional(readOnly = true)
	public Page<PostListItemDto> read(int pageNo, Sort sort) {
		log.info("read(pageNo={}, sort={})", pageNo, sort);
		
		// Pageable 객체 생성
		Pageable pageable = PageRequest.of(pageNo, 5, sort);
		
		// TODO: 영속성(persistence/repository) 계층의 메소드를 호출해서 엔티티들의 리스트를 가져옴
		Page<Post> list = postRepo.findAll(pageable);
		log.info("page.totalPages={}", list.getTotalPages()); // 전체 페이지 개수
		log.info("page.number={}", list.getNumber()); // 현재 페이지 번호
		log.info("page.hasPrevious={}", list.hasPrevious()); // 이전 페이지가 있는 지 여부
		log.info("page.hasNext={}", list.hasNext()); // 다음 페이지가 있는 지 여부
		
		// Page<Post> 객체를 Page<PostListItemDto> 타입으로 변환 후 리턴.
		Page<PostListItemDto> postList = list.map(PostListItemDto::fromEntity);
		return postList;
	}
	
	@Transactional(readOnly = true)
	public Long create(PostCreateItemDto dto) {
		log.info("create(dto={})", dto);
		
		// 영속성 계층의 메소드를 호출해서 DB insert 쿼리를 실행
		Post entity = postRepo.save(dto.toEntity());
		
		return entity.getId(); // 저장 성공시 아이디 반환
	}
	
	@Transactional(readOnly = true)
	public Post readById(Long id) {
		log.info("readById(id={})", id);
		Post post = postRepo.findById(id).orElseThrow();
		return post;
	}
	
	public void delete(Long id) {
		log.info("delete(id={})", id);
		postRepo.deleteById(id);
	} 
	
	@Transactional
	public void update(PostUpdateItemDto dto) {
		log.info("update(dto={}", dto);
		
		// id로 Post 엔터티 객체를 찾음(DB select 쿼리)
		Post entity = postRepo.findById(dto.getId()).orElseThrow();
		
		// DB에서 검색한 엔터티 객체의 필드들을 업데이트(수정)
		entity.update(dto.getTitle(), dto.getContent());
		
		// @Transactional 에너테이션을 사용한 경우,
		// DB에서 검색한 entity 객체가 변경되면 update 쿼리가 자동으로 실행.

		// @Transactional 에너테이션을 사용하지 않은 경우,
		// postRepo.save(entity) 메소드를 직접 호출해야 함.
		
	}
	
}
