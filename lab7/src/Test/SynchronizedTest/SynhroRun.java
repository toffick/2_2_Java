package Test.SynchronizedTest;

import java.io.IOException;

/**
 * Created by DELL on 31.03.2017.
 */
public class SynhroRun {
    public static void main(String[ ] args) {
        ResourceObj s = null;
        long start = System.currentTimeMillis();
        try {
            s = new ResourceObj("synh.txt");
            SyncThread t1 = new SyncThread("Машина 1", s);
            SyncThread t2 = new SyncThread("Машина 2", s);
            SyncThread t3 = new SyncThread("Машина 3", s);
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        }
        catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        }
        catch (InterruptedException e) {
            System.err.print("ошибка потока: " + e);
        } finally {
            s.close();
            System.out.println(System.currentTimeMillis()-start);
        }
    }
}