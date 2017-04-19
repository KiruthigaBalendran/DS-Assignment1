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
public class HumiditySensor {
    public double calculateHumidity() throws InterruptedException
    {
        //generating random values from 0-99
        //to get a random value for humidity
        Random randomNo = new Random();
        double humidity = (double)randomNo.nextInt(100);
        return humidity;
    }
}
