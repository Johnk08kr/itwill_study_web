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
public class CommentDaoTest {
	
	@Autowired
	private CommentDao commentDao;
	
	@Test
	public void testSelect() {
		Assertions.assertNotNull(commentDao);
		List<Comment> list = commentDao.selectByPostId(67);
		for(Comment c : list) {
			log.debug(c.toString());
		}
	}
	
	@Test 
	public void testInsert() {
		Comment comment = Comment.builder().postId(67).userName("JOHNK").cText("밖으로 나가버리고").build();
		int result = commentDao.insert(comment);
		Assertions.assertEquals(1, result);
	}
}
