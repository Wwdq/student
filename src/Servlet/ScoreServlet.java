package Servlet;

import Pojo.Exam;
import ServiceIml.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/score")
public class ScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int eno = Integer.parseInt(req.getParameter("id"));
        Exam exam = new TeacherService().scoreExam(eno);
        req.getSession().setAttribute("exam", exam);
        req.getRequestDispatcher("score.jsp").forward(req, resp);

    }
}
