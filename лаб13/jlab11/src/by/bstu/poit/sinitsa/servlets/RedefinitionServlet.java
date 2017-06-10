package by.bstu.poit.sinitsa.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kleap on 20.05.2017.
 */
@WebServlet(name = "RedefinitionServlet",
urlPatterns = {"/redefinition"})
public class RedefinitionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/redefinitionsource").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("first") != null )
        {
            request.getRequestDispatcher("/redefinitionsource").forward(request,response);
        }
        else if(request.getParameter("third")!= null){
            request.getRequestDispatcher("/redefinitionsource").forward(request,response);
        }
        else if(request.getParameter("fourth" ) != null){
            response.sendRedirect(this.getServletContext().getContextPath() + "/redefinitionsource");
        }
        else if(request.getParameter("five") != null){

            String responseString = sendRequestToServlet(
                    "http://localhost:8080/jlab11/redefinitionsource",
                    "five="+request.getParameter("five"));
            request.setAttribute("response",responseString);
            request.getRequestDispatcher("redefinition.jsp").forward(request,response);
        }
    }
    private String sendRequestToServlet(String servletUrl,String parm) throws IOException {
        URL url = new URL( servletUrl+"?"+parm);

        BufferedReader responseStream = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String inputLine;
        StringBuffer responseString = new StringBuffer();

        while ((inputLine = responseStream.readLine()) != null) {
            responseString.append(inputLine);
        }
        responseStream.close();
        return responseString.toString();
    }
}
