package com.itwill.springboot2.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// ORM(Object Relation Mapping) -> JPA(Java Persistence API) -> Hibernate
@NoArgsConstructor
@Data
@Entity // DB 테이블과 매핑하는 자바 객체
@Table(name = "EMP") // 클래스 이름과 실제 테이블의 이름이 다를 때 설정
public class Employee {
	@Id // primaryKey
	@Column(name = "EMPNO") // 필드 이름과 실제 컬럼 이름이 다를 때
	private Integer id;

	private String ename;

	private String job;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MGR")
	private Employee manager;

	private LocalDate hiredate;

	@Column(name = "SAL")
	private Double salary;

	@Column(name = "COMM")
	private Double commission;

	@ToString.Exclude // toString 메소드의 출력 문자열에서 제외.
	// LAZY & EAGER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPTNO") // EMP 테이블에서 DEPT 테이블과 join하는 컬럼 이름.
	private Department department;
}
