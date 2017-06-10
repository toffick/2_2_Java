package by.borsuk.Serializable;


import by.borsuk.Airplanes.Airplanes;
import by.borsuk.Airport.Airport;

import java.io.*;

/**
 * Created by DELL on 14.03.2017.
 */
public class Serializabl {
    public boolean serialization(Airplanes air, String fileName) {
        boolean flag = false;
        File f = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(f)) {
            if (fos != null) {
                ObjectOutputStream ostream =
                        new ObjectOutputStream(fos);
                ostream.writeObject(air); // сериализация
                flag = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Airplanes deserialization(String fileName)
            throws InvalidObjectException {
        File fr = new File(fileName);
        try ( FileInputStream fis =  new FileInputStream(fr)){

            ObjectInputStream istream =  new ObjectInputStream(fis);

            Airplanes air =  (Airplanes) istream.readObject();

            return air;
        }
        catch ( IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new InvalidObjectException
                ("объект не восстановлен");
    }
}

