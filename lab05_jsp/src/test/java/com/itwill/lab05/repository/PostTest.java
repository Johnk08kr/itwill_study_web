package com.itwill.lab05.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostTest {
	private static final Logger log = LoggerFactory.getLogger(PostTest.class);
	
	private PostDao dao = PostDao.INSTANCE; //singleton 객체

	// JUnit 모듈에서 단위 테스트를 하기 위해서 호출하는 메소드
	// (1). public void. (2) argument X
//	@Test
	public void test() {
		// Post 타입 객체 생성 - Builder 디자인 패턴
		Post p = Post.builder().title("TEST").author("JOHNK").content("Builder Design Pattern").id(1).build();
		
		// assertNotNull(arg): arg가 null이 아니면 JUnit 테스트 성공, null이면 테스트 실패.
		Assertions.assertNotNull(p);
		// Assertions.assertNull(p);
		// -> 반대
		log.debug("p = {}", p);
	}
	
//	@Test
	public void testSelect() {
		Assertions.assertNotNull(dao);
		log.debug("dao = {}", dao);
		List<Post> result = dao.select();
		Assertions.assertEquals(4, result.size());
		for(Post p : result) {
			log.debug(p.toString());
		}
	}
	
//	@Test
	public void testInsert() {
		Post p = Post.builder().title("TEST@@").author("JOHNK08").content("Insert TEST").build();
		log.debug("dao = {}", dao);
		int result = dao.insert(p);
		Assertions.assertEquals(1, result);
		log.debug("%d 행이 삽입." , result);
		// insert 메소드의 리턴 값이 1이면 단위 테스트 성공.
	}
	
//	@Test
	public void testDelete() {
		int result = dao.delete(1);
		Assertions.assertEquals(1, result);
		log.debug(result + "행이 삭제.");
		
		result = dao.delete(20); // id(PK)가 없는 경우
		Assertions.assertEquals(0, result);
	}
	
	@Test
	public void testSelectById() {
		Post result = dao.select(23);
		Assertions.assertNotNull(result);
		log.debug(result.toString() + "검색 성공");
		
		result = dao.select(0);
		Assertions.assertNull(result);
		
	}
}
