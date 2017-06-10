package by.borsuk.AirManager;

import by.borsuk.Airplanes.AirType;
import by.borsuk.Airplanes.Airplanes;
import by.borsuk.Airport.Airport;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by ACER on 23.02.2017.
 */
public class SAXPars extends DefaultHandler {
    String thisElement = "";
    ArrayList<Airplanes> airlist = new ArrayList<>();
    Airplanes tempair;
    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException,TypeNotPresentException  {

        FactoryMethod crCargo = new CreateAirCargo();
        FactoryMethod crMilitary = new CreateAirMilitary();
        FactoryMethod crPassenger = new CreateAirPassenger();

        switch(qName)
        {
            case "AirCargo":
                tempair = crCargo.CreateAirplane();
                break;
            case "AirMilitary":
                tempair = crMilitary.CreateAirplane();
                break;
            case "AirPassenger":
                tempair = crPassenger.CreateAirplane();
                break;
            default:
                return;
        }

        int attcount = attributes.getLength();
        for (int i = 0; i < attcount; i++)
        {
            String attrval =  attributes.getQName(i);
            switch(attrval)
            {
                case "capacity":
                    tempair.set_capacity(Integer.parseInt(attributes.getValue(i)));
                    break;
                case "weith":
                    tempair.set_weight(Integer.parseInt(attributes.getValue(i)));
                    break;
                case "fuel":
                    tempair.set_fuelconsumption(Integer.parseInt(attributes.getValue(i)));
                    break;
                case "rang":
                    tempair.set_flightrange(Integer.parseInt(attributes.getValue(i)));
                    break;
                case "type":
                    tempair.set_type(AirType.valueOf(attributes.getValue(i)));
                    break;
                default:
                    break;
            }
        }
        airlist.add(tempair);

    }
    public ArrayList<Airplanes> getAirport(){
            return airlist;
        }

    @Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException
    {
        thisElement = "";
    }
}
