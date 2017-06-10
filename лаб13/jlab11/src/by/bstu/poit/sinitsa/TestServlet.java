package by.bstu.poit.sinitsa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kleap on 17.05.2017.
 */
@WebServlet(name = "TestServlet",
        urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        request.setAttribute("date", dateFormat.format(date));
        request.setAttribute("protocol", request.getProtocol());
        request.setAttribute("ip", request.getLocalAddr());
        request.setAttribute("name", request.getLocalName());
        request.setAttribute("method", request.getMethod());
        request.setAttribute("url", request.getRequestURL());
        request.setAttribute("headers",this.GetHeadersString(request));
        request.getRequestDispatcher("test.jsp").
                forward(request, response);
    }

    private String GetHeadersString(HttpServletRequest request) {
        String headers = "";

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headers += key +" : "+ value +"    "+ System.lineSeparator();
        }
        return headers;
    }
}
