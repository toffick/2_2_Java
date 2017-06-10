package tests;

import Airplanes.*;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by DELL on 29.03.2017.
 */
public class ExtendsData {

    @DataProvider(name = "airDataProvider")
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {100, 52005, 4055,4545, AirType.A300},
                {45, 8282, 452,4528, AirType.K3},
        };
    }

    @Test(dataProvider = "airDataProvider")
    public void checkParameters(int a, int b, int c, int d, AirType airType) {
        Airplanes ta = new AirCargo(a,b,c,d,airType);
        Assert.assertEquals(d, ta.getWeight());
        System.out.println(ta.getWeight());
    }
}
