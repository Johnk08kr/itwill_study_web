<%@page import="com.itwill.lab04.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>action tag</title>
    <style>
        p {
            border: 1px solid gray;
            border-radius: 8px;
            margin: 16px;
            padding: 16px;
            background: grey;
            box-shadow: 5px 5px black;
        }
    </style>    
</head>
<body>
    <%@ include file="header.jspf" %>
    
    <main>
        <h1>JSP Action Tag</h1>
        <%--
        JSP action tag: scriptlet에서 사용되는 일부 자바 코드들을 HTML 또는 XML과 비슷하게
        태그, 태그 속성, 태그 컨텐트를 작성해서 대체하는 문법.
        JSP action tag는 대/소문자를 구분! (HTML 태그는 대/소문자를 구분하지 않음.) 
        o. <jsp:forward></jsp:forward>
        o. <jsp:include></jsp:include>
        o. <jsp:useBean></jsp:useBean>: 생성자 호출
        o. <jsp:getProperty></jsp:getProperty>: getter 메소드 호출
        o. <jsp:setProperty></jsp:setProperty>: setter 메소드 호출
         --%>
        <h2>액션 태그를 사용하지 않은 자바 객체 생성</h2>
        <%
        Contact contact1 = new Contact(); // 기본 생성자 호출
        contact1.setId(1);
        contact1.setName("Johnk");
        contact1.setPhone("010-0000-0000");
        contact1.setEmail("yohan1235@naver.com");
        %>
        <p>
        ID: <%= contact1.getId() %><br/>
        NAME: <%= contact1.getName() %><br/>
        PHONE: <%= contact1.getPhone() %><br/>
        EMAIL: <%= contact1.getEmail() %><br/>
        </p>
        </div>
        <h2>액션 태그 java bean을 사용한 객체 생성</h2>
        <jsp:useBean id="contact2" class="com.itwill.lab04.model.Contact" />
        <%-- Contact contact2 = new Contact(); --%>
        <jsp:setProperty property="id" name="contact2" value="2" />
        <%-- contact2.setId(2); --%>
        <jsp:setProperty property="name" name="contact2" value="Johnk08" />
        <jsp:setProperty property="phone" name="contact2" value="010-5037-9881" />
        <jsp:setProperty property="email" name="contact2" value="rnjsdygks@gmail.com" />
        <p>
        ID: <jsp:getProperty property="id" name="contact2"/> <br/>
        NAME: <jsp:getProperty property="name" name="contact2"/> <br/>
        PHONE: <jsp:getProperty property="phone" name="contact2"/> <br/>
        EMAIL: <jsp:getProperty property="email" name="contact2"/> <br/>
        </p>
    </main>
    
    <jsp:include page="footer.jsp" />
    <%-- <%@ include file="" %>와 비슷하지만, JSP 파일들이 각각 컴파일된 후 합쳐짐. --%>
</body>
</html>