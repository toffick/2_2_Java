package Task3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by DELL on 27.04.2017.
 */
public class SendMessage {
    private String host;
    private int port;
    public SendMessage(String host, int port)
    {
        this.host = host;
        this.port = port;
    }

    private void sendMessage(String msg)
    {
        DatagramSocket ds=null;
        try
        {
            byte[] data = msg.getBytes();
            InetAddress addr = InetAddress.getByName(host);
            DatagramPacket pack = new DatagramPacket(data,data.length,addr,port);
            ds = new DatagramSocket();
            ds.send(pack);

        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally {
            try {
                ds.close();
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        SendMessage sm = new SendMessage("localhost",6666);
        System.out.println("SENDER");
        Scanner scanner = new Scanner(System.in);
        String str;
        while(true){
            str=scanner.next().toLowerCase();
            sm.sendMessage(str);
            if(str.equals("exit"))
                break;
            System.out.println("Send "+ str);
        }
    }
}
