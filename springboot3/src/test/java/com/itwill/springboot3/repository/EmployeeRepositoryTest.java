package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository empRepo;

//	@Test
	public void testDependencyInjection() {
		// EmployeeRepository 객체의 의존성 주입 테스트
		assertThat(empRepo).isNotNull();
		log.info("empRepo={}", empRepo);
	}

//	@Test
	public void testFindAll() {
		// Employees 테이블 전체 검색 테스트
		long empCount = empRepo.count();
		assertThat(empCount).isEqualTo(107L);

		List<Employee> empList = empRepo.findAll();
		log.info("employees[0]={}", empList.get(0));
	}

	@Transactional
	@Test
	public void testFindById() {
		// 1. EmployeeRepository.findById() 테스트
		// 2. Employees 테이블 - Jobs 테이블 간의 관계 테스트
		// 3. Employees 테이블 - Employees 테이블 간의 관계 테스트

		Employee emp = empRepo.findById(139).orElseThrow();
		assertThat(emp.getId()).isEqualTo(139);
		log.info("emp[139]={}", emp);
		log.info("emp[139].job={}", emp.getJob());
		log.info("emp[139].manager={}", emp.getManager());
		log.info("emp[139].department={}", emp.getDepartment());
		log.info("emp[139].location={}", emp.getDepartment().getLocation());
		log.info("emp[139].country={}", emp.getDepartment().getLocation().getCountry());
	}
}
