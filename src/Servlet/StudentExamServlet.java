package Servlet;

import Pojo.Exam;
import Pojo.Score;
import Pojo.User;
import ServiceIml.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/exam")
public class StudentExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Score> scores = new StudentService().selectScore(user);
        req.setAttribute("score",scores );
        req.getRequestDispatcher("/student/exam.jsp").forward(req, resp);

    }
}
