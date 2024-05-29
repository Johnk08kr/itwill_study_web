package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PostCreateController", urlPatterns = { "/post/create" })
public class PostCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostCreateController.class);
	
	private final PostService postService = PostService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		
		// 새 글 작성 폼(양식)을 작성하는 뷰(JSP)로 이동.
		req.getRequestDispatcher("/WEB-INF/views/post/create.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost()");
		
		// request에 포함된 정보들 읽음
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String author = req.getParameter("author");
		
		Post post = Post.builder().title(title).content(content).author(author).build();
		log.debug("post={}", post);
		
		// TODO: 서비스 객체의 메소드를 호출해서 DB저장
		int result = postService.create(post);
		log.debug(result + "행 생성");
		
		// TODO: postListPage로 이동
		String url = req.getContextPath() + "/post/list";
		log.debug("redirect: " + url);
		resp.sendRedirect(url);
		
		// PRG(Post-Redirect-Get)
		
				
	}

}
