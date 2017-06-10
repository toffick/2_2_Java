package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Enumeration;

/**
 * Created by DELL on 20.05.2017.
 */

@WebServlet("/Time")
public class TimeAndInf extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String html =
                "<html>" +
                        "<body>" +
                        "<b>TimeServlet</b><br>" +
                        "Current time: " + Instant.now() + "<br>" +
                        "Protocol: " + request.getProtocol() + "<br>" +
                        "Method: " + request.getMethod() + "<br>" +
                        "Client IP: " + request.getRemoteAddr() + "<br>" +
                        "Client hostname: " + request.getRemoteHost() + "<br>" +
                        "URL: " + request.getRequestURI() + "<br><br>" +
                        "--- Info about headers --- <br>";

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                html += headerName + ": " + request.getHeader(headerName) + "<br>";
            }
        }

        html += "</body></html>";

        PrintWriter printWriter = response.getWriter();
        printWriter.println(html);
        printWriter.close();
    }
}
