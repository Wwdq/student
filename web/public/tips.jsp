
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
    <title> 公告</title>


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
            公告</h2>
    </caption>
    <thead>
    <c:forEach  items="${tip}" var="a">


    <tr>
        <th>公告编号</th>
        <th>详细信息</th>

    </tr>
    </thead>
    <tr>
        <td>${a.id}</td>
        <td>${a.tstring}</td>

    </tr>
     </c:forEach>

</table>


</body>



</html>