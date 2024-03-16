package servsocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServSocket{
    
    public static void main(String[] args) {
   
         Socket conexion;
        
        try{
            ServerSocket servidor = new ServerSocket(3000);
               
            System.out.println("Escuchando solicitudes en el puerto 3000");
            while(true){
                
            
            conexion = servidor.accept();
            
            MiHilo miHilo = new MiHilo();
            miHilo.setConexion(conexion);
            miHilo.start();
            }
            
        }catch (Exception e){
            System.out.println("Error "+ e.getMessage());
        }
        
    }
    
    
}
