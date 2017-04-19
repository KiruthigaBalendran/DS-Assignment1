/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import Main.*;
import static java.rmi.Naming.rebind;

/**
 *
 * @author User
 */
public class RMIServer {
    public static void main(String args[]) throws Exception
    {
        //create object out of AddC
        WeatherInfo obj = new WeatherInfo();
        //link obj with rmiregisrty
        rebind("getTemperature", obj);
        System.err.println("Server started");
    }
}
