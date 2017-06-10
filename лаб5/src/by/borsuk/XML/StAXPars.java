package by.borsuk.XML;

import by.borsuk.AirManager.CreateAirCargo;
import by.borsuk.AirManager.CreateAirMilitary;
import by.borsuk.AirManager.CreateAirPassenger;
import by.borsuk.AirManager.FactoryMethod;
import by.borsuk.Airplanes.AirType;
import by.borsuk.Airplanes.Airplanes;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by DELL on 13.03.2017.
 */
public class StAXPars {

    private XMLInputFactory inputFactory;
    private ArrayList<Airplanes> airlist;
    private Airplanes tempair = null;

    public StAXPars()
    {
        airlist = new ArrayList<Airplanes>();
        inputFactory = XMLInputFactory.newInstance();
    }

    public ArrayList<Airplanes> getAirlist()
    {
        return airlist;
    }

    private Airplanes getAir(XMLStreamReader reader) throws XMLStreamException {
        FactoryMethod crCargo = new CreateAirCargo();
        FactoryMethod crMilitary = new CreateAirMilitary();
        FactoryMethod crPassenger = new CreateAirPassenger();
        String name="";
        int  event = reader.getEventType();

        String attributename = reader.getAttributeValue(0);

        if(attributename.equals("AirPassenger"))
            tempair = crPassenger.CreateAirplane();
        if(attributename.equals("AirCargo"))
            tempair = crCargo.CreateAirplane();
        if(attributename.equals("AirMilitary"))
            tempair = crMilitary.CreateAirplane();


        while(true)
        {
            event =  reader.next();

            switch(event)
            {
                case XMLStreamConstants.START_ELEMENT:
                {
                    processStartElement(reader);
                    break;
                }
                case XMLStreamConstants.END_ELEMENT:
                {
                   if(reader.getLocalName().equals("airplane"))
                       return tempair;
                }
                default:
                    break;

            }
        }


        ///////////////////////////////////////////////////////////



        //return tempair;

    }

    private void processStartElement(XMLStreamReader reader) throws XMLStreamException {
        String name = reader.getLocalName();
        String value  = reader.getElementText();

        if(name.equals("capacity"))
        {
            tempair.set_capacity(Integer.parseInt(value));
        }
        if(name.equals("weith"))
        {
            tempair.set_weight(Integer.parseInt(value));
        }
        if(name.equals("fuel"))
        {
            tempair.set_fuelconsumption(Integer.parseInt(value));
        }
        if(name.equals("rang"))
        {
            tempair.set_flightrange(Integer.parseInt(value));
        }
        if(name.equals("model"))
        {
            tempair.set_type(AirType.valueOf(value));
        }
    }

    public void parse(String filepath)
    {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        Airplanes tempair=null;
        String name;
        try
        {
            inputStream = new FileInputStream(new File(filepath));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while(reader.hasNext())
            {
                int type = reader.next();

                if(type == XMLStreamConstants.START_ELEMENT)
                {
                    name = reader.getLocalName();
                    if(name.equals("airplane"))
                    {
                        tempair = getAir(reader);
                        airlist.add(tempair);
                    }
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("StAX parse error: "+e.getMessage());
        }
        catch(XMLStreamException e)
        {
            System.out.println("StAX parse error: "+e.getMessage());

        }
    }
}


