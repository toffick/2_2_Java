package by.borsuk.AirManager;

import by.borsuk.Airplanes.AirCargo;
import by.borsuk.Airplanes.Airplanes;

public class CreateAirCargo extends FactoryMethod {
    @Override
    public Airplanes CreateAirplane()
    {
        return new AirCargo();
    }
}
