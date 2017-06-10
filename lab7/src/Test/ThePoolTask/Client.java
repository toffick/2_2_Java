package Test.ThePoolTask;

/**
 * Created by DELL on 01.04.2017.
 */
class Client extends Thread {
    private boolean reading = false;
    private ConnectionPool<Connect> pool;
    public Client (ConnectionPool<Connect> pool) {
        this.pool = pool;
    }
    public void run() {
        Connect connect = null;
        try {
            connect = pool.getResource(500); // изменить на 100
            reading = true;
            System.out.println("Соединение Клиент #" + this.getId()
                    + " соединение #" + connect.getConnectID());
            connect.using();
        } catch (Exception e) {
            System.out.println("Клиент #" + this.getId() +
                    " отказано в соединении ->"
                    + e.getMessage());
        } finally {
            if (connect != null) {
                reading = false;
                System.out.println("Соединение Клиент #" + this.getId() + " : "
                        + connect.getConnectID() + " отсоединился");
                pool.returnResource(connect);
            }
        }
    }
    public boolean isReading() { return reading; }
}