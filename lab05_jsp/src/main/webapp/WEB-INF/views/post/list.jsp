<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <c:set var="pageTitle" value="Post 목록" scope="page" />
        <%@ include file="../fragments/header.jspf"%>
    </div>
    <div class="mt-2 card">
        <div class="card-header">
            <h2 style="text-align: center">POSTS</h2>
        </div>
        <div class="card-body">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>CreateTime</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${posts}" var="post">
                        <tr>
                            <td>${ post.id }</td>
                            <td>
                                <c:url var="postDetailsPage" value="/post/details">
                                    <c:param name="id" value="${post.id}"></c:param>
                                </c:url>                             
                                <a href="${postDetailsPage}">${ post.title }</a>
                            </td>
                            <td>${ post.author }</td>
                            <td>${ post.createTime }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>