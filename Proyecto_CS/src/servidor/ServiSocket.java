package servidor;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiSocket {
    public static void main(String[] args) {
   
         Socket conexion;
        
        try{
            ServerSocket servidor = new ServerSocket(3000);
               
            System.out.println("Escuchando solicitudes en el puerto 3000");
            while(true){
                
            
            conexion = servidor.accept();
            
            Hilo miHilo = new Hilo();
            miHilo.setConexion(conexion);
            miHilo.start();
            }
            
        }catch (Exception e){
            System.out.println("Error "+ e.getMessage());
        }
        
    }
}

