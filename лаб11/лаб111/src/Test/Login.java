package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * Created by DELL on 21.05.2017.
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name  = request.getParameter("username");
        String pass = request.getParameter("password");
        if(name.equals("admin") && pass.equals("admin"))
        {
            String html = "Hello," + name+" "+ Calendar.getInstance().getTime().toString();
            PrintWriter printWriter = response.getWriter();
            printWriter.println(html);
            printWriter.close();
        }
        else
        {
            String html = "Please, check you input data!";
            PrintWriter printWriter = response.getWriter();
            printWriter.println(html);
            printWriter.close();
        }
    }
}
