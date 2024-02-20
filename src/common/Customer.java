package common;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Customer extends UnicastRemoteObject implements Person{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() throws RemoteException{
		return password;
	}

	public void setPassword(String password) throws RemoteException{
		this.password = password;
	}

	public Customer() throws RemoteException {
        this.username=" ";
        this.password=" ";
    }

    public Customer(String username, String password)throws RemoteException {
		this.username=username;
		this.password=password;
	}

	public void login() throws RemoteException {
        System.out.println("Customer logged in");
    }
}
