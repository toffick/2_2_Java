package Test.Atomic;

import java.util.concurrent.atomic.AtomicLong;
public class MarketDemo {
    private static final int NUMBER_BANKS = 5;

    public static void main(String[] args) {
        Market minskB = new Market(new AtomicLong(10));
        minskB.start();

        for (int i = 0; i < NUMBER_BANKS; i++) {
            new Bank(minskB).start();
        }
    }
}