package tests;
import Airplanes.*;


import Airport.Airport;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by DELL on 28.03.2017.
 */
public class AirportTest {

    @BeforeClass
    public  void yyy()
    {
        System.out.println("AirportTest _ BeforeClass ");
    }


    @BeforeMethod
    public  void h()
    {
        System.out.println("AirportTest _ Before method");
    }
    @AfterMethod
    public  void hj()
    {
        System.out.println("AirportTest _ After method");
    }

    @BeforeSuite
    public  void hjl()
    {
        System.out.println("AirportTest _ BeforeSuite ");
    }


    @BeforeTest
    public  void hl()
    {
        System.out.println("AirportTest _ BeforeTest ");
    }


    @AfterTest
    public  void jl()
    {
        System.out.println("AirportTest _ AfterTest ");
    }

    @AfterSuite
    public  void hjdl()
    {
        System.out.println("AirportTest _ AfterSuite ");
    }


    @AfterClass
    public  void hdjdl()
    {
        System.out.println("AirportTest _ AfterClass ");
    }

    @Test
    public void getAirlist() throws Exception {
        Airport airport = new Airport();
        Assert.assertNotNull(airport.getAirlist());
    }

    @Test
    public void setAirlist() throws Exception {
        Airport airport = new Airport();
        ArrayList<Airplanes> kkk = new ArrayList<Airplanes>();
        airport.setAirlist(kkk);
        Assert.assertEquals(kkk, airport.getAirlist());
    }

    @Test(timeOut = 1)
    public void sum() throws Exception {
        Airport airport = new Airport();
        Assert.assertEquals(3, airport.sum(1,2));
    }

    @Test(enabled = false)                                      //ingore
    public void add() throws Exception {
        Airport airport = new Airport();
        Assert.assertTrue(airport.add(new AirCargo()));
    }



}