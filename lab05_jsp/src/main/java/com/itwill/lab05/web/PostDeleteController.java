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
	private final PostService postService = PostService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		
		int id = Integer.parseInt(req.getParameter("id"));
		log.debug("id={}", id);
		
		int result = postService.delete(id);
		log.debug("{}행 삭제", result);
		
		
		// 목록 페이지로 이동(redirect)
		// 최초 요청주소와 최종 주소가 다를때 
		String url = req.getContextPath() + "/post/list";
		log.debug("redirect: {}", url);
		resp.sendRedirect(url);
	}
}
