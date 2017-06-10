package by.bstu.poit.sinitsa;

import by.bstu.poit.sinitsa.Utils.SessionInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by kleap on 18.05.2017.
 */
@WebServlet(name = "LoginServlet",
        urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private final String adminLogin = "admin";
    private final String adminPassword = "admin";

    /**
     * Get a diff between two dates
     *
     * @param date1    the oldest date
     * @param date2    the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("loginbox");
        String password = request.getParameter("passbox");
        HttpSession session = request.getSession(true);

        if (login.equals(adminLogin) && password.equals(adminPassword)) {
            String role = this.getServletContext().getInitParameter(login);

            loginUser(session, login, role);

            CookiesHandler.updateSessionCookies(
                    response, new SessionInfo(session));


            response.sendRedirect("/jlab11/main");

        } else {
            request.getRequestDispatcher("fail.jsp").
                    forward(request, response);
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean logout = Boolean.parseBoolean(request.getParameter("logout"));
        if (logout != null && logout) {
            logoutUser(session);

            request.getRequestDispatcher("index.jsp").
                    forward(request, response);
        } else {
            if (session.getAttribute("name") == null) {
                request.getRequestDispatcher("login.jsp").
                        forward(request, response);
            } else {
                response.sendRedirect("/jlab11/main");
            }
        }

    }

    private void logoutUser(HttpSession session) {
        session.removeAttribute("name");
        session.removeAttribute("role");
        session.setAttribute("worktime", getDateDiff((Date) session.getAttribute("lastvisit"), new Date(), TimeUnit.SECONDS));
        session.removeAttribute("lastvisit");
    }

    private void loginUser(HttpSession session, String name, String role) {
        session.setAttribute("role", role);
        session.setAttribute("name", name);
        session.setAttribute("lastvisit", new Date());
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            session.setAttribute("counter", 1);
        } else {
            counter++;
            session.setAttribute("counter", counter);
        }
    }
}
