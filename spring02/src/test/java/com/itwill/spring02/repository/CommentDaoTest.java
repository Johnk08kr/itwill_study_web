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
	
//	@Test
	public void testSelect() {
		Assertions.assertNotNull(commentDao);
		List<Comment> list = commentDao.selectByPostId(67);
		for(Comment c : list) {
			log.debug(c.toString());
		}
	}
	
//	@Test 
	public void testInsert() {
		Comment comment = Comment.builder().postId(67).userName("JOHNK01").cText("siuuuuuuuuuu").build();
		int result = commentDao.insert(comment);
		Assertions.assertEquals(1, result);
	}
	
//	@Test
	public void testUpdate() {
		Comment comment = Comment.builder().id(2).cText("바뀐거한번볼래?").build();
		int result = commentDao.update(comment);
		Assertions.assertEquals(1, result);
	}
	
//	@Test
	public void testDeleteById() {
		int result = commentDao.deleteById(2);
		Assertions.assertEquals(1, result);
	}
	
//	@Test
	public void testDeleteByPostId() {
		int result = commentDao.deleteByPostId(67);
		Assertions.assertEquals(2, result);
	}
	
//	@Test
	public void testCommentCount() {
		int result = commentDao.selectCommentCount(67);
		Assertions.assertEquals(3, result);
	}
    
	@Test
    public void testSelectById() {
        // 테이블에 댓글 아이디(PK)가 있는 경우
        Comment comment1 = commentDao.selectById(5);
        Assertions.assertNotNull(comment1);
        log.debug(comment1.toString());
        
        // 테이블에 댓글 아이디가 없는 경우
        Comment comment2 = commentDao.selectById(1);
        Assertions.assertNull(comment2);
    }
}
