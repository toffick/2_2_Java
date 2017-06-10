package by.borsuk.Airplanes;


/**
 * Created by ACER on 12.02.2017.
 */
public class AirMilitary extends Airplanes {


    public AirMilitary()
    {
        _airtype = AirType.None;
        _capacity = 0;
        _flightrange = 0;
        _fuelconsumption = 0;
        _weight = 0;
        log.info("AirMilitary was created");

    }
    public AirMilitary(int capacity, int flightrange,
                       int fuelconsumption, int weight, AirType airtype)
    {
        _airtype = airtype;
        _capacity = capacity;
        _flightrange = flightrange;
        _fuelconsumption = fuelconsumption;
        _weight = weight;
        log.info("AirMilitary was created");

    }


    @Override
    public Airplanes CreateAirplane()
    {
        return new AirMilitary();
    }

    @Override
    public String toString() {
        return String.format("\tAirMilitary:  capacity = %d, flightrange = %d, fuelconsumption" +
                " = %d, weight = %d, type = %s",
                _capacity,_flightrange, _fuelconsumption,_weight,_airtype.name());
    }

    @Override
    public int hashCode() {
        return (int)((Math.cos( _weight)*Math.exp(_flightrange)/
                _fuelconsumption)+444*_capacity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AirMilitary other = (AirMilitary) obj;
         if ( hashCode()!= other.hashCode())
             return false;
         else return true;
    }


    public int getCapacity() {
        return _capacity;
    }

    public int getWeight() {
        return _weight;
    }


    public int getFuelConsumption(){ return _fuelconsumption;}

    public int getFlightRange(){ return _flightrange;}
}
