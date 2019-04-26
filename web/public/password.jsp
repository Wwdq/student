
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/6
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <style type="text/css">
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
        <h2>
            我的信息</h2>
    </caption>
    <thead>
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>姓名</th>
        <th>账户类型</th>
    </tr>
    </thead>
    <tr>
        <td>${user.id}</td>
        <td>${user.password}</td>
        <td>${user.name}</td>
        <td>
            <c:if test="${user.userid==1}">
             管理员
            </c:if>
            <c:if test="${user.userid==2}">
                老师
            </c:if>
            <c:if test="${user.userid==3}">
                学生
            </c:if>
        </td>

    </tr>
    <tr>

        <td><form action="password.html">
            <input type="submit"  value="修改密码">
        </form></td>
    </tr>
</table>


</body>



</html>