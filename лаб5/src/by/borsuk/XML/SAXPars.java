package by.borsuk.XML;

import by.borsuk.AirManager.CreateAirCargo;
import by.borsuk.AirManager.CreateAirMilitary;
import by.borsuk.AirManager.CreateAirPassenger;
import by.borsuk.AirManager.FactoryMethod;
import by.borsuk.Airplanes.AirType;
import by.borsuk.Airplanes.Airplanes;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by ACER on 23.02.2017.
 */
public class SAXPars extends DefaultHandler {
    String thisElement = "";
    ArrayList<Airplanes> airlist;
    Airplanes tempair;

    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException,TypeNotPresentException  {

        FactoryMethod crCargo = new CreateAirCargo();
        FactoryMethod crMilitary = new CreateAirMilitary();
        FactoryMethod crPassenger = new CreateAirPassenger();

        thisElement = qName;
        switch(qName)
        {
            case "air":
                airlist = new ArrayList<>();
                break;
            case "airplane":
                switch (attributes.getValue(0))
                {
                    case "AirMilitary":
                        tempair = crMilitary.CreateAirplane();
                        break;
                    case "AirPassenger":
                        tempair = crPassenger.CreateAirplane();
                        break;
                    case "AirCargo":
                        tempair = crCargo.CreateAirplane();
                        break;
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        try {
            if(!thisElement.equals("air") && !thisElement.equals("airplane")) {
                String value = new String(ch, start, length);
                if (!value.contains("\n")) {
                    switch (thisElement) {
                        case "capacity":
                            tempair.set_capacity(Integer.parseInt(value));
                            break;
                        case "weith":
                            tempair.set_weight(Integer.parseInt(value));
                            break;
                        case "fuel":
                            tempair.set_fuelconsumption(Integer.parseInt(value));
                            break;
                        case "rang":
                            tempair.set_flightrange(Integer.parseInt(value));
                            break;
                        case "model":
                            tempair.set_type(AirType.valueOf(value));
                            break;
                        default:
                            return;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Tag element's value is bad "+ e.getMessage());
        }
    }

    @Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException
    {
        try {
            if (qName.equals("airplane")) {
                airlist.add(tempair);
                thisElement = "";
            } else return;
        }
        catch (Exception e)
        {
            System.out.println("XML end element exception"+e.getMessage());
        }
        //добавить самолет tempair в список если thisName равно типу самолета
    }

    public ArrayList<Airplanes> getAirport(){
            return airlist;
        }



}
