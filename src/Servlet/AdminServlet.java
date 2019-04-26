package Servlet;

import Pojo.Exam;
import Pojo.Student;
import Pojo.Teacher;
import Pojo.Tip;
import ServiceIml.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/admin")
public class AdminServlet extends HttpServlet {
    AdminService adminService=new AdminService();

    public AdminServlet() throws IOException {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key=req.getParameter("admin");
        switch (key){
            case "teacher":
                adminTeacher(req, resp);
                break;
            case "student":
                adminStudent(req, resp);
                break;
            case "tip":
                adminTip(req, resp);
                break;
            case "exam":
                adminExam(req, resp);
                break;
        }
    }

    private void adminExam(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Exam> exams = adminService.selectExam();
        req.setAttribute("exams", exams);
        req.getRequestDispatcher("adminExam.jsp").forward(req, resp);

    }

    private void adminTip(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tip> tips = adminService.selectTip();
        req.setAttribute("tip", tips);
        req.getRequestDispatcher("adminTip.jsp").forward(req, resp);

    }

    private void adminStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = adminService.selectStudent();
        req.getSession().setAttribute("students", students);
        req.getRequestDispatcher("adminStudent.jsp").forward(req, resp);


    }

    public void adminTeacher(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Teacher> teachers = adminService.selectTeacher();
        req.getSession().setAttribute("teachers", teachers);
        req.getRequestDispatcher("adminTeacher.jsp").forward(req, resp);

    }
}
