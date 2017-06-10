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

@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        HttpSession ses = request.getSession();
        ses.setAttribute("get", "Вызов с первого сервлета через GET");
        request.getRequestDispatcher("/TwoServlet").forward(
                request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {
        HttpSession ses = request.getSession();
        ses.setAttribute("post", "Вызов с первого сервлета через post");
        request.getRequestDispatcher("/TwoServlet").forward(
                request, response);
    }

}
