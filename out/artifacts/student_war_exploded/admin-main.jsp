<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/5
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>成绩管理系统界面</title>

</head>
<frameset rows="88,*,31" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
    <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
        <frame src="admin-left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
        <frame src="right.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
    </frameset>
    <frame src="bottom.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
</frameset>
<noframes><body>
</body></noframes>
</html>



