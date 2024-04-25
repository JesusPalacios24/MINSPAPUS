package servrmi;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class claseRemota extends UnicastRemoteObject implements InterfazRemota {
    
    public claseRemota() throws RemoteException{
        super(); 
        
    }
    @Override
    public int suma(int n, int m) throws RemoteException{
        return n + m;
    }
}
