package common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Admin extends UnicastRemoteObject implements Person {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    private List<Person> customers;
    private List<Person> admins;

    public Admin() throws RemoteException {
        this.username = "";
        this.password = "";
        this.customers = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    public String getUsername() throws RemoteException {
        return username;
    }

    public void setUsername(String username) throws RemoteException {
        this.username = username;
    }

    public String getPassword() throws RemoteException {
        return password;
    }

    public void setPassword(String password) throws RemoteException {
        this.password = password;
    }

    public void login() throws RemoteException {
        System.out.println("Admin logged in");
    }

    public void addCustomer(Customer customer) throws RemoteException {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) throws RemoteException {
        customers.remove(customer);
    }

    public void addAdmin(Admin admin) throws RemoteException {
        admins.add(admin);
    }

    public List<Person> getCustomers() throws RemoteException {
        return customers;
    }

    public List<Person> getAdmins() throws RemoteException {
        return admins;
    }
}