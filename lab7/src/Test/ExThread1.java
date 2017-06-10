package Test;

/**
 * Created by DELL on 30.03.2017.
 */
public class ExThread1 extends Thread{
    @Override
    public void run() {

        try {

            if (isDaemon()){

                System.out.println("старт потока-демона");

                sleep(0); // заменить параметр на 1

            } else {

                System.out.println("старт обычного потока");

            }

        } catch (InterruptedException e) {

            System.err.print("Error" + e);

        } finally {

            if (!isDaemon())

                System.out.println(

                        "завершение обычного потока");

            else

                System.out.println(

                        "завершение потока-демона");

        }
        }
}
