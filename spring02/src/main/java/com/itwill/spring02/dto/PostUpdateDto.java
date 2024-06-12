package com.itwill.spring02.dto;

import com.itwill.spring02.repository.Post;

import lombok.Data;

@Data
public class PostUpdateDto {
	private Integer id;
	private String title;
	private String content;
	
	public Post toEntity() {
		return Post.builder().id(id).title(title).content(content).build();
	}
}
