package Servlet;

import ServiceIml.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/insert")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
        int nian = Integer.parseInt(req.getParameter("nian"));
        int ban = Integer.parseInt(req.getParameter("ban"));
        String name = req.getParameter("name");
        String QQ = req.getParameter("QQ");
        AdminService adminService=new AdminService();
        adminService.insertStudent(sno, nian, ban,name,QQ);
        resp.getWriter().print("增加成功,2秒后跳回");
        resp.setHeader("refresh","2;url=http://localhost:8080/student/admin/admin?admin=student");



    }
}
