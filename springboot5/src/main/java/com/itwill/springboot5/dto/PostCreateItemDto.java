package com.itwill.springboot5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostCreateItemDto {

	private String title;

	private String author;

	private String content;

	public static PostCreateItemDto fromEntity(String title, String author, String content) {
		return PostCreateItemDto.builder().title(title).author(author).content(content).build();
	}
}
