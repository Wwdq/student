package Servlet;

import ServiceIml.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete")
public class AdminDeleteServlet extends HttpServlet {
    AdminService  adminService;

    {
        try {
            adminService = new AdminService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delete = req.getParameter("delete");
        switch (delete){
            case "student":
                deleteStudent(req, resp);
                break;
            case "teacher":
                deleteTeacher(req,resp);
                  break;
            case "tip":
                deleteTip(req, resp);
                break;
            case "exam":
                deleteExam(req, resp);
                break;
        }
    }

    private void deleteExam(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void deleteTip(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int key = adminService.deleteTipService(id);
        if(key>0){
            resp.getWriter().print("删除成功,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/admin/admin?admin=tip");

        }
        else{
            resp.getWriter().print("删除失败,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/admin/admin?admin=tip");
        }

    }

    private void deleteTeacher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tno = req.getParameter("tno");
        int key = adminService.deleteTeacherService(tno);
        if(key>0){
            resp.getWriter().print("删除成功,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/admin/adminTeacher.jsp");

        }
        else{
            resp.getWriter().print("删除失败,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/admin/adminTeacher.jsp");
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sno = req.getParameter("sno");
        int key = adminService.deleteStudentService(sno);
        if(key>0){
            resp.getWriter().print("删除成功,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/admin/adminStudent.jsp");

        }
        else{
            resp.getWriter().print("删除失败,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/admin/adminStudent.jsp");
        }


    }
}
