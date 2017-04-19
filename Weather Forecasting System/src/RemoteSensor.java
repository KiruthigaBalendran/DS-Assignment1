


//import Main.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//This class will call other sensor classes and send the weather information
//to the server
//In this way, we can easily add any sensors and call their methods in this class
public class RemoteSensor {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Socket socket = new Socket("localhost",4444);
        
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));
        
        
     /*******This is the section to create instances for the sensor classes ***/
     
        //creating an instance of TemperatureSensor class
        TemperatureSensor temp = new TemperatureSensor();
        
        //creating an instance of RainfallSensor class
        RainfallSensor rain = new RainfallSensor();
        
        //creating an instance of HumiditySensor class
        HumiditySensor humidity = new HumiditySensor();
        
        //creating an instance of AirPressureSensor class
        AirPressureSensor air = new AirPressureSensor();
        
     /************************************************************************/   
        
        //sending temperature info for every 5 secs
        Timer t = new Timer();
        t.schedule(new TimerTask() {
        @Override
        public void run() {
            
            try {
                
                /*****Sending weather information to the server*************/
                
                //send temperature info to the server 
                printWriter.println("Temperature is : " + temp.calculateTemperature());
                //send rainfall info to the server
                printWriter.println("Rainfall is : " + rain.calculateRainfall());
                //send humidity info to the server
                printWriter.println("Humidity is : " + humidity.calculateHumidity());
                //send airpressure info to the server
                printWriter.println("AirPressure is : " + air.calculateAirPressure());
                
                /**********************************************************/
                
            } catch (InterruptedException ex) {
                Logger.getLogger(TemperatureSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }, 0, 5000);
        
    }
}
