package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;

import common.PersonFactory;
import common.ProductManager;

public class ServerPerson {
    public static void main(String[] args) throws RemoteException {
        try {
            System.out.println("Server started");
            // Create a new instance of the PersonFactoryImpl and bind it to the RMI registry
            PersonFactory factory = new PersonFactoryImpl();
	    System.out.println("PersonFactory Object Created");
            Naming.rebind("//in-csci-rrpc02.cs.iupui.edu:2233/PersonFactory", factory);
            System.out.println("Rebind Done!");
            ProductManager product = new ProductManagerImpl();
	    System.out.println("ProductManager Object Created");
            Naming.rebind("//in-csci-rrpc02.cs.iupui.edu:2233/ProductManager", product);
	    System.out.println("Rebind Done!");
            System.out.println("Server running...");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}
