<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/9
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/student/bootstrap-3.3.7-dist/css/bootstrap.css">
    <title>Title</title>
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
<form action="/student/teacher/sure" method="post">
<table class="table table-hover">
    <thead >
    <tr class="warning">
        <td>学号</td>
        <td>姓名</td>
        <td>考试名称</td>
        <td>分数</td>
    </tr>
    </thead>

    <c:forEach  items="${exam.students}" var="s"  varStatus="status">

    <tr class="success">
        <td>${s.sno}</td>
        <td>${s.name}</td>
        <td>${exam.estring}</td>
        <td>${exam.scores[status.index].sc} <input type="text" name="score" class="form-control" id="exampleInputEmail3" placeholder="输入分数"></td>

    </tr>
        </c:forEach>

    <tr class="active">
        <td>
        <input type="submit" name="" id="" value="提交">
        </td>
    </tr>
</table>
    <table width="90%">
        <thead> 本次考试情况：</thead>
        <tr>
          <td>最高分</td>
          <td>最低分</td>
          <td>平均分</td>
          <td>参加人数</td>
          <td>及格人数</td>
          <td>及格率</td>
        </tr>
        <tr>
            <td>${exam.scoreTip.top}</td>
            <td>${exam.scoreTip.lastone}</td>
            <td>${exam.scoreTip.avgs}</td>
            <td>${exam.scoreTip.total}</td>
            <td>${exam.scoreTip.number}</td>
            <td>${exam.scoreTip.bai*100}%</td>

        </tr>
    </table>
    </form>






</body>
</html>
