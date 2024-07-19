package com.itwill.springboot2.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM(Object Relation Mapping) -> JPA(Java Persistence API) -> Hibernate
@NoArgsConstructor @Data
@Entity // DB 테이블과 매핑하는 자바 객체
@Table(name = "EMP") // 클래스 이름과 실제 테이블의 이름이 다를 때 설정
public class Employee {
	@Id // primaryKey
	@Column(name = "EMPNO") // 필드 이름과 실제 컬럼 이름이 다를 때
	private Integer id;
	private String ename;
	private String job;
	@Column(name = "MGR")
	private Integer manager;
	private LocalDate hiredate;
	@Column(name = "SAL")
	private Double salary;
	@Column(name = "COMM")
	private Double commision;
	private Integer deptno;
}
