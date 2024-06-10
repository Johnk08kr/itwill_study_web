package com.itwill.spring02.repository;

import java.util.List;

public interface PostDao {

	// post-mapper.xml에서 id="selectOrderByIdDesc"인 SQL을 실행하는 메소드.
	List<Post> selectOrderByIdDesc();
}
