package Server;

import common.ProductManager;
import common.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ProductManagerImpl extends UnicastRemoteObject implements ProductManager {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> productList = new ArrayList<>();

    public ProductManagerImpl() throws RemoteException{
        // Add some default products to the list
        Product product1 = new Product("Electronics", "Smartphone", 999.99, 5);
        Product product2 = new Product("Clothing", "T-Shirt", 19.99, 10);
        Product product3 = new Product("Home", "Coffee Maker", 49.99, 3);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        }
    public List<Product> browseProducts() throws RemoteException{
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            result.add(product);
        }
        return result;
    }

    public Product getProductByName(String name) throws RemoteException{
        for (Product product : productList) {
            if (product.getDescription().equals(name)) {
                return product;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    public void addProduct(Product product) throws RemoteException{
        Command command = new AddProductCommand(product, productList);
        command.execute();
    }

    public void removeProduct(Product product) throws RemoteException{
        Command command = new RemoveProductCommand(product, productList);
        command.execute();
        System.out.println(product.getDescription() + " removed from product list");
    }

    public void updateProduct(Product product, double newPrice, String type, String des, int quantity)throws RemoteException {
        Command command = new UpdateProductCommand(product, newPrice, type, des, quantity);
        command.execute();
        System.out.println(product.getDescription() + " price updated to $" + product.getPrice());
    }

    public void addToCart(Product product, List<Product> cart) throws RemoteException{
        Command command = new AddToCartCommand(product, cart);
        command.execute();
    }

    public double purchaseCart(List<Product> cart) throws RemoteException{
    	    double totalCost = 0.0;
    	    for (Product product : cart) {
    	        int quantity = product.getQuantity();
    	        if (quantity > 0) {
    	            product.setQuantity(quantity - 1);
    	            totalCost += product.getPrice();
    	        } else {
    	            System.out.println(product.getDescription() + " is out of stock");
    	        }
    	    }
    	    cart.clear();
    	    System.out.println("Total cost: $" + totalCost);
    	    return totalCost;
	}
    public void removeFromCart(Product product, List<Product> cart) throws RemoteException {
        Command command = new RemoveFromCartCommand(product, cart);
        command.execute();
    }

    public void viewCart(Product product, List<Product> cart) throws RemoteException{
        Command command = new BrowseCartCommand(product, cart);
        command.execute();
    }
    public void printProductDetails(Product product) throws RemoteException{
        System.out.printf("%-10s %-20s $%.2f    Quantity: %d%n", 
                product.getType(), product.getDescription(), product.getPrice(), product.getQuantity());
    }

}