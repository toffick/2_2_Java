package Test.Concurent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQu {
    public static void main(String[] args) {
        final BlockingQueue<String> queue =
                new ArrayBlockingQueue<String>(2);
        new Thread() {
            public void run() {
                for (int i = 1; i < 6; i++) {
                    try {

                        queue.put(" " + i); // добавление
                        System.out.println("Книгу " + i + " вернули");
                        System.out.println("Кнпгу" + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}