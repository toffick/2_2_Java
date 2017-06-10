package Task2.Chat;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;





public class Server {
    ServerSocket server;
   List<Connection> connections = Collections.synchronizedList(new ArrayList<Connection>());

   private class Connection extends Thread
    {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;

        private String name = "";


        public Connection(Socket s)
        {
            socket = s;
            createBridge();
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

        @Override
        public void run()
        {
            try {
                name = in.readLine();


             String str;

             while(true)
             {
                 str = in.readLine();
                 if(str.equals("exit"))
                     break;
                 synchronized (connections) {

                     for(Connection c: connections)
                         c.out.println(name + ": " + str);
                 }
             }


            } catch (IOException e) {
                e.printStackTrace();
            }
            finally
            {
                close();
            }

        }

        private void close() {
            try {
                in.close();
                out.close();
                socket.close();
                connections.remove(this);
            }
            catch(Exception ee){
                ee.printStackTrace();
            }

        }


    }









    public Server() throws IOException {
        try {
            System.out.println("Server init ");
            server = new ServerSocket(6688);

            while (true) {

                Connection connection = new Connection(server.accept());
                connections.add(connection);
                connection.start();
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally {
            closeAll();
        }
    }

    public void closeAll() {
        try {

            server.close();

            synchronized(connections) {
                Iterator<Connection> iter = connections.iterator();
                while(iter.hasNext()) {
                     iter.next().close();
                }
            }
        }
        catch (Exception e)
        {
            System.err.println("Потоки не были закрыты!");
        }
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
