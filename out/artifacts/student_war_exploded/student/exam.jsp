<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/10
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title> <style type="text/css">
    table
    {
        border-collapse: collapse;
        margin: 0 auto;
        text-align: center;
    }
    table td, table th
    {
        border: 1px solid #cad9ea;
        color: #666;
        height: 30px;
    }
    table thead th
    {
        background-color: #CCE8EB;
        width: 100px;
    }
    table tr:nth-child(odd)
    {
        background: #fff;
    }
    table tr:nth-child(even)
    {
        background: #F5FAFA;
    }
</style>

</head>
<body>
<table width="90%" >
    <caption>
        <h2>我的成绩</h2>
    </caption>
    <thead>
    <tr>
        <td>考试名称</td>
        <td>科目</td>
        <td>分数</td>
        <td>考试排名</td>

    </tr>
    </thead>
    <c:if test="${empty score}">
        <tr>
            <td colspan="3">暂时没有你的考试信息</td>
        </tr>
    </c:if>
    <c:forEach items="${score}" var="a">
        <tr>
            <td>${a.exam.estring}</td>
            <td>${a.exam.cname}</td>
            <td><c:if test="${a.sc==0}">
                分数还未更新 请耐心等待
                  </c:if>
                <c:if test="${a.sc!=0}">
                    <c:out value="${a.sc}"></c:out>
                </c:if>
            <td>${a.sc%10}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
