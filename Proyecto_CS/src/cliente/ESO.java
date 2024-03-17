
package cliente;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ESO {
    
    public static void main(String[] args) {
        String elmensaje="",usuario="";
        
        
        Driver miDriver = new Driver("localhost",3000);
        
        String Mensaje;
        Mensaje = miDriver.mensaje(usuario, elmensaje);
       
        
        miDriver.Desconectar();       
    }
   
}
