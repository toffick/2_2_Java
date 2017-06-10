package login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DELL on 24.05.2017.
 */

@WebServlet("/Login")
public class login extends HttpServlet {

    private Date date = null;
    private Integer count = 1;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(600);

        session.setAttribute("time", Calendar.getInstance().getTime());
        if (date != null)
            response.addCookie(new Cookie("time", date.toString()));
        date = Calendar.getInstance().getTime();
        response.addCookie(new Cookie("count", (count++).toString()));

        if((Calendar.getInstance().getTime().getHours() > 6) && (Calendar.getInstance().getTime().getHours() < 18)){
            session.setAttribute("hello", "Добрый день");
        }
        else {

            session.setAttribute("hello", "Добрый вечер");
        }

        response.sendRedirect("jsp/welcomeUser.jsp");
    }

}
