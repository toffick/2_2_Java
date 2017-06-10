package Lab7.Task2;

import Lab7.Task1.Car;

/**
 * Created by DELL on 06.04.2017.
 */
public class CallCenter {
    private int operatorscount;
    private Client[] operators;
    public CallCenter(){};
    public CallCenter(int size)
    {
        operatorscount = size;
        operators = new Client[size];
    }

    public synchronized void disconnect(Client client)
    {
        for (int i = 0; i < operatorscount; i++)
        {
            if (operators[i] == client) {
                operators[i] = null;
                System.out.println("\u001B[35m" + " end of call " + client.getNameClient());
            }
        }
    }

    public synchronized  void connect(Client client)
    {
        operators[getFreeOperator()] = client;
    }

    public int getFreeOperator()
    {
        for (int i = 0; i < operatorscount; i++) {
            if(operators[i]==null)
                return i;
        }
        return -1;
    }


    public void showParking()
    {
        System.out.print("\u001B[38m \t{ ");
        for (int i = 0; i < operatorscount; i++) {
            if(operators[i]!=null)
            {
                System.out.print("\u001B[84m "+operators[i].getNameClient()+" ");
            }
            else
            {
                System.out.print("\u001B[84m - ");
            }

        }
        System.out.println("\u001B[38m } ");

    }

}
