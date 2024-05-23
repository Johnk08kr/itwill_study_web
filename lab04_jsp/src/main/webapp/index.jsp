<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lab 04</title>
</head>
<body>
    <header>
        <h1>Contents</h1>
        <h2><%= LocalDateTime.now() %></h2>
    </header>
    <main>
        <ul>
            <li><a href="ex1">첫번째 Servlet</a></li>
            <li><a href="ex2">두번째 Servlet</a></li>
            <li><a href="ex3">forward</a></li>
            <li><a href="ex4">redirect</a></li>
            <li><a href="intro.jsp">JSP 소개</a></li>
            <li><a href="main.jsp">include 지시문</a></li>
            <li><a href="scriptlet.jsp">스크립트릿(scriptlet)</a></li>
            <li><a href="form.jsp">form 양식</a></li>
            <li><a href="actionTag.jsp">JSP Action Tag</a></li>
            <li><a href="el.jsp">EL(Expression Language)</a></li>
            <li><a href="jstl.jsp">JSTL</a></li>
        </ul>
    </main>
</body>
</html>