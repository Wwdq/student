package Servlet;

import Pojo.Tip;
import ServiceIml.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/public/tips")
public class TipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tip> tip = new ArrayList<>();
        tip=new UserService().watchTip();
        req.setAttribute("tip", tip);
        req.getRequestDispatcher("/public/tips.jsp").forward(req, resp);

    }
}
