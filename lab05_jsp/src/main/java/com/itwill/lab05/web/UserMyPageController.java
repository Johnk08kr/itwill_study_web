package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "userMyPageController", urlPatterns = {"/user/mypage"})
public class UserMyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserMyPageController.class);
	private final UserService userService = UserService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		
		String userid = req.getParameter("userid");
		log.debug("userid = {}", userid);
		
		User user = userService.read(userid);
		
		String url = req.getContextPath() + "/user/mypage";
		log.debug("redirect: " + url);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp").forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}
	
	
	

}
