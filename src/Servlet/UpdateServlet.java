package Servlet;

import ServiceIml.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
       int nian = Integer.parseInt(req.getParameter("nian"));
       int ban = Integer.parseInt(req.getParameter("ban"));
        AdminService adminService=new AdminService();
        adminService.updateStudent(sno, nian, ban);
        resp.getWriter().print("修改成功,2秒后跳回");
        resp.setHeader("refresh","2;url=http://localhost:8080/student/admin/admin?admin=student");



    }
}
