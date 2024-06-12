package com.itwill.spring02.service;

import org.springframework.stereotype.Service;

import com.itwill.spring02.repository.User;
import com.itwill.spring02.repository.UserDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

	private final UserDao userDao;
	
	public void createUser(User user) {
		log.debug("createUser()");
		
		userDao.insertUser(user);
	}
	
//	public User loginUser()
	
}
