package Filters;

import DataBase.DataBaseConnection;
import DataBase.Query;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DELL on 24.05.2017.
 */
@WebFilter(urlPatterns = {"/Login"})
public class FilterReg implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String log = req.getParameter("login");
        String pass = req.getParameter("password");
        String usertype = Query.getUserType(log, pass);

        HttpServletResponse httpResponse = (HttpServletResponse)resp;

        if(usertype.equals("Null"))
            httpResponse.sendRedirect("jsp/registration.jsp");
        else
        {
            httpResponse.addCookie(new Cookie("type", usertype));
            chain.doFilter(req, resp);}
        }

    public void init(FilterConfig config) throws ServletException {

    }

}
