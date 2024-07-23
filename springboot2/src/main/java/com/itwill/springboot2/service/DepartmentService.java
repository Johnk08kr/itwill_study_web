package com.itwill.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {

	private final DepartmentRepository deptRepo;

	public List<Department> getDeptList() {
		log.info("getDeptList()");
		List<Department> list = deptRepo.findAll();
		return list;
	}

	public Department getDeptById(Integer id) {
		log.info("getDeptById():{}", id);
		Department dept = deptRepo.findById(id).orElseThrow();
		return dept;
	}
}
