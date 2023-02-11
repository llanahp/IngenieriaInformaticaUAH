
import java.rmi.Remote;
import java.rmi.RemoteException;



public interface InterfacSaluda extends Remote {

    Informacion getInformacion() throws RemoteException; //Método que se publica

}
