package Test;

public class StringThred {
    public static int counter = 0;
    public static void main(String args[ ]) {
        final StringBuilder s = new StringBuilder();
        new Thread() {
            public void run() {
                synchronized (s) {
                    while (StringThred.counter++ < 6) {
                        s.append("B");
                        System.out.println(s);
                    }
                }
            }
        } .start();
        new Thread() {
            public void run() {
                synchronized (s) {
                    do {
                        s.append("A");
                        System.out.println(s);
                    } while (StringThred.counter++ < 2);
                }
            }
        }.start();

    }
}