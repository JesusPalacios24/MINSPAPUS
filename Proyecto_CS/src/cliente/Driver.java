/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author mazuk
 */
public class Driver {
    
      Socket conexion;         
         String solicitud = "",respuesta="";
         int caracter;
         InputStream entrada;
         OutputStream salida;
         
    public static void main(String[] args) {
        
        Driver miDriver = new Driver("localhost",3000);
        
        double result;
        result = miDriver.suma(4.5,8);
        System.out.println("la suma fue: "+result);
        miDriver.Desconectar();
        miDriver = new DriverCalc("localhost",3000);
        
        result = miDriver.resta(100,10000);
        System.out.println("la resta fue: "+result);
        
        miDriver.Desconectar();
        
        
    }
    
    public String Conexion(usuario,contraseña,puerto){
        
    }
    
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
