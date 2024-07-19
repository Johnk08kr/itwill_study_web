package com.itwill.springboot2.repository;

// import static 구문: static 메소드, 필드 이름을 import
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot2.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {
	
	@Autowired // 의존성 주입(DI: dependency injection), 제어의 역전(Ioc: Inversion of Controll)
	private EmployeeRepository empRepo;
	
//	@Test
	public void empTest() {
		assertThat(empRepo).isNotNull(); // empRepo 객체가 null이 아니면 테스트 성공.
		log.info("{}", empRepo);
	}
	
	// select * from emp
//	@Test
	public void findAllTest() {
		List<Employee> listEmp = empRepo.findAll();
		assertThat(listEmp.size()).isEqualTo(14);
		
		for (Employee e : listEmp) {
			System.out.println(e);
		}
	}
	
//	@Test
	public void findByTest() {
		// 사번으로 검색하는 메소드 단위 테스트
		Optional<Employee> emp = empRepo.findById(7788);
		assertThat(emp).isNotNull();
		System.out.println(emp);
	}
}
