package com.itwill.springboot4.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="QUESTIONS")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //-> Oracle: generated as identity, MySQL: autoincrement
	@Column(name = "QID") 
	private Long id;
	
	@Basic(optional = false) // Not Null
	private String title;
	
	@Basic(optional = false) // Not Null
	@Column(length = 1000)
	private String content;
}
