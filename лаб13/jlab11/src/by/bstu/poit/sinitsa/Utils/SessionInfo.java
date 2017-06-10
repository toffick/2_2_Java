package by.bstu.poit.sinitsa.Utils;

import javafx.util.converter.DateStringConverter;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kleap on 20.05.2017.
 */
public class SessionInfo {
    public Date lastVisit;
    public int visitCounter;
    public String role;

    public SessionInfo(Date lastVisit, int visitCounter, String role) {
        this.lastVisit = lastVisit;
        this.visitCounter = visitCounter;
        this.role = role;
    }

    public SessionInfo(HttpSession session) {
        this.lastVisit = (Date) session.getAttribute("lastvisit");
        this.visitCounter = (Integer) session.getAttribute("counter");
        this.role = (String) session.getAttribute("role");
    }
}
