package com.itwill.lab04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CookieController
 */
@WebServlet(name = "CookieController", urlPatterns = {"/cookie"} )
public class CookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cookie 생성
		Cookie cookie = new Cookie("HI", "안녕");
		
		// 생성된 Cookie 객체를 response 객체에 포함.
		response.addCookie(cookie);
		
		int count = 1; // 클라이언트가 서버를 방문한 횟수.
		
		// 클라이언트에서 보낸 쿠키를 WAS에서 확인하는 방법:
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			System.out.println(c.getName() + " = " + c.getValue());
			if (c.getName().equals("cnt")) {
				// "cnt" 쿠기가 있으면, 쿠키에 저장된 값으로 count 변수를 변경.
				count = Integer.parseInt(c.getValue());
			}
		}
		
		// count 변수의 값을 request 객체의 속성(attribute)으로 추가 --> JSP(뷰)로 전달
		request.setAttribute("visitCount", count);
		
		// 방문 횟수를 증가
		count++;
		
		// 방문 횟수를 저장한 쿠키를 response 객체에 포함.
		Cookie visitCookie = new Cookie("cnt", String.valueOf(count));
		visitCookie.setMaxAge(24 * 60 * 60); // 쿠키 만료 기간 설정.
		response.addCookie(visitCookie);		
		
		// view forward
		request.getRequestDispatcher("/WEB-INF/views/cookie.jsp").forward(request, response);
		
	}	

}
