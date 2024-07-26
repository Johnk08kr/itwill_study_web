package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Job;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JobRepositoryTest {
	
	@Autowired
	private JobRepository jobRepo;
	
//	@Test
	public void testDependencyInjection() {
		assertThat(jobRepo).isNotNull();
		log.info("jopRepo={}", jobRepo);
	}
	
//	@Test
	public void testFindAll() {
		long jobCount = jobRepo.count();
		assertThat(jobCount).isEqualTo(19L);
		
		List<Job> jobList = jobRepo.findAll();
		log.info("jobList[0]={}", jobList.get(0));
	}
	
	@Test
	public void testFindById() {
		Job job = jobRepo.findById("IT_PROG").orElseThrow();
		assertThat(job.getId()).isEqualTo("IT_PROG");
		
		log.info("job[IT_PROG]={}", job);
	}
	
}
