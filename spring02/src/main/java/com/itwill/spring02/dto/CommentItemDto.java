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
	private Timestamp modifiedTime;

	public static CommentItemDto fromEntity(Comment comment) {
		return CommentItemDto.builder().id(comment.getId()).cText(comment.getCText()).userName(comment.getUserName())
				.modifiedTime(Timestamp.valueOf(comment.getModifiedTime())).build();
	}
}
