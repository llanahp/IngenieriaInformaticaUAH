
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfacInformacion extends Remote {

    Informacion getInformacion(ArrayList<String> cierreDePuestos) throws RemoteException;

}
