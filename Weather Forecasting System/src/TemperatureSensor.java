

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
public class TemperatureSensor {
    
    
    public double calculateTemperature() throws InterruptedException
    {
        //generating random values from 0-99
        Random randomNo = new Random();
        double temperature = (double)randomNo.nextInt(100);
        return temperature;
    }
}
