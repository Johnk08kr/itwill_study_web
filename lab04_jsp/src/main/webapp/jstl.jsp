<%@page import="com.itwill.lab04.model.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL</title>

</head>
<body>
    <%@ include file="header.jspf" %>
    
    <main>
        <h1>JSTL(JSP Standard Tag Library)</h1>
        <%-- JSTL 라이브러리 사용하기
        1. pom.xml 파일에 의존성(dependency)을 추가.
           o. jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0
           o. org.glassfish.web:jararta.servlet.jsp.jstl:3.0.1
        2. JSTL을 사용하는 JSP 파일에서 <%@ taglib prefix="" uri="" %> 지시문을 설정.
         --%>
         
        <%
        String[] sns = {"인스타", "싸이월드", "얼굴책", "X"};
        pageContext.setAttribute("sns", sns);
        %>
        <h2>스크립트릿, 식 사용한 리스트</h2>
        <ul>
            <% for(String s : sns) { %>
            <li><%= s %></li>
            <% } %>
        </ul>
        
        <h2>JSTL, EL을 사용한 리스트</h2>
        <ul>
            <c:forEach items="${ sns }" var="value">
                <li>${ value }</li>
            </c:forEach>
        </ul>
        
        <%
        ArrayList<Contact> data = new ArrayList<>(); 
        for (int i = 1; i <= 10; i++){
            data.add(new Contact(i, "name_" + i, "phone_" + i, "email_" + i));   
        }
        pageContext.setAttribute("contactList", data);
        %>
        
        <h2>스크립트릿, 식 사용한 테이블</h2>
        <table>
            <thead>
                <tr>
                    <td>ID.</td>
                    <td>NAME.</td>
                    <td>PHONE.</td>
                    <td>EMAIL.</td>
                </tr>
            </thead>
            <tbody>
                <% for(Contact c : data) { %>
                    <tr>
                        <td><%= c.getId() %></td> 
                        <td><%= c.getName() %></td> 
                        <td><%= c.getPhone() %></td> 
                        <td><%= c.getEmail() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
        <h2>JSTL, EL을 사용한 테이블</h2>
        <table>
            <thead>
                <tr>
                    <td>ID.</td>
                    <td>NAME.</td>
                    <td>PHONE.</td>
                    <td>EMAIL.</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ contactList }" var="contact" >
                    <tr>
                        <td>${ contact.id }</td> 
                        <td>${ contact.name }</td> 
                        <td>${ contact.phone }</td> 
                        <td>${ contact.email }</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>        
        
        <h2>URL 태그 </h2>
        <a href="result.jsp?username=gu&est&color=crimson">클릭해봐라</a>
        <%-- 질의 문자열의 요청 파라미터 값에 특수 기호가 포함될 때 --%>
        <c:url value="result.jsp" var="url">
            <c:param name="username" value="gu&est"/>
            <c:param name="color" value="crimson"/>
        </c:url>
        <a href="${ url }">클릭해봐</a>
        <%--
        https://central.sonatype.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api
        Snippets 복사 -> pom.xml -> build 위쪽 -> <dependencies>요기에</dependencies>
        https://central.sonatype.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl
         --%>
    </main>
</body>
</html>