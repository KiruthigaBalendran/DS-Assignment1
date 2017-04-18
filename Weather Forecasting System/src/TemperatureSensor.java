/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class TemperatureSensor {
    public static void main(String args[]) throws IOException, InterruptedException
    {
        Socket socket = new Socket("localhost",4444);
        
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));
        
        //creating an instance of TemperatureSensor class
        TemperatureSensor temp = new TemperatureSensor();
        
        //sending temperature info for every 5 secs
        Timer t = new Timer();
        t.schedule(new TimerTask() {
        @Override
        public void run() {
            //send temperature info to the server 
            try {
                printWriter.println("Temperature is : " + temp.calculateTemperature());
            } catch (InterruptedException ex) {
                Logger.getLogger(TemperatureSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }, 0, 5000);
        
    }
    
    public int calculateTemperature() throws InterruptedException
    {
        //generating random values from 0-99
        Random randomNo = new Random();
        int ans = randomNo.nextInt(100);
        return ans;
    }
}
