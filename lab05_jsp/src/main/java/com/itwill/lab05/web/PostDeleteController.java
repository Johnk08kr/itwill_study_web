package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "postDeleteController", urlPatterns = {"/post/delete"})
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostDeleteController.class);
	private static PostService postService = PostService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost()");

		int id = Integer.parseInt(req.getParameter("id"));
		log.debug("id={}", id);
		
		int result = postService.delete(id);
		log.debug("{}행 삭제", result);
		
		String url = req.getContextPath() + "/post/list";
		log.debug("redirect: " + url);
		resp.sendRedirect(url);
	}

}
