package com.itwill.spring02.repository;

public interface UserDao {
	User selectByUserid(String userid);
	int insertUser(User user);
}
