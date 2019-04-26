package Servlet;

import Pojo.Exam;
import Pojo.Score;
import ServiceIml.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacher/sure")
public class ScoreSureServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[]  strings=req.getParameterValues("score");
        System.out.println(strings.length);
        Exam exam = (Exam) req.getSession().getAttribute("exam");
        List<Score> scores=exam.getScores();
         for(int i=0;i<strings.length;i++){
             if(strings[i].length()!=0){
                 scores.get(i).setSc(Integer.parseInt(strings[i]));
             }
         }
        new TeacherService().insertScore(scores);
         exam.setScores(scores);
        req.getSession().setAttribute("exam", exam);
        resp.getWriter().print("分数修改成功 2秒钟后跳转到打分页面");
        resp.setHeader("refresh","2;url=http://localhost:8080/student/teacher/score?id="+exam.getEno());
    }
}
