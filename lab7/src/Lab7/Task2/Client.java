package Lab7.Task2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by DELL on 06.04.2017.
 */
public class Client extends  Thread{
    private Semaphore sem;
    private String name;
    private CallCenter callCenter;
    Random random = new Random();



    public Client(){};
    public Client(CallCenter _callcenter,
                  Semaphore _sem,
                  int _name)
    {
        sem = _sem;
        callCenter=_callcenter;
        name = "С#"+_name;
    }

    @Override
    public void run()
    {
        int waittime = random.nextInt(600)+100;
        System.out.println("\u001B[35m_________________________________");
        System.out.println("\u001B[34m"+getNameClient()+" calling [WT: "+waittime+"]");
        try {

            callCenter.showParking();
            if(sem.tryAcquire(waittime, TimeUnit.MILLISECONDS))
            {

                System.out.println("\u001B[32m"+" consultation "+ getNameClient());
                callCenter.connect(this);
                Thread.sleep(random.nextInt(3000)+500);
                callCenter.disconnect(this);
                sem.release();
            }
            else
            {
                System.out.println("\u001B[31m"+getNameClient()+" left");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public String getNameClient()
    {
        return name;
    }

}
