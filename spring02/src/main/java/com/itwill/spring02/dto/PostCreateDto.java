package com.itwill.spring02.dto;

import com.itwill.spring02.repository.Post;

import lombok.Data;

@Data
public class PostCreateDto {
	
	String title;
	String content;
	String author;
	
	public Post toEntity() {
		return Post.builder().title(title).content(content).author(author).build();
	}
}
