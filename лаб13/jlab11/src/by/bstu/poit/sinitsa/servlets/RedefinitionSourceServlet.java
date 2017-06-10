package by.bstu.poit.sinitsa.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kleap on 20.05.2017.
 */
@WebServlet(name = "RedefinitionSourceServlet",
urlPatterns = {"/redefinitionsource"})
public class RedefinitionSourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(request.getParameter("second"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("first") != null){
            response.getWriter().write(request.getParameter("first"));

        }
        else if(request.getParameter("third") != null){
            request.setAttribute("third", request.getParameter("third"));
            request.getRequestDispatcher("redefinitionsource.jsp").
                    forward(request, response);
        }
        else if(request.getParameter("five") != null){
            PrintWriter writer=response.getWriter();
            writer.append("response from servlet, request parameter : "+ request.getParameter("five"));
        }
        //when redirect
        else {
            request.setAttribute("fourth", request.getParameter("fourth"));
            request.getRequestDispatcher("redefinitionsource.jsp").
                    forward(request, response);
        }
    }
}
