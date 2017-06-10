package by.borsuk.AirManager;
import by.borsuk.Airplanes.AirType;
import by.borsuk.Airplanes.Airplanes;
import by.borsuk.Airport.*;
import by.borsuk.XML.DOMPars;
import by.borsuk.XML.SAXPars;
import by.borsuk.XML.StAXPars;
import by.borsuk.XML.ValidatorSAX;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;


public class AirManager {



    private static AirManager ourInstance = new AirManager();

    public static AirManager getInstance() {
        System.out.println(" AirManager query");
        return ourInstance;
    }

    private AirManager()
    {
    }

    public int countCargoCapacity(Airport _airport)
    {
       return _airport.stat.countCargoCapacity();
    }
    public int countPassCapacity(Airport _airport)
    {
       return _airport.stat.countPassCapacity();
    }
    public Airplanes findFuelCostAir(Airport _airport, int val1, int val2) {
       return  _airport.stat.findFuelCostAir(val1,val2);
    }
    public void sortAirport(Airport _airport)
    {
        _airport.stat.sortByFlightRange();
        System.out.println("Sorting Airport");
    }


    public Airport generateAirportFromRandomValues(int aircount, int maxflightrange,
                                    int maxcapacity, int maxweight,
                                    int maxfuel) {

               Airport tempairport = new Airport();
               FactoryMethod[] create = new FactoryMethod[3];
               create[0] = new CreateAirCargo();
               create[1] = new CreateAirMilitary();
               create[2] = new CreateAirPassenger();

               Random random = new Random();

               Airplanes temp;

               for (int i = 0; i < aircount; i++) {
                   temp = create[random.nextInt(3)].CreateAirplane();
                   temp.set_flightrange(random.nextInt(maxflightrange));
                   temp.set_capacity(random.nextInt(maxcapacity));
                   temp.set_weight(random.nextInt(maxweight));
                   temp.set_fuelconsumption(random.nextInt(maxfuel));
                   temp.set_type(AirType.getRandomAirType());
                   tempairport.add(temp);
               }


// генерирует заданное количество самолетов определенного вида со
      //  случайными параметрами
        return tempairport;
    }

    public Airport generateAirportFromXMLSAX(String xsdPath, String filepath) throws
            ParserConfigurationException, IOException, org.xml.sax.SAXException {

            Airport tempairport=null;
        try {
            ValidatorSAX validator = new ValidatorSAX();
            if(validator.valid(xsdPath, filepath)) {
                tempairport  = new Airport();
                XMLReader reader = XMLReaderFactory.createXMLReader();
                SAXPars contentHandler = new SAXPars();
                reader.setContentHandler(contentHandler);
                reader.parse(filepath);
                tempairport.setAirlist(contentHandler.getAirport());
                return tempairport;
            }
        }
        catch(Exception e) {
            System.out.println("SAX parse error" + e.getMessage());
        }
        finally {
            return tempairport;
        }
    }


    public Airport generateAirportFromXMLStAX(String xsdPath, String filepath) throws
            ParserConfigurationException, IOException, org.xml.sax.SAXException {

        Airport tempairport=null;
        try {
            ValidatorSAX validator = new ValidatorSAX();
            if(validator.valid(xsdPath, filepath)) {
                tempairport = new Airport();
                StAXPars stAXPars = new StAXPars();
                stAXPars.parse(filepath);
                tempairport.setAirlist(stAXPars.getAirlist());
                return tempairport;
            }
        }
        catch(Exception e) {
            System.out.println("SAX parse error" + e.getMessage());
        }
        finally {
            return tempairport;
        }
    }


    public Airport generateAirportFromXMLDOM(String xsdPath, String filepath) throws
            ParserConfigurationException, IOException, org.xml.sax.SAXException {

        Airport tempairport=null;
        try {
            ValidatorSAX validator = new ValidatorSAX();
            if(validator.valid(xsdPath, filepath)) {
                tempairport  = new Airport();
                DOMPars dompars = new DOMPars();
                tempairport.setAirlist(dompars.DOMparse(filepath));
                return tempairport;
            }
        }
        catch(Exception e) {
            System.out.println("SAX parse error" + e.getMessage());
        }
        finally {
            return tempairport;
        }
    }


    
}

