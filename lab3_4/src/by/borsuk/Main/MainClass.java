package by.borsuk.Main;

import by.borsuk.AirManager.*;
import by.borsuk.Airplanes.*;
import by.borsuk.Airport.Airport;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class MainClass
{

    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

    public static final Logger log = Logger.getLogger(MainClass.class.getName());

    public static final String filepathXML =   new String("info\\info.xml");

    public static void main(String[] args)
    {
        try {

            FactoryMethod crCargo = new CreateAirCargo();
            FactoryMethod crMilitary = new CreateAirMilitary();
            FactoryMethod crPassenger = new CreateAirPassenger();


             AirManager airmanager = AirManager.getInstance();
             Airport randomgeneratedairport = airmanager.generateAirportFromRandomValues(3, 1000,
            500, 600, 700);
             log.trace(randomgeneratedairport);
            airmanager.sortAirport(randomgeneratedairport);
            log.trace(randomgeneratedairport);
            Airplanes findair = airmanager.findFuelCostAir(randomgeneratedairport, 100, 300);
            log.trace(findair);
            log.trace(airmanager.countCargoCapacity(randomgeneratedairport));
            log.trace(airmanager.countPassCapacity(randomgeneratedairport));



            Airport xmlgeneratedairport = airmanager.generateAirportFromXML(filepathXML);
            xmlgeneratedairport.add(crCargo.CreateAirplane());
            log.trace(xmlgeneratedairport);


        }
        catch (Exception e)
        {
             log.error(e.getMessage());
        }
        finally
        {
            log.info("Program finalized");
        }


    }
}
