package Lab7.Task1;
import java.util.Random;


/**
 * Created by DELL on 01.04.2017.
 */
public class Car extends Thread
{
    public String carname;

    Parking parking;

    Random random = new Random();


    public Car(int _carname, Parking _park)
    {
        parking = _park;
        carname = String.valueOf(_carname);
        System.out.println("\u001B[33m"+"\n_____________________________\nCome car "+carname);
    }

    @Override
    public void run() {
        synchronized (parking)
        {
        if (parking.getFreeParkingPlace() == -1) {

            int waitingtime = random.nextInt(1000);

            System.out.println("\u001B[37m"+"Car " + getCarname() + "is waiting..."+waitingtime);
            try {
                parking.wait(waitingtime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
        if(parking.getFreeParkingPlace()!=-1) {

            parking.setCar(this);
            parking.showParking();

            try {
                Thread.sleep(random.nextInt(3000));
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            parking.leaveCar(this);
            synchronized (parking)
            {
                parking.notify();
            }
        }
        else
        {
            System.out.println("\u001B[31m"+"Car " + getCarname() + " left");
        }

    }

    public String getCarname()
    {
        return carname;
    }
}


