
package servrmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRemota extends Remote {
  
    public String saludar(String nombre) throws RemoteException;        
    
}
