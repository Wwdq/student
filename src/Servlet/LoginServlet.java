package Servlet;

import Pojo.User;
import ServiceIml.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        System.out.println("我被访问了");
        String password = req.getParameter("password");
        User user = new UserService().login(id, password);

        if(user==null){
            resp.getWriter().print("用户名或者密码错误,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/login.jsp");
        }
        else{
            HttpSession session=req.getSession();
            session.setAttribute("user", user);
            switch(user.getUserid()) {
                case 1:
                    req.getRequestDispatcher("admin-main.jsp").forward(req, resp);
                    return;
                case 2:
                    req.getRequestDispatcher("teacher-main.jsp").forward(req, resp);
                    return ;
                case 3:
                    req.getRequestDispatcher("student-main.jsp").forward(req, resp);


            }
        }

    }
}
