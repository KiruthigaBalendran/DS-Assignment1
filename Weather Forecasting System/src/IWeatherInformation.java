/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.rmi.Remote;

/**
 *
 * @author User
 */
public interface IWeatherInformation extends Remote {
    public String getTemperature() throws java.rmi.RemoteException;
}
