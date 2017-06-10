package secondtask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by DELL on 25.05.2017.
 */
@WebServlet("/TwoServlet")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("task_2/SecondServletPage.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {
            HttpSession session = request.getSession();
            session.setAttribute("get","Переопределение с сервлета TwoServlet post");
            response.sendRedirect("task_2/SecondServletPage.jsp");
    }

}