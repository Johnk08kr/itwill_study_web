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
public class PostUpdateItemDto {
	
	private Long id;
	
	private String title;

	private String content;
	
	public Post toEntity() {
		return Post.builder().id(id).title(title).content(content).build();
	}
}
