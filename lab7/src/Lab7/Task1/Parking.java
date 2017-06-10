package Lab7.Task1;

import java.sql.Time;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by DELL on 01.04.2017.
 */
public class Parking {
    private Car[] parking;
    private int parkingsize;

    public Parking(){};
    public Parking(int size)
    {
        parkingsize = size;
        parking = new Car[size];
    }

    public int getFreeParkingPlace()
    {
        for (int i = 0; i < parkingsize; i++) {
            if(parking[i]==null)
                return i;
        }
        return -1;
    }

    public synchronized  void setCar(Car car)
    {
        System.out.println("\u001B[35m"+"Car "+car.getCarname()+"is parked!!!");
        parking[getFreeParkingPlace()] = car;
    }

    public synchronized void leaveCar(Car car)
    {
        for (int i = 0; i < parkingsize; i++)
        {
            if (parking[i] == car) {
                parking[i] = null;
                System.out.println("\u001B[36m" + "Leave car " + car.getCarname());
            }
        }
    }

    public void showParking()
    {
        System.out.print("\u001B[38m \t{ ");
        for (int i = 0; i < parkingsize; i++) {
            if(parking[i]!=null)
            {
                System.out.print("\u001B[84m "+parking[i].getCarname()+" ");
            }
            else
                {
                System.out.print("\u001B[84m - ");
            }

        }
        System.out.println("\u001B[38m } ");

    }

}
