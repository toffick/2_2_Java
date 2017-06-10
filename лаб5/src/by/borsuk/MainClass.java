package by.borsuk;

import by.borsuk.AirManager.*;
import by.borsuk.Airplanes.AirCargo;
import by.borsuk.Airplanes.AirType;
import by.borsuk.Airplanes.Airplanes;
import by.borsuk.Airport.Airport;
import by.borsuk.JSON.JSONPars;
import by.borsuk.XML.XSLTransformer;

import by.borsuk.Serializable.Serializabl;

public class MainClass
{


    public static final String filepathXML =   new String("info/info.xml");

    public static final String filepathXMLDOM =   new String("info/infoDOM.xml");

    public static final String filepathXMLStAx =   new String("info/infoStAX.xml");

    public static final String xsdPath =   new String("info/valid.xsd");

    public static final String xsltPath =   new String("info/XSLT.xsl");

    public static final String htmlpath =  new String("info/htmldoc.html");

    public static final String serpath =  new String("info/srlzbl.txt");

    public static final String jsoninfopath =  new String("info/jsoninfo.json");


    public static void main(String[] args)
    {
        try {
            //генерация аиропортов: SAX, DOM, StAX
             AirManager airmanager = AirManager.getInstance();
             Airport xmlgeneratedairport = airmanager.generateAirportFromXMLSAX(xsdPath,filepathXML);
            System.out.println("Airport from xml with SAX ");
            System.out.println(xmlgeneratedairport);
             Airport xmlgeneratedomairport = airmanager.generateAirportFromXMLDOM(xsdPath,filepathXMLDOM);
            System.out.println("Airport from xml with DOM ");
            System.out.println(xmlgeneratedomairport);
             Airport xmlgeneratestaxdomairport = airmanager.generateAirportFromXMLStAX(xsdPath,filepathXMLStAx);
            System.out.println("Airport from xml with StAX ");
            System.out.println(xmlgeneratestaxdomairport);

            //преобразование XML в HTML
            XSLTransformer xslTransformer = new XSLTransformer();
            xslTransformer.XMLtoHTML(xsltPath,filepathXML,htmlpath);

            //сер/дисер
            Airplanes testser = new AirCargo(100,200,300,400, AirType.AN72);
            Serializabl serializabl = new Serializabl();
            serializabl.serialization(testser,serpath );
            testser = serializabl.deserialization(serpath);
            System.out.println("Airplane from serial. method");
            System.out.println(testser);

            //создание ссчитывание из JSON файла
            JSONPars jsonPars = new JSONPars();
            Airplanes testJSON = new AirCargo(999,8000,1506,6303, AirType.Boeing747);
            jsonPars.objtoJSON(testJSON,jsoninfopath);

            Airplanes airfromjson = jsonPars.JSONtoobj(jsoninfopath);
            System.out.println("Airplane from JSON");

            System.out.println(airfromjson);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
             e.printStackTrace();
        }
        finally
        {
            System.out.println("Program finalized");
        }


    }
}
