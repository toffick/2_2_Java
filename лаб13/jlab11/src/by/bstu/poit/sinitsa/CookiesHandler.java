package by.bstu.poit.sinitsa;

import by.bstu.poit.sinitsa.Utils.SessionInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by kleap on 20.05.2017.
 */
public class CookiesHandler {

    public  static void updateSessionCookies(HttpServletResponse response,SessionInfo info){
        Cookie date = new Cookie("date",new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(info.lastVisit));

        int counter = ++info.visitCounter;
        Cookie count = new Cookie("count", String.valueOf(counter));
        Cookie role = new Cookie("role", info.role);

        response.addCookie(date);
        response.addCookie(count);
        response.addCookie(role);
    }
}
