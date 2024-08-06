package com.itwill.springboot5.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CommentRepositoryTest {
	
	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private PostRepository postRepo;
	
//	@Test
	public void testDependencyInjection() {
		assertThat(commentRepo).isNotNull();
		log.info("commentRepo={}", commentRepo);
	}
	
//	@Test
	public void testSave() {
		Post post = postRepo.findById(113L).orElseThrow();
		Comment entity = Comment.builder().post(post).ctext("first comment").writer("kyh").build();
		log.info("before save={}", entity);
		
		commentRepo.save(entity);
		log.info("after save={}", entity);
	}

}
