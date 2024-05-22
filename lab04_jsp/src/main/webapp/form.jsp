<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>form</title>
</head>
<body>
    <%@ include file="header.jspf"%>
    <main>
        <h1>Form</h1>

        <form method="get" action="form_result.jsp">
            <div>
                <input type="text" name="username" placeholder="이름입력"
                    autofocus required />
            </div>
            <div>
                <select name="color">
                    <option value="r">Red</option>
                    <option value="g">Green</option>
                    <option value="b">Blue</option>
                </select>
            </div>
            <div>
                <input type="submit" value="제출" />
            </div>
        </form>
    </main>
</body>
</html>