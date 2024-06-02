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
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "userSignInController", urlPatterns = { "/user/signin" })
public class UserSignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserSignInController.class);
	private final UserService userService = UserService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		req.getRequestDispatcher("/WEB-INF/views/user/signin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost()");

		String userid = req.getParameter("userid");
		String password = req.getParameter("password");

		User user = userService.signIn(userid, password);
		if (user != null) {
			// 세션에 로그인 정보를 저장.
			HttpSession session = req.getSession();
			session.setAttribute("signedInUser", user.getUserId());

			// FIXME: 타겟 목적지(URL)로 이동
			String target = req.getContextPath() + "/"; // home
			resp.sendRedirect(target);
		} else {
			// 다시 로그인 페이지로 이동
			String url = req.getContextPath() + "/user/signin";
			resp.sendRedirect(url);
		}

	}

}
