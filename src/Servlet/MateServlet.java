package Servlet;

import Pojo.Student;
import Pojo.User;
import ServiceIml.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/mate")
public class MateServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Student> list = new StudentService().showMate(user);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/student/mate.jsp").forward(req, resp);


    }
}
