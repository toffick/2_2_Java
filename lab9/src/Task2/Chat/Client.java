package Task2.Chat;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by DELL on 27.04.2017.
 */
public class Client {

    Socket socket;

    BufferedReader in;
    PrintWriter out;

    public Client() throws IOException {
        Scanner scan = new Scanner(System.in);
        socket = new Socket("localhost", 6688);
        createBridge();

        System.out.println("Ник?");
        out.println(scan.nextLine());

        Reader reader=new Reader();
        reader.start();

        String str = "";
        while(!str.equals("exit"))
        {
            str = scan.nextLine();
            out.println(str);
        }
        reader.setstop();
    }

    public void createBridge()
    {
        try
        {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }


    private class Reader extends Thread
    {
        boolean stop;

        public void setstop()
        {
            stop = true;
        }

        @Override
        public void run()
        {
            try
            {
                while(!stop)
                {
                    String str = in.readLine();
                    System.out.println(str);
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
