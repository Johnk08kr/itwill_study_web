package com.itwill.springboot2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot2.domain.Department;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentRepositoryTest {
	// TODO: DEPT 테이블과 매핑되는 엔티티 클래스를 설계, 리포지토리 인터페이스 작성
	// 단위 테스트 클래스 작성.
	
	@Autowired
	private DepartmentRepository deptRepo;
	
//	@Test
	public void deptTest() {
		assertThat(deptRepo).isNotNull();
		log.info("{}", deptRepo);
	}
	
//	@Test
	public void findAllTest() {
		List<Department> listDept = deptRepo.findAll();
		
		for (Department d : listDept) {
			System.out.println(d);
		}
	}
	
	@Test
	public void findByTest() {
		Optional<Department> dept = deptRepo.findById(20);
		assertThat(dept).isNotNull();
		System.out.println(dept);
	}
 	
}
