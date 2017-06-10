package by.borsuk.XML;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.io.File;
import java.io.IOException;


/**
 * Created by DELL on 07.03.2017.
 */
public class ValidatorSAX
{

    public boolean valid(String xsdschema, String xmlfile) throws SAXException {
        Source xsdname = new StreamSource(xsdschema);
        Source xmlFile = new StreamSource(new File(xmlfile));
        boolean isValid = false;
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try
        {
            Schema schema = schemaFactory.newSchema(xsdname);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlfile + " is valid ");
            isValid = true;
        }
        catch(SAXException e)
        {
            System.out.println(xmlfile + " is not valid. Message: " + e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(xmlfile + " IO error " + e.getMessage());
        }
        finally {
            return isValid;
        }
    }

}
