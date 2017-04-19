


//import Main.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class MainServer {
     public static final int port = 4444;
     
     //number of sensors
     private int count = 4;
     
     //to get the weather information
     public String[] arr = new String[count];
     
//     public String[] getWeatherInfo()
//     {
//         return arr;
//     }
    
    public static void main(String[] args) throws IOException
    {
        //instantiate Server class and call the runServer method
        new MainServer().runServer();
    }
    public void runServer() throws IOException
    {
        //instantiate ServerSocket 
        //listen to that port
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server up & ready for connection...");
        
        while(true){
        Socket socket = serverSocket.accept();
        new ServerThread(socket).start();
        }
    }
    public class ServerThread extends Thread{
        
        Socket socket;
        ServerThread(Socket socket){
            this.socket = socket;
        }
        public void run(){
            try {
                //to read what client sends
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                int i=0;
                while((arr[i] = bufferedReader.readLine())  != null){
                    System.out.println("Incoming client message: "+arr[i]);
                    if(i== (count -1))
                    {
                        i=0;
                    }
                    else
                    {
                        i++;
                    }
                }
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}
