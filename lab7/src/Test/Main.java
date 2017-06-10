package Test; /**
 * Created by DELL on 29.03.2017.
 */

public class Main {


    public static void main(String[] args) throws InterruptedException {
//       MySingleton ms = MySingleton.getInstance("Null");


       ExThread1 usual = new ExThread1();

        ExThread1 daemon = new ExThread1();

        daemon.setDaemon(true);

        daemon.start();

        usual.start();

        usual.join();

        daemon.join();

        System.out.println(

                "последний оператор main");
    }
}


