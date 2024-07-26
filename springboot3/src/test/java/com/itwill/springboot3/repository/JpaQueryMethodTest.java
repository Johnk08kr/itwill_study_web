package com.itwill.springboot3.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JpaQueryMethodTest {

	@Autowired
	private EmployeeRepository empRepo;

//	@Test
	public void testFindByDeptId() {
		List<Employee> empList = empRepo.findByDepartmentId(30);
		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindByFirstName() {
		List<Employee> empList = empRepo.findByFirstName("John");
		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindByFirstNameContaining() {
		List<Employee> empList = empRepo.findByFirstNameContaining("St");
		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindByFirstNameContainingIgnoreCase() {
		List<Employee> empList = empRepo.findByFirstNameContainingIgnoreCase("Ev");
		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindByFirstNameContainingIgnoreCaseOrderByfirstNameDesc() {
		List<Employee> empList = empRepo.findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc("Ev");
		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindBySalary() {
		// 1. 급여가 어떤 값을 초과하는 직원들의 정보
//		List<Employee> empList = empRepo.findBySalaryGreaterThan(5000.);

		// 2. 급여가 어떤 값 미만인 직원들의 정보
//		List<Employee> empList = empRepo.findBySalaryLessThan(5000.);

		// 3. 급여가 어떤 범위 안에 있는 직원들의 정보
		List<Employee> empList = empRepo.findBySalaryBetween(2000., 2500.);
		empList.forEach(System.out::println);
	}

//	@Test 
	public void testFindByHireDate() {
		// 4. 입사날짜가 특정 날짜 이전인 직원들의 정보
//		List<Employee> empList = empRepo.findByHireDateBefore(LocalDate.of(2006, 1, 1));

		// 5. 입사날짜가 특정 날짜 이후인 직원들의 정보
//		List<Employee> empList = empRepo.findByHireDateAfter(LocalDate.of(2006, 1, 1));

		// 6. 입사날짜가 날짜 범위 안에 있는 직원들의 정보
		List<Employee> empList = empRepo.findByHireDateBetween(LocalDate.of(2006, 1, 1), LocalDate.of(2007, 12, 31));

		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindByDepartment() {
		List<Employee> empList = empRepo.findByDepartmentDepartmentName("IT");
		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindByCity() {
		List<Employee> empList = empRepo.findByDepartmentLocationCity("Seattle");
		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindByFirstNameAndLastName() {
//		List<Employee> empList = empRepo.findByfirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("in", "oh");
//		List<Employee> empList = empRepo.findByName("in", "in");
		List<Employee> empList = empRepo.findByDepartmentDepartmentName("in");

		empList.forEach(System.out::println);
	}

//	@Test
	public void testFindByDeptName() {
		List<Employee> empList = empRepo.findByDeptName("IT");
		empList.forEach(System.out::println);
	}
	
//	@Test
	public void testFindByCity2() {
		List<Employee> empList = empRepo.findByCity("Oxford");
		empList.forEach(System.out::println);
	}
	
	@Test
	public void testFindByCountry() {
		List<Employee> empList = empRepo.findByCountry("canada");
		empList.forEach(System.out::println);
	}
}
