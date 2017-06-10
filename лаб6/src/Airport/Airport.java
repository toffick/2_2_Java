package Airport;

import Airplanes.*;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Airport implements Serializable {

    private ArrayList<Airplanes> airlist;
    public Statistic stat;

    public Airport()
    {
        airlist = new ArrayList<Airplanes>();
        stat = new Statistic();
    }
    public Airport(ArrayList<Airplanes> _airlist)
    {
        airlist = _airlist;
        stat = new Statistic();
    }

    public ArrayList<Airplanes> getAirlist()
    {
        return airlist;
    }
    public void setAirlist(ArrayList<Airplanes> _airlist)
    {
        airlist = _airlist;
    }


/**Внутренний класс*/
    public class Statistic
    {
        /**
         * @return возвращает общую вместимость пассажирских самолетов*/
        public int countPassCapacity() {
            int val=0;
            for(Airplanes k : airlist)
            {
                if(k.getClass()== AirPassenger.class)
                {
                    val+=k.getCapacity();
                }
            }
            return val;
        }
        /**
         * @return возвращает общую вместимость грузовых самолетов*/
        public int countCargoCapacity() {
            int val=0;
            for(Airplanes k : airlist)
            {
                if(k.getClass()== AirCargo.class)
                {
                    val+=k.getCapacity();
                }
            }
            return val;
        }

        public void sortByFlightRange()
        {
            Collections.sort(airlist, (Airplanes o1, Airplanes o2) ->
                Integer.compare(o1.getFlightRange(), o2.getFlightRange()));
        }


        public Airplanes findFuelCostAir(int valmin, int valmax)
        {
            for(Airplanes air: airlist)
            {
                if(air.getFuelConsumption()>=valmin && air.getFuelConsumption()<=valmax )
                    return air;
            }
            return null;
        }
    }

    //методы контейнера
    @Override
    public String toString() {
        String tmp="";
        for(Airplanes _tair : airlist)
        {
            tmp+="\n"+_tair;
        }
        return tmp;
    }
    public boolean add(Airplanes item)
    {
      return   airlist.add(item);
    }
    public Airplanes remove(int index)
    {
       return airlist.remove(index);
    }
    public boolean clean()
    {
       return airlist.removeAll(airlist);
    }
    public int getsize()
    {
        return airlist.size();
    }
    public int sum(int a, int b){return a+b;}
}

