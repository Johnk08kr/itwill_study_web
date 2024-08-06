package com.itwill.springboot5.dto;

import com.itwill.springboot5.domain.Post;

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

	public Post toEntity() {
		return Post.builder().title(title).content(content).author(author).build();
	}
}
