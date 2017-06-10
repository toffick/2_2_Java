package by.borsuk.XML;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by DELL on 14.03.2017.
 */
public class XSLTransformer {

    public void XMLtoHTML(String XSLTpath,
                          String XMLpath, String HTMLpath)
    {
        try
        {
            TransformerFactory xstf = TransformerFactory.newInstance();
            Transformer transformer =  xstf.newTransformer(new StreamSource(XSLTpath));
            transformer.transform(new StreamSource(XMLpath),
                    new StreamResult(HTMLpath));
        }
        catch(Exception e)
        {
            System.out.println("XSLTTransformer error: "+e.getMessage());
        }
    }
}
