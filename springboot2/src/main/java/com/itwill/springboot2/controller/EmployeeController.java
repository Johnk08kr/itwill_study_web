package com.itwill.springboot2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot2.domain.Employee;
import com.itwill.springboot2.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화하는 생성자, 생성자에 의한 의존성 주입.
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService empService;
	
	@GetMapping("/list")
	public void list(Model model) {
		List<Employee> empList = empService.getEmpList();
		log.info("employeeList={}", empList);
		model.addAttribute("empList", empList);
	}
	
	@GetMapping("/details/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		log.info("employeeDetail={}", id);
		   
		Employee emp = empService.getEmpById(id);
		log.info("emp={}", emp);
		model.addAttribute("emp", emp);
		
		return "employee/details";
	}

}
