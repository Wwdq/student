<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/12/5
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(function(){
            //导航切换
            $(".menuson .header").click(function(){
                var $parent = $(this).parent();
                $(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();

                $parent.addClass("active");
                if(!!$(this).next('.sub-menus').size()){
                    if($parent.hasClass("open")){
                        $parent.removeClass("open").find('.sub-menus').hide();
                    }else{
                        $parent.addClass("open").find('.sub-menus').show();
                    }


                }
            });

            // 三级菜单点击
            $('.sub-menus li').click(function(e) {
                $(".sub-menus li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function(){
                var $ul = $(this).next('ul');
                $('dd').find('.menuson').slideUp();
                if($ul.is(':visible')){
                    $(this).next('.menuson').slideUp();
                }else{
                    $(this).next('.menuson').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#fff3e1;">
<div class="lefttop"><span></span>老师 你好</div>

<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="images/leftico01.png" /></span>查看信息
        </div>
        <ul class="menuson">
            <li class="active"><cite></cite><a href="teacher/me" target="rightFrame">我的信息</a><i></i></li>
            <li><cite></cite><a href="/student/teacher/exam" target="rightFrame">查看考试情况</a><i></i></li>
            <li><cite></cite><a href="/student/public/tips" target="rightFrame">公告信息</a><i></i></li>
            <li><cite></cite><a href="/student/public/password.jsp" target="rightFrame">用户中心</a><i></i></li>
            <li><cite></cite><a href="/student/public/error.html" target="rightFrame">自定义</a><i></i></li>
            <li><cite></cite><a href="/student/public/error.html" target="rightFrame">自定义</a><i></i></li>
            <li><cite></cite><a href="/student/public/error.html" target="rightFrame">自定义</a><i></i></li>
            <li><cite></cite><a href="/student/public/error.html" target="rightFrame">Tab页</a><i></i></li>
            <li><cite></cite><a href="/student/public/error.html" target="rightFrame">404页面</a><i></i></li>
        </ul>
    </dd>









</dl>

</body>
</html>

