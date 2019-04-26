package Servlet;

import Pojo.User;
import ServiceIml.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/public/password")
public class PasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String password = req.getParameter("password");
        String s = new UserService().updatePassword(user, password);
        user.setPassword(s);
        req.getSession().setAttribute("user", user);
        resp.getWriter().print("新密码已经生效，请使用新密码登录 2秒后跳转登录页面");
        resp.setHeader("refresh","2;url=http://localhost:8080/student/login.jsp");

    }
}