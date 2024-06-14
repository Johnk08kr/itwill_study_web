package com.itwill.spring02.dto;

import com.itwill.spring02.repository.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 댓글 작성시 요청 파라미터로 전달되는 값들을 저장하기 위한 DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCreateDto {
	private Integer postId;
	private String ctext;
	private String userName;

	public Comment toEntity() {
		return Comment.builder().postId(postId).cText(ctext).userName(userName).build();
	}
	
	
}
