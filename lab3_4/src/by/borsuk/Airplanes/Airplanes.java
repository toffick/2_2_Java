package by.borsuk.Airplanes;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

abstract public class Airplanes implements Interface
{




    protected static final Logger log = Logger.getLogger(Airplanes.class.getName());

    protected int _capacity, _weight, _fuelconsumption,_flightrange;
    AirType _airtype;

    public abstract  Airplanes CreateAirplane();

    public void set_type(AirType type){this._airtype = type;}

    public void set_capacity(int _capacity) {
        this._capacity = _capacity;
    }

    public void set_weight(int _weight) {
        this._weight = _weight;
    }

    public void set_fuelconsumption(int _fuelconsumption) {
        this._fuelconsumption = _fuelconsumption;
    }

    public void set_flightrange(int _flightrange) {
        this._flightrange = _flightrange;
    }
}
