
package servrmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRemota extends Remote {
  
    public int suma(int n,int m) throws RemoteException;        
    
}
