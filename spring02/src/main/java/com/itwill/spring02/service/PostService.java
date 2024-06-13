package com.itwill.spring02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.spring02.dto.PostCreateDto;
import com.itwill.spring02.dto.PostListDto;
import com.itwill.spring02.dto.PostSearchDto;
import com.itwill.spring02.dto.PostUpdateDto;
import com.itwill.spring02.repository.Post;
import com.itwill.spring02.repository.PostDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드들을 초기화하는 argument를 갖는 생성자.
@Service // 스프링 컨테이너에 서비스 컴포넌트로 등록.
public class PostService {

//	@ 사용한 의존성 주입:
//	@Autowired 
//	private PostDao postDao;

//	생성자에 의한 의존성 주입:
//	(1) final 필드 선언. (2) final 필드를 초기화하는 생성자 작성.
	private final PostDao postDao;
//	
//	public PostService(PostDao postDao) {
//		this.postDao = postDao;
//	}

	public List<PostListDto> read() {
		log.debug("read()");
		
		List<Post> list = postDao.selectOrderByIdDesc();
		
		return list.stream()
				.map(PostListDto::fromEntity) // map((x) -> PostListDto.fromEntity(x));
				.toList();
	}
	
	public Post readById(Integer id) {
		log.debug("readById()");
		
		Post post = postDao.selectById(id);
		
		return post;
	}
	
	public void createPost(PostCreateDto post) {
		log.debug("createPost()");
		
		postDao.insertPost(post.toEntity());
	}
	
	public void updatePost(PostUpdateDto post) {
		log.debug("updatePost()");
		
		postDao.updatePost(post.toEntity());
	}
	
	public int deletePost(int id) {
		log.debug("deletePost()");
		
		int result = postDao.deletePost(id);
		
		return result;
	}
	
	public List<PostListDto> searchPost(PostSearchDto dto) {
		log.debug("searchPost()");
		List<PostListDto> list = postDao.searchPost(dto);
		return list;
	}
}
