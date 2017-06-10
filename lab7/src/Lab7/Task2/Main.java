package Lab7.Task2;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by DELL on 06.04.2017.
 */
public class Main {

    public static final int OPERATORSCOUNT = 3;
    public static final int CLIENTCOUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Semaphore sem = new Semaphore(OPERATORSCOUNT,true);
        CallCenter callCenter = new CallCenter(OPERATORSCOUNT);

        for (int i = 0; i < CLIENTCOUNT; i++) {
                new Client(callCenter,sem,i).start();
                Thread.sleep(random.nextInt(300)+300);
        }

    }
}
