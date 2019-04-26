package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
//进行session管理
public class SessionFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
       HttpSession session= ((HttpServletRequest)(req)).getSession();
        String path = ((HttpServletRequest)(req)).getRequestURI();
        if(path.contains("login")||path.contains("images"))
            chain.doFilter(req, resp);

        else {

            if (session.getAttribute("user") == null)
                ((HttpServletResponse) (resp)).sendRedirect("/student/login.jsp");
            else
                chain.doFilter(req, resp);
        }
    }
}
