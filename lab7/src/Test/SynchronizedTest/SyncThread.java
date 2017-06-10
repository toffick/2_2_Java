package Test.SynchronizedTest;

class SyncThread extends Thread {
    private ResourceObj logistCenter;
    public SyncThread(String name, ResourceObj rs) {
        super(name);
        this.logistCenter = rs;
    }
    public void run() {
        for (int i = 1; i < 6; i++) {

            logistCenter.dumping(getName(), i);
// место срабатывания синхронизации
        }
    }
}