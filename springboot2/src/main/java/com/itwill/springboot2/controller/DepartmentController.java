package com.itwill.springboot2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentService deptService;

	@GetMapping("/list")
	public void list(Model model) {
		List<Department> deptList = deptService.getDeptList();
		log.info("departmentList={}", deptList);
		model.addAttribute("deptList", deptList);
	}

	@GetMapping("/details/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		log.info("departmentDetail={}", id);
 
		Department dept = deptService.getDeptById(id);
		log.info("dept={}", dept);
		model.addAttribute("dept", dept);

		return "department/details";
	}
}
