package tests;

import Airplanes.*;
import Airport.*;
import org.junit.Assert;
import org.testng.annotations.*;

/**
 * Created by DELL on 28.03.2017.
 */
public class ClassDep {
    @Test
    public void testClassDep()
    {
        Airplanes kk = new AirCargo();
        Airport ll = new Airport();
        ll.add(kk);
        Assert.assertNotNull(ll.getAirlist().get(0));
    }
}
