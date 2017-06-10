package Task3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by DELL on 27.04.2017.
 */
public class TakeMessage {
    public static void main(String[] args) {
        String str;

        try
        {
            System.out.println("TAKER");
            boolean point = true;
            DatagramSocket ds = new DatagramSocket(6666);
            while(true && point) {
                DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
                try {
                    ds.receive(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                str = new String(dp.getData());

                if (str.contains("exit"))
                {
                    System.out.println("exit");
                    point = false;
                }
                else
                {
                    System.out.println("Take " + str);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
