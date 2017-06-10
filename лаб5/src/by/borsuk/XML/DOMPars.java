package by.borsuk.XML;

import by.borsuk.AirManager.CreateAirCargo;
import by.borsuk.AirManager.CreateAirMilitary;
import by.borsuk.AirManager.CreateAirPassenger;
import by.borsuk.AirManager.FactoryMethod;
import by.borsuk.Airplanes.AirType;
import by.borsuk.Airplanes.Airplanes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by DELL on 09.03.2017.
 */
public class DOMPars {

    public ArrayList<Airplanes> DOMparse(String filepath)
    {
        ArrayList<Airplanes> airlist = new ArrayList<>();
        Airplanes tempair=null;
        try
        {
            FactoryMethod crCargo = new CreateAirCargo();
            FactoryMethod crMilitary = new CreateAirMilitary();
            FactoryMethod crPassenger = new CreateAirPassenger();

            File xmlFile = new File(filepath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("airplane");

            for(int tmp = 0; tmp < nodeList.getLength(); tmp++)
            {
                    Element element = (Element)nodeList.item(tmp);

                    switch(element.getAttribute("type"))
                    {
                        case "AirPassenger":
                            tempair = crPassenger.CreateAirplane();
                            break;
                        case "AirCargo":
                            tempair = crCargo.CreateAirplane();
                            break;
                        case "AirMilitary":
                            tempair = crMilitary.CreateAirplane();
                            break;
                    }

                    tempair.set_capacity(Integer.parseInt(element.getElementsByTagName("capacity")
                            .item(0)
                            .getTextContent()));
                    tempair.set_weight(Integer.parseInt(element.getElementsByTagName("weith")
                            .item(0)
                            .getTextContent()));
                    tempair.set_fuelconsumption(Integer.parseInt(element.getElementsByTagName("fuel")
                            .item(0)
                            .getTextContent()));
                    tempair.set_flightrange(Integer.parseInt(element.getElementsByTagName("rang")
                            .item(0)
                            .getTextContent()));

                    tempair.set_type(AirType.valueOf(element.getElementsByTagName("model")
                            .item(0)
                            .getTextContent()));

                    airlist.add(tempair);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
        finally
        {
            return airlist;
        }
    }
}
