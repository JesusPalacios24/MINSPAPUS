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
        
         
    public Driver(String host, int puerto){
        try{
            conexion = new Socket(host,puerto);   
            System.out.println("Inicio de sesion ");         
            entrada = conexion.getInputStream();
            salida = conexion.getOutputStream();
            salida.write(solicitud.getBytes());
                 
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    
   }
    
    public String mensaje(String mensajito){
        try{   
       solicitud= mensajito;
       salida.write(solicitud.getBytes());
            
           while((caracter = entrada.read())!=-1){
                respuesta = respuesta + (char) caracter;
            }
            System.out.println("El servidor dijo: "+respuesta);
         }catch(Exception e){
             System.out.println("Error: "+e.getMessage());
         }
        
        
        return respuesta;
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