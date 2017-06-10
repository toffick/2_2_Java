package tests;

import Airplanes.*;

import org.testng.Assert;

import org.testng.annotations.*;


/**
 * Created by DELL on 28.03.2017.
 */
public class AirCargoTest {



    @BeforeClass
    public  void yyhy()
    {
        System.out.println("AirCargoTest _ BeforeClass ");
    }
    @AfterClass
    public  void hdjdl()
    {
        System.out.println("AirCargoTest _ AfterClass ");
    }


    @BeforeMethod
    public  void h()
    {
        System.out.println("AirCargoTest _ Before method");
    }
    @AfterMethod
    public  void hj()
    {
        System.out.println("AirCargoTest _ After method");
    }


    @BeforeSuite
    public  void hjl()
    {
        System.out.println("AirCargoTest _ BeforeSuite ");
    }
    @AfterSuite
    public  void hjdl()
    {
        System.out.println("AirCargoTest _ AfterSuite ");
    }


    @BeforeTest
    public  void hl()
    {
        System.out.println("AirCargoTest _ BeforeTest ");
    }
    @AfterTest
    public  void jl()
    {
        System.out.println("AirCargoTest _ AfterTest ");
    }




    @Test
    public void getCapacity() throws Exception {
        Airplanes tmp = new AirCargo();
        tmp.set_capacity(1000);
        Assert.assertEquals(1000,tmp.getCapacity());
    }

    @Test
    public void getFlightRange() throws Exception {
        Airplanes tmp = new AirCargo();
        tmp.set_flightrange(500);
        Assert.assertEquals(500,tmp.getFlightRange());
    }

}