package by.borsuk.Airplanes;

import java.util.Random;

/**
 * Created by ACER on 12.02.2017.
 */

public enum AirType
{
    A300, TU144, Boeing747, AN72, K3,None;

    public static AirType getRandomAirType() {
        Random random = new Random();
        return values()[random.nextInt(values().length-1)];
    }
}
