/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.Timestamp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    
    public String mensaje(String mensajito,String Usuario,String puerto){
        try{   
       solicitud= Usuario+": "+mensajito;
       salida.write(solicitud.getBytes());
            
           while((caracter = entrada.read())!=-1){
                respuesta = respuesta + (char) caracter;
            }
           File archivo = new File(puerto);

            // Verificar si el archivo no existe y crearlo si es necesario
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            // Crear FileWriter con el objeto File
            FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
            
            // Crear BufferedWriter para escribir en el archivo
            BufferedWriter bw = new BufferedWriter(fw);

            // Escribir texto en el archivo
            bw.write(respuesta);
            bw.newLine(); // Salto de línea para futuras escrituras

            // Cerrar el BufferedWriter
            bw.close();

            System.out.println("¡Texto guardado en el archivo correctamente!");

            System.out.println(respuesta);
         }catch(Exception e){
             System.out.println("Error: "+e.getMessage());
         }
        
        
        return respuesta;
    }
    
    
    public String cargar(String puerto){
        //aqui va el .txt nombrado como el puerto al que se conecta el usuario
         String rutaProyecto = System.getProperty("user.dir");
         String archivo= rutaProyecto+"\\src\\Doc\\"+puerto; 
         Interfaz interfaz = new Interfaz();
         String mens="";  
         try{
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            
            // Leer cada línea del archivo hasta que se alcance el final
            while ((linea = br.readLine()) != null) {
                // Procesar la línea (en este ejemplo, simplemente imprimirla)
                System.out.println(linea);
                if(linea.equals(".")){
                    mens=mens+"/n";
                }else{
                    mens=mens+linea;
                }
                
            }
           
            // Cerrar el BufferedReader y el FileReader
            br.close();
            fr.close();
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
            return mens;
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



