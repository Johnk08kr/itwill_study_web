package com.itwill.spring01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//--> @getter, @setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 초기화할 수 있는 argument들을 갖는 생성자.
@Builder 
public class UserDto {
	private String username;
	private Integer age;
}
