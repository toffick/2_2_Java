package by.borsuk.AirManager;


import by.borsuk.Airplanes.AirMilitary;
import by.borsuk.Airplanes.Airplanes;

public class CreateAirMilitary extends FactoryMethod {
    @Override
    public Airplanes CreateAirplane()
    {
        return new AirMilitary();
    }
}
