package com.itwill.lab05.repository;

import java.time.LocalDateTime;

// MVC 아키텍처에서 Model 역할 클래스, DB의 posts 테이블 구조와 같은 클래스.
public class Post {
	// field
	private Integer id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime createTime;
	private LocalDateTime modifiedTime;

	public Post() {

	}

	public Post(Integer id, String title, String content, String author, LocalDateTime createTime,
			LocalDateTime modifiedTime) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createTime = createTime;
		this.modifiedTime = modifiedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createTime="
				+ createTime + ", modifiedTime=" + modifiedTime + "]";
	}
	
	// builder 패턴
	public static PostBuilder builder() {
		return new PostBuilder();
		
	}
	
	public static class PostBuilder {
		private Integer id;
		private String title;
		private String content;
		private String author;
		private LocalDateTime createTime;
		private LocalDateTime modifiedTime;
		
		public PostBuilder() {}
		
		public PostBuilder id(Integer id) {
			this.id = id;
			return this;
		}
		public PostBuilder title(String title) {
			this.title = title;
			return this;
		}
		public PostBuilder content(String content) {
			this.content = content;
			return this;
		}
		public PostBuilder author(String author) {
			this.author = author;
			return this;
		}
		public PostBuilder createTime(LocalDateTime createTime) {
			this.createTime = createTime;
			return this;
		}
		public PostBuilder modifiedTime(LocalDateTime modifiedTime) {
			this.modifiedTime = modifiedTime;
			return this;
		}
		
		public Post build() {
			return new Post(id, title, content, author, createTime, modifiedTime);
		}
	}
	
}
