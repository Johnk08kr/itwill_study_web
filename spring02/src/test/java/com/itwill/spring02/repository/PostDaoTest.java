package com.itwill.spring02.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })

public class PostDaoTest {

	@Autowired
	private PostDao postDao;

	@Test
	public void testSelectAll() {
		Assertions.assertNotNull(postDao);

		List<Post> list = postDao.selectOrderByIdDesc();
		for (Post p : list) {
			System.out.println("\t" + p);
		}
	}

//	@Test
	public void testSelectById() {
		Post post1 = postDao.selectById(49); // 있는 경우
		Assertions.assertNotNull(post1);
		log.debug(post1.toString());

		Post post2 = postDao.selectById(1); // 없는 경우
		Assertions.assertNull(post2);
		log.debug(post2.toString());
	}
	
//	@Test
	public void testInsert() {
		Post post = Post.builder().title("MyBatis TEST").content("TEST...").author("admin").build();
		int result = postDao.insertPost(post);
		Assertions.assertEquals(1, result);
	}
	
//	@Test
	public void testUpdate() {
		Post post = Post.builder().id(61).title("MyBatis Update TEST2").content("Update TEST2...").build();
		int result = postDao.updatePost(post);
		Assertions.assertEquals(1, result);
	}
	
//	@Test 
	public void testDelete() {
		int result = postDao.deletePost(48);
		Assertions.assertEquals(1, result);
	}
}
