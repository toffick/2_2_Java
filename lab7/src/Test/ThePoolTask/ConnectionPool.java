package Test.ThePoolTask;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by DELL on 01.04.2017.
 */
public class ConnectionPool <T> {
    private final static int POOL_SIZE = 3; // размер пула
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<T> resources = new LinkedList<T>();
    public ConnectionPool(Queue<T> source) {
        resources.addAll(source);
    }
    public T getResource(long maxWaitMillis) throws Exception {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                T res = resources.poll();
                return res;
            }
        } catch (InterruptedException e) {
            throw new Exception(e);
        }
        throw new Exception(":превышено время ожидания");
    }
    public void returnResource(T res) {
        resources.add(res); // возвращение экземпляра в пул
        semaphore.release();
    }
}