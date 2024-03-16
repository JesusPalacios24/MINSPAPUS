
package clienteSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ClienteSocket {
    
    public static void main(String[] args) {
        
        DriverCalc miDriver = new DriverCalc("localhost",3000);
        
        double result;
        result = miDriver.suma(4.5,8);
        System.out.println("la suma fue: "+result);
        miDriver.Desconectar();
        miDriver = new DriverCalc("localhost",3000);
        
        result = miDriver.resta(100,10000);
        System.out.println("la resta fue: "+result);
        
        miDriver.Desconectar();
        
        
    }
}
