package com.itwill.lab05.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.repository.UserDao;

public enum UserService {
	INSTANCE;

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	private UserDao userDao = UserDao.INSTANCE;

	// TODO: 회원 가입에 필요한 메소드, userDao.insert() 호출.
	public int signUp(User user) {
		log.debug("signUp(user={})", user);

		int result = userDao.insert(user);
		log.debug("insert result={}", result);
		return result;
	}
	
	// TODO: 로그인에 필요한 메소드, userDao.selectByUseridAndPassword() 호출
	public User signIn(String userid, String password) {
		log.debug("signIn(userId={}, password={})", userid, password);
		
		// DTO(Data Transfer Object)
		User dto = User.builder().userId(userid).password(password).build();
		User user = userDao.selectByUseridAndPassword(dto);
		log.debug("로그인 결과 = {}", user);
		
		return user;
	}
}
