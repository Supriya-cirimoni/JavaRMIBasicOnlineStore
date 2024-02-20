package Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Admin;
import common.Customer;
import common.Person;
import common.PersonFactory;

public class PersonFactoryImpl extends UnicastRemoteObject implements PersonFactory {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonFactoryImpl() throws RemoteException {
        super();
    }

    public Person createPerson(String type) throws RemoteException {
        if (type.equalsIgnoreCase("admin")) {
            return new Admin();
        } else if (type.equalsIgnoreCase("customer")) {
            return new Customer();
        } else {
            throw new IllegalArgumentException("Invalid person type: " + type);
        }
    }
}
