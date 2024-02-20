package common;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonFactory extends Remote {
    public Person createPerson(String type) throws RemoteException;
}