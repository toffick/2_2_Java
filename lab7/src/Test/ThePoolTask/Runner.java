package Test.ThePoolTask;

import java.util.LinkedList;

/**
 * Created by DELL on 01.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        LinkedList<Connect> list = new LinkedList<Connect>() {
            {
                this.add(new Connect(1));
                this.add(new Connect(2));
                this.add(new Connect(3));
            }
        };
        ConnectionPool<Connect> pool = new ConnectionPool<>(list);
        for (int i = 0; i < 10; i++) {
            new Client(pool).start();
        }
    }
}