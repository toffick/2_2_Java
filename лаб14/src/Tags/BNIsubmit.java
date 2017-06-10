package Tags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by DELL on 04.06.2017.
 */
public class BNIsubmit extends TagSupport {
    public int doStartTag()  throws JspException
    {
        String in = "<input type=\"submit\" value=\"OK\">"
            + "<input type=\"reset\" value=\"Cancel\"><br/>";

        JspWriter out = pageContext.getOut();

        try
        {
            out.print(in);
        }
        catch (IOException e) {
            System.out.println("Tags.BNIsubmit: " + e);

        }
        return EVAL_BODY_INCLUDE;

    }

}
