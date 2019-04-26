package Servlet;

import Pojo.Teacher;
import Pojo.User;
import ServiceIml.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/teacher/me")
public class TeacherMeServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        Teacher teacher = new TeacherService().selectMe(user);
        req.setAttribute("teacher", teacher);
        req.getRequestDispatcher("me.jsp").forward(req, resp);
    }
}
