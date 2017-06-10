package Test;

/**
 * Created by DELL on 29.03.2017.
 */
public class ExThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(
                        "Thread1"
                );
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
