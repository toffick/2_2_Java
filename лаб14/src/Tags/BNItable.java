package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by DELL on 04.06.2017.
 */
public class BNItable extends TagSupport {
    public int doStartTag() throws JspException
    {
        JspWriter out = pageContext.getOut();
        try
        {
            out.print("<table width=\"100%\" border=\"2\" align=\"center\">" +
                    "<tr bgcolor=\"2F2CFF\">" +
                    "<th>Имя параметра</th><th>Значение</th>" +
                    "</tr>");
            Enumeration params = pageContext.getRequest().getParameterNames();
            while(params.hasMoreElements())
            {
                String paramName = (String)params.nextElement();
                out.print("<tr><td>" + paramName + "</td>");
                String paramValue = pageContext.getRequest().getParameter(paramName);
                out.println("<td> " + paramValue + "</td></tr>");
            }
        }
        catch (IOException e)
        {
            System.out.println("Tags.NBIsubmit: " + e);
        }
        return EVAL_BODY_INCLUDE;
    }
}
