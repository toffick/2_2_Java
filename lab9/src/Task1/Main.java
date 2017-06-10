package Task1;

/**
 * Created by DELL on 23.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        try
        {
            WorkWithSite wws = new WorkWithSite();

            wws.getLocalHost();
            System.out.println();

            wws.getByName("http://onliner.by");
            System.out.println();

            wws.getInfo("http://www.tut.by");
            System.out.println();

            byte ip[] = {(byte)127,(byte)0,(byte)0,(byte)7};
            wws.getByAdress("Unknown",ip);
            System.out.println();

            wws.ReadHTML("http://tut.by");


        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }
}
