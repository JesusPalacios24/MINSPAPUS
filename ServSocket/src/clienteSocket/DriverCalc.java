package clienteSocket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DriverCalc {
    
        
         Socket conexion;         
         String solicitud = "",respuesta="";
         int caracter;
         InputStream entrada;
         OutputStream salida;
        
         
    public DriverCalc(String host, int puerto){
        try{
            conexion = new Socket(host,puerto);   
            System.out.println("Conexion realizada con el servidor");
            entrada = conexion.getInputStream();
            salida = conexion.getOutputStream();
            salida.write(solicitud.getBytes());
                 
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    
   }
    
    
   public double suma(double a, double b){
         try{   
       solicitud= "s"+":"+a+":"+b;
       salida.write(solicitud.getBytes());
            
           while((caracter = entrada.read())!=-1){
                respuesta = respuesta + (char) caracter;
            }
            System.out.println("El servidor dijo: "+respuesta);
         }catch(Exception e){
             System.out.println("Error: "+e.getMessage());
         }
       return Double.parseDouble(respuesta);
   }
   
    public double resta(double c, double d){
         try{   
       solicitud= "r"+":"+c+":"+d;
       salida.write(solicitud.getBytes());
            
           while((caracter = entrada.read())!=-1){
                respuesta = respuesta + (char) caracter;
            }
            System.out.println("El servidor dijo: "+respuesta);
         }catch(Exception e){
             System.out.println("Error: "+e.getMessage());
         }
       return Double.parseDouble(respuesta);
   }
    /* public double multi(double a, double b){
         try{   
       solicitud= "m"+ a +":"+b;
       salida.write(solicitud.getBytes());
            
           while((caracter = entrada.read())!=-1){
                respuesta = respuesta + (char) caracter;
            }
            System.out.println("El servidor dijo: "+respuesta);
         }catch(Exception e){
             System.out.println("Error: "+e.getMessage());
         }
       return Double.parseDouble(respuesta);
   }
   */
   public void Desconectar(){
            try{
            conexion.close();
            entrada.close();
            salida.close();
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
   }
}
