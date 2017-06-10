package Lab7.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by DELL on 01.04.2017.
 */
public class Main {

    public static final int CARCOUNT = 20;
    public static final int PARKINGPLACECOUNT = 5;


    public static void main(String[] args) {

        Parking parking = new Parking(PARKINGPLACECOUNT);
        Random random = new Random();

        for(int i = 0;i<CARCOUNT;i++)
        {
            (new Car(i+10,parking)).start();
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
