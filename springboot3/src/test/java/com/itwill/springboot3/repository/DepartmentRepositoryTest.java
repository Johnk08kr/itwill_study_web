package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Department;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository deptRepo;

//	@Test
	public void testDependencyInjection() {
		assertThat(deptRepo).isNotNull();
		log.info("deptRepo={}", deptRepo);
	}

//	@Test
	public void testFindAll() {
		long deptCount = deptRepo.count();
		assertThat(deptCount).isEqualTo(27L);

		List<Department> deptList = deptRepo.findAll();
		log.info("departments[0]={}", deptList.get(0));
	}

	@Transactional
	@Test
	public void testFindById() {
		Department dept = deptRepo.findById(60).orElseThrow();
		assertThat(dept.getId()).isEqualTo(60);
		log.info("dept[60]={}", dept);
		log.info("dept[60].manager={}", dept.getManager());
		log.info("dept[60].location={}",dept.getLocation());
	}
}
