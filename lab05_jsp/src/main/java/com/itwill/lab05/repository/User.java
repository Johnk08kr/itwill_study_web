package com.itwill.lab05.repository;

public class User {
	// field
	private Integer id;
	private String userId;
	private String password;
	private String email;
	private Integer point;
	
	public User() {
		
	}

	public User(Integer id, String userId, String password, String email, Integer point) {
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.point = point;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", email=" + email + ", point="
				+ point + "]";
	}
	
	public static UserBuilder builder() {
		return new UserBuilder();
	}
	
	public static class UserBuilder {
		private Integer id;
		private String userId;
		private String password;
		private String email;
		private Integer point;
		
		public UserBuilder() {
			
		}
		
		public UserBuilder id(Integer id) {
			this.id = id;
			return this;
		}
		
		public UserBuilder userId(String userId) {
			this.userId = userId;
			return this;
		}
		
		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public UserBuilder point(Integer point) {
			this.point = point;
			return this;
		}
		
		public User build() {
			return new User(id, userId, password, email, point);
		}
	}
}
