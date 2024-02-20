package common;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Person extends Remote{
	
    public void login() throws RemoteException;

	public void setUsername(String string) throws RemoteException;

	public void setPassword(String string) throws RemoteException;
}
