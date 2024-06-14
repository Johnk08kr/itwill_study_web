package com.itwill.spring02.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.itwill.spring02.repository.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentItemDto {
	private Integer id;
	private String cText;
	private String userName;
	private LocalDateTime modifiedTime;

	public static CommentItemDto fromEntity(Comment comment) {
		return CommentItemDto.builder().id(comment.getId()).cText(comment.getCText()).userName(comment.getUserName())
				.modifiedTime(comment.getModifiedTime()).build();
	}
}
