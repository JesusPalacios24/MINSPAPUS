package servidor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Hilo extends Thread{
  int caracter;
        String solicitud="",respuesta="";
        Socket conexion;
        InputStream entrada;
        OutputStream salida;
        byte[] buffer= new byte[20];
    @Override
    
  public void run(){
        //este es el proceso de atencion al cliente
        System.out.println("En el hilo de atencion al cliente");   
           try{
            entrada = conexion.getInputStream();
            salida = conexion.getOutputStream();
            
            //Determinar que es lo que pide el cliente
            //Formar y transmitir una respuesta
            entrada.read(buffer);
            solicitud = new String(buffer);
            
            System.out.println("Solicitud recibida: "+ solicitud);
            
            
            String[] pedacitos;
            pedacitos = solicitud.split(":");
            String operacion,op1,op2;
            operacion=pedacitos[0];
            op1=pedacitos[1];
            op2=pedacitos[2];
            double result;
            
            if(operacion.equals("s")){
                result=Double.parseDouble(op1)+Double.parseDouble(op2);
                respuesta=""+result;
            }else if(operacion.equals("r")){
                result=Double.parseDouble(op1)-Double.parseDouble(op2);
                respuesta=""+result;
            }else if(operacion.equals("d")){
                result=Double.parseDouble(op1)/Double.parseDouble(op2);
                respuesta=""+result;
            }else if(operacion.equals("m")){
                result=Double.parseDouble(op1)*Double.parseDouble(op2);
                respuesta=""+result;
            }else{
                respuesta="ERROR, operacion invalida";
            }
            
            salida.write(respuesta.getBytes());
            
            System.out.println("Respuesta enviada: "+ respuesta);
            
            conexion.close();
            entrada.close();
            salida.close();
            //servidor.close();
            System.out.println("Servidor Cerrado");
           }catch(Exception e){
               System.out.println("Error, "+e.getMessage());
           }
        
    }
    
  public void setConexion(Socket conn){
      this.conexion = conn;
  }
}
