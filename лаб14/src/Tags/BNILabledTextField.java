package Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by DELL on 04.06.2017.
 */
public class BNILabledTextField extends TagSupport{

    public String value = "";
    public String label = "";
    public String name = "";

    public void setLabel(String label) {
        this.label = label;
    }

    public void setName(String name) {this.name = name;}

    public void setValue(String value) {
        this.value = value;
    }


    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

@Override
    public int doStartTag() throws JspException
    {
        JspWriter out = pageContext.getOut();
        try
        {
            out.print("<label width=100>" + label + "</label>"
                    + "<input name =\"" + name + "\" type = \"text\" width = \"150\""
                    + " maxlength= \"30\" value =\""+this.value+"\" />");
        }
        catch (IOException e)
        {
            System.out.println("myTag.GISLabledTextField: " + e);
        }
        return SKIP_BODY;
    }
}
