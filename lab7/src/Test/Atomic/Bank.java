package Test.Atomic;

public class Bank extends Thread {
    private Market market;
    private static final int PAUSE = 500;
    public Bank(Market market) {
        this.market = market;
    }
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println
                        ("Current index: " + market.getIndex());
                Thread.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}