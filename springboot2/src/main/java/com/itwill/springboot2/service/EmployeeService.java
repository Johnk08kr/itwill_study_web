package com.itwill.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot2.domain.Employee;
import com.itwill.springboot2.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {
	
	private final EmployeeRepository empRepo;
	
	public List<Employee> getEmpList(){
		log.info("getEmpList()");
		List<Employee> list = empRepo.findAll();
		return list;
	}
	
	public Employee getEmpById(Integer id) {
		log.info("getEmpById():{}", id);
		Employee emp = empRepo.findById(id).orElseThrow();
		return emp;
	}
}
