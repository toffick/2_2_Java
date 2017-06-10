package login;

import DataBase.Query;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DELL on 24.05.2017.
 */
@WebServlet("/Registration")
public class registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        String log = request.getParameter("login");
        String pass = request.getParameter("password");
        Query.regUser(log, pass);

        response.sendRedirect("jsp/RegistrationComplete.jsp");

    }

}