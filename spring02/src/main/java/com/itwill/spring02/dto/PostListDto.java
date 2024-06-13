package com.itwill.spring02.dto;

import java.time.LocalDateTime;

import com.itwill.spring02.repository.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO(Data Transfer Object)
// view<->controller, controller<->service 데이터 주고 받을 때 사용하는 객체

@Data // .....+@RequiredArgsConstructor: 기본생성자 아님(final)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostListDto {

	private Integer id;
	private String title;
	private String author;
	private LocalDateTime modifiedTime;

	public static PostListDto fromEntity(Post post) {
		return PostListDto.builder().id(post.getId()).title(post.getTitle()).author(post.getAuthor())
				.modifiedTime(post.getModifiedTime()).build();
	}

}
