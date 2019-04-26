package Servlet;

import Pojo.Student;
import Pojo.User;
import ServiceIml.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/student/my")
public class MeServlet extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(session.getAttribute("user")==null){
            resp.getWriter().print("请点击右上角退出 重新登录");
            return ;
        }
        User user=(User)session.getAttribute("user");
        Student student = new StudentService().showMe(user);
        System.out.println(student);
        req.setAttribute("123", "123");
        req.setAttribute("student", student);
        req.getRequestDispatcher("/student/me.jsp").forward(req, resp);

    }
}
