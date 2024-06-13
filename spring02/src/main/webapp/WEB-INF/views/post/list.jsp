<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Spring Legacy 02</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
        />
    </head>
    <body>
        <div class="container-fluid">
            <c:set var="pageTitle" value="Post List" scope="page" />
            <%-- pageContext.setAttribute("pageTitle", "Home"); --%> <%@ include file="../fragments/header.jspf"%>
        </div>
        <div class="mt-2 card">
            <div class="card-header">
                <c:url var="postSearchPage" value="/post/search" />
                <form method="get" action="${postSearchPage}">
                    <div class="row">
                        <div class="col-3">
                            <select class="form-control" name="category">
                                <option value="t">제목</option>
                                <option value="c">내용</option>
                                <option value="tc">제목+내용</option>
                                <option value="a">작성자</option>
                            </select>
                        </div>
                        <div class="col-7">
                            <input class="form-control" type="text" name="keyword" placeholder="검색어 입력해" required />
                        </div>
                        <div class="col-2">
                            <input class="form-control btn btn-primary" type="submit" value="검색" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="card-body">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>NO</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>ModifyTime</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${posts}" var="post">
                            <tr>
                                <td>${ post.id }</td>
                                <td>
                                    <c:url var="postDetailPage" value="/post/detail">
                                        <c:param name="id" value="${post.id}"></c:param>
                                    </c:url>
                                    <a href="${postDetailPage}">${post.title}</a>
                                </td>
                                <td>${ post.author }</td>
                                <td>${ post.modifiedTime }</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
