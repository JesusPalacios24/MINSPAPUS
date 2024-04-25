package servrmi;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ServRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{    
        claseRemota ObjetoRemoto = new claseRemota();
            System.out.println("Objeto remoto creado");
        Registry elRegistro = LocateRegistry.createRegistry(3000);
        System.out.println("Registro temporal creado");
        elRegistro.rebind("saludador", ObjetoRemoto);
        System.out.println("Objeto registrado y listo para usarse");   
            
        }catch(RemoteException ex){
            System.out.println("Error: "+ ex.getMessage());
            //MISPAPUS
        }
    }
        
    
}
