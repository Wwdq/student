package Servlet;

import Pojo.User;
import ServiceIml.StudentService;
import ServiceIml.TeacherService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/public/updateQQ")
public class UpdateQQServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String QQ = req.getParameter("QQ");
        if(user.getUserid()==3){
            new StudentService().updateQQ(user,QQ);
            resp.getWriter().print("QQ修改成功,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/student/my");
        }
        if(user.getUserid()==2){
            new TeacherService().updateQQ(user,QQ);
            resp.getWriter().print("QQ修改成功,2秒后跳回");
            resp.setHeader("refresh","2;url=http://localhost:8080/student/teacher/me");
        }


    }
}
