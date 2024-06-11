package com.itwill.spring02.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class User {
	
	private Integer id;
	private String userid;
	private String password;
	private String email;
	private Integer point;
}
