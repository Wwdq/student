package Servlet;

import Pojo.Course;
import Pojo.Exam;
import Pojo.User;
import ServiceIml.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/exam")
public class examServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Course> courses= new TeacherService().selectExam(user);
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("exam.jsp").forward(req, resp);

    }
}
