package com.itwill.springboot2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data
@Entity
@Table(name = "DEPT")
public class Department {
	@Id
	@Column(name="DEPTNO")
	private Integer id;
	private String dname;
	@Column(name="LOC")
	private String location;
}
