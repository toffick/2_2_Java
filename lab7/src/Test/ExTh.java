package Test;

/**
 * Created by DELL on 30.03.2017.
 */
public class ExTh extends Thread {
    volatile static int i;
    boolean b;

    public void run() {
       // synchronized (Test.ExTh.class) {
            while (true) {
                if (b = !b) i++;
                else i--;
                System.out.println(i);

            }
     //   }
    }

    public static void main(String[] args) {
        ExTh h = new ExTh();
       ExTh ll =  new ExTh();


       h.start();
    ll.start();

    }
}