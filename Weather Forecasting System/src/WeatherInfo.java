/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author User
 */
public class WeatherInfo extends UnicastRemoteObject implements IWeatherInformation {
    
    MainServer server = new MainServer();
//    String[] weather;
//    weather[] = server.getWeatherInfo();
    
    public WeatherInfo() throws Exception
    {
        super();
    }
    
    public String getTemperature()
    {
        String p = server.arr[0];
        return p;
    }
}
