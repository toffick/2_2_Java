package by.borsuk.Airplanes;



public class AirCargo extends Airplanes {

    public AirCargo()
    {
        _airtype = AirType.None;
        _capacity = 0;
        _flightrange = 0;
        _fuelconsumption = 0;
        _weight = 0;
    }

    public AirCargo(int capacity, int flightrange, int fuelconsumption, int weight, AirType airtype)
    {

        _airtype = airtype;
        _capacity = capacity;
        _flightrange = flightrange;
        _fuelconsumption = fuelconsumption;
        _weight = weight;
    }

    @Override
    public Airplanes CreateAirplane()
    {
        return new AirCargo();
    }


    @Override
    public String toString()
    {
        return String.format("\tAirCargo: capacity = %d, flightrange = %d, " +
                        "fuelconsumption = %d, weight = %d, type = %s",
                _capacity,_flightrange, _fuelconsumption,_weight,_airtype.name());
    }

    @Override
    public int hashCode() {
        return (int)((Math.cos(_capacity+_weight)*Math.exp(_flightrange)/
                _fuelconsumption)+777*_weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AirCargo other = (AirCargo) obj;
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

    public String getClassName()
    {
        return "AirCargo";
    }


    public AirType getAirtType()
    {
        return _airtype;
    }
    public int getFuelConsumption(){ return _fuelconsumption;}

    public int getFlightRange(){ return _flightrange;}


}
