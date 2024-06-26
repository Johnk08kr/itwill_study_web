package com.itwill.spring02.repository;

import java.util.List;

import com.itwill.spring02.dto.PostListDto;
import com.itwill.spring02.dto.PostSearchDto;

public interface PostDao {

	// post-mapper.xml에서 id="selectOrderByIdDesc"인 SQL을 실행하는 메소드.
	List<Post> selectOrderByIdDesc();
	Post selectById(Integer id);
	int insertPost(Post post);
	int updatePost(Post post);
	int deletePost(Integer id);
	List<PostListDto> searchPost(PostSearchDto dto);
}
