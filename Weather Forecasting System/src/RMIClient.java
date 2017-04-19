/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import Main.*;
//import Main.IWeatherInformation;
import java.rmi.Naming;

/**
 *
 * @author User
 */
public class RMIClient {
    public static void main(String args[]) throws Exception
    {
        //we know the interface only
        //ask RMI registry to give any object with the name ADD 
        IWeatherInformation obj = (IWeatherInformation)Naming.lookup("getTemperature");
        String p = obj.getTemperature();
        System.err.println("Temperature.....: " +p);
    }
}
