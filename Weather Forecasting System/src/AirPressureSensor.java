/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import Main.*;
import java.util.Random;

/**
 *
 * @author User
 */
public class AirPressureSensor {
    public double calculateAirPressure() throws InterruptedException
    {
        //generating random values from 0-50
        //to get a random value for location
        Random randomNo = new Random();
        double airPressure = (double)randomNo.nextInt(50);
        return airPressure;
    }
}
