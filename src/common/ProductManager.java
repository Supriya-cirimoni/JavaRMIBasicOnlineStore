package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductManager extends Remote {
    List<Product> browseProducts() throws RemoteException;
    Product getProductByName(String name) throws RemoteException;
    void addProduct(Product product) throws RemoteException;
    void removeProduct(Product product) throws RemoteException;
    void updateProduct(Product product, double newPrice, String type, String des, int quantity) throws RemoteException;
    void addToCart(Product product, List<Product> cart) throws RemoteException;
    double purchaseCart(List<Product> cart) throws RemoteException;
    public void removeFromCart(Product product, List<Product> cart) throws RemoteException;
    void viewCart(Product product, List<Product> cart) throws RemoteException;
    void printProductDetails(Product product) throws RemoteException;
}