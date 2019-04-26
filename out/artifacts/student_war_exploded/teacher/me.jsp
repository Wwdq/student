
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
         <th>工号</th>
         <th>姓名</th>
         <th>生日</th>
         <th>QQ号</th>
         <th>我的课程</th>
     </tr>
     </thead>
     <tr>
         <td>${teacher.tno}</td>
         <td>${teacher.name}</td>
         <td>${teacher.birth}</td>
         <td>${teacher.QQ}</td>
         <td>
             <c:forEach  items="${teacher.course}" var="a">
                     高${a.grade.grade}&nbsp;${a.grade.cid}班&nbsp;${a.cname}
                      <br>
              </c:forEach>
         </td>
     </tr>
     <tr>
         <td colspan="5"><a  href="../public/QQ.html">修改我的信息</a></td>
     </tr>
 </table>


 </body>



 </html>