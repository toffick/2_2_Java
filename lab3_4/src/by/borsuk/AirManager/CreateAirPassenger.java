package by.borsuk.AirManager;

import by.borsuk.Airplanes.AirPassenger;
import by.borsuk.Airplanes.Airplanes;

public class CreateAirPassenger extends FactoryMethod {
    @Override
    public Airplanes CreateAirplane()
    {
        return new AirPassenger();
    }
}
