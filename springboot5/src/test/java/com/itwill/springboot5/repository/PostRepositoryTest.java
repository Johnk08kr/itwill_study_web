package com.itwill.springboot5.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot5.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	private PostRepository postRepo;

//	@Test
	public void testDependencyInjection() {
		assertThat(postRepo).isNotNull();
		log.info("postRepo={}", postRepo);
	}

//	@Test
	public void testFindAll() {
		List<Post> list = postRepo.findAll();
		assertThat(list.size()).isEqualTo(0);

		list.forEach(System.out::println);
	}

//	@Test
	public void testSave() {
		// DB에 저장할 엔터티 객체 생성:
		Post entity = Post.builder().title("testTitle").content("testContent").author("testAuthor").build();
		log.info("before save: {}", entity);
		
		// insert 쿼리 실행: 엔터티 객체의 @Id 설정된 필드가 null인 경우.
		postRepo.save(entity);
		log.info("after save: {}", entity);
	}
	
//	@Test
	public void testUpdate() {
		Post entity = postRepo.findById(1L).orElseThrow();
		log.info("entity(id:1)={}", entity);
		
		entity.update("update3TestTitle", "update3TestContent");
		log.info("updateEntity(id:1)={}", entity);
		
		// update 쿼리 실행: 
		// @Id 필드가 null이 아닌 경우(레코드가 있는 경우)
		// & 엔터티 객체가 DB에 있는 레코드와 다른 경우.
		postRepo.save(entity);
		log.info("beforeUpdateSave={}", entity);
	}
	
//	@Test
	public void testDelete() {
		postRepo.deleteById(1L); 
		// JPA는 id로 select 쿼리를 먼저 실행한 후
		// 엔터티가 존재하는 경우에 delete 쿼리를 실행.
	}
	
	@Test
	public void makeDummyData() {
		List<Post> data = new ArrayList<>();
		for(int i = 1; i <= 50; i++) {
			Post post = Post.builder().title("Dummy Title #" + i).content("Dummy Content #" + i).author("Dummy Author #" + i).build();
			data.add(post);
		}
		
		postRepo.saveAll(data);
	}
	
}
