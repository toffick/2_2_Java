package Forms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by DELL on 31.05.2017.
 */

@WebServlet("/AddInfoj")
public class AddInfo extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("Name");
        String lastName = req.getParameter("SecondName");
        String old = req.getParameter("yearold");
        String skin = req.getParameter("skincolor");


        req.getSession().setAttribute("aname", name);
        req.getSession().setAttribute("asecondname", lastName);
        req.getSession().setAttribute("Time",
                Calendar.getInstance().getTime().toString());
        req.getSession().setAttribute("aold", old);
        req.getSession().setAttribute("askin", skin);


        resp.sendRedirect("hellobabi.jsp");
    }
}
