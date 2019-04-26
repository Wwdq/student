<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/9
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/student/bootstrap-3.3.7-dist/css/bootstrap.css">
    <title>Title</title>
</head>
<body>

<c:forEach items="${courses}" var="list">
<div class="list-group">
    <a href="#" class="list-group-item list-group-item-danger disabled"> 高${list.grade.grade}&nbsp;${list.grade.cid}班&nbsp;${list.cname}</a>
    <c:forEach items="${list.exams}" var="a">
<div class="list-group">
    <a href="/student/teacher/score?id=${a.eno}" class="list-group-item list-group-item-success" >&nbsp;&nbsp;&nbsp;${a.estring}&nbsp;查看详情</a>
     </div>
    </c:forEach>
    </c:forEach>

</body>
</html>
