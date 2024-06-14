package com.itwill.spring02.dto;

import com.itwill.spring02.repository.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CommentUpdateDto {
	private Integer id;
	private String ctext;
	
	public Comment toEntity() {
		return Comment.builder().id(id).cText(ctext).build();
	}
	
}
