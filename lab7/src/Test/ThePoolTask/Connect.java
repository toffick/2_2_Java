package Test.ThePoolTask;

import java.util.Random;

/**
 * Created by DELL on 01.04.2017.
 */
class Connect {
    private int connectID;
    public Connect(int id) {
        super();
        this.connectID = id;
    }
    public int getConnectID() {
        return connectID;
    }
    public void setConnectID(int id) {
        this.connectID = id;
    }
    public void using() {
        try {
// использование соединения
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}