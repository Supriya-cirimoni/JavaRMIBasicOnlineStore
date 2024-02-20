package Client;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.Admin;
import common.Customer;
import common.Person;
import common.PersonFactory;
import common.Product;
import common.ProductManager;

public class ClientPerson {
    public static void main(String[] args) throws Exception {
        try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Welcome to online Shopping store!");
			PersonFactory remoteFactory = (PersonFactory) Naming.lookup("//in-csci-rrpc02.cs.iupui.edu:2233/PersonFactory");
			ProductManager remoteProduct = (ProductManager) Naming.lookup("//in-csci-rrpc02.cs.iupui.edu:2233/ProductManager");
			do {
				System.out.println("Click 1.Customer 2.Admin 3.Exit");
				int n=sc.nextInt();
				List<Product> productList = remoteProduct.browseProducts();
				if(n==1) {
					Person cust = remoteFactory.createPerson("customer");
					cust.login();
					System.out.println("You are successfully logged in!");
					List<Product> cart = new ArrayList<>();
					do {
						System.out.println("Select 1.Add to cart \n2.Remove from cart \n3.View Items in cart \n4.Purchase Items in cart \n5View Products \n6.Logout");
				        int input2=sc.nextInt();
				        switch(input2) {
				        case 1:System.out.println("Products:");
				        		for (Product product : productList) {
				        		   System.out.println(product.getType() + " - " + product.getDescription() + " - $" + product.getPrice() + " - " + product.getQuantity() + " in stock");
				        	   }
				   	           Product productToAdd=new Product();
				   	           // Add a product to the cart
				   	           System.out.println("Enter a product name to add to your cart (or enter 'done' to finish shopping):");
				   	           while (true) {
				   	        	   String item = sc.nextLine();
				   	        	   if (item.equals("done")) {
				   	        		   System.out.println("Total cost:"+remoteProduct.purchaseCart(cart));
				   	        		   break;
				   	        	   }
				   	        	   productToAdd = remoteProduct.getProductByName(item);
				   	        	   if (productToAdd != null) {
				   	        		   remoteProduct.addToCart(productToAdd, cart);
				   	        		   cart.add(productToAdd);
				   	        		   System.out.println("Product Added!");
				   	        	   }
				   	           }
				   	           break;
				        case 2:System.out.println("Enter a product name to remove from the cart (or enter 'done' to finish shopping):");
				        		while(true) {
				               String itemToRemove = sc.nextLine();
				               if (itemToRemove.equals("done")) {
			   	        		   System.out.println("Total cost:"+remoteProduct.purchaseCart(cart));
			   	        		   break;
			   	        	   }
				               Product productToRemove = null;
				               for (Product product : cart) {
				            	   if (product.getDescription().equals(itemToRemove)) {
				                   productToRemove = product;
				                   break;
				            	   }
				               }
				               if (productToRemove != null) {
				            	   remoteProduct.removeFromCart(productToRemove, cart);
				            	   cart.remove(productToRemove);
				            	   System.out.println("Product removed from cart.");
				               }
				               else {
				                System.out.println("Product not found in cart.");
				               }}
				            break;
				        case 3:System.out.println("Products in your cart:");
				        	   if (cart.isEmpty()) {
				        	   System.out.println("Your cart is empty.");
				        	   } 
				        	   else {
				        		   System.out.println("Items in your cart:");
				        		   for (Product product : cart) {
				        			   System.out.println(product.getDescription()+"-"+product.getPrice());
				        		   }
				        	   }
				        	   break;
				        case 4:if (cart.isEmpty()) {
				        	   System.out.println("Your cart is empty.");
				        	   } 
				        	   else {
				        		   System.out.println("Purchase Successful with total cost:"+remoteProduct.purchaseCart(cart));
								 cart.clear();
				        	   }
				        		break;
				        case 5: System.out.println("Products:");
			        	   		for (Product product : productList) {
			        	   			System.out.println(product.getType() + " - " + product.getDescription() + " - $" + product.getPrice() + " - " + product.getQuantity() + " in stock");
			        	   		}
			        	   		break;
				        case 6: System.out.println("Logged out!");
								System.exit(0);
				        default:System.out.println("Invalid Input");
				        }
					}while(true);
				}
				else if(n==2) { 
					Person admin = remoteFactory.createPerson("admin");
					admin.login();
					System.out.println("You are successfully logged in!");
					List<Product> Product = new ArrayList<>();
					do {
						System.out.println("Select 1.view products \n2.Add product \n3.Remove product \n4.Update product \n5.Add admin \n6.Add customer \n7.Remove customer \n8.Logout");
				        int input2=sc.nextInt();
				        switch(input2) {
				        case 1:System.out.println("Products:");
				        	   for (Product product : productList) {
				        		   System.out.println(product.getType() + " - " + product.getDescription() + " - $" + product.getPrice() + " - " + product.getQuantity() + " in stock");
				        	   }
				   	           break;
				        case 2:Product p=new Product("type","des",22.99,5);
				        	remoteProduct.addProduct(p);
				        	System.out.println("Product Added");
				        	List<Product> products = remoteProduct.browseProducts();
				            System.out.println("List of products:");
				            for (Product product : products) {
				                System.out.println(product.getDescription() + " - " + product.getPrice());
				            }
				            break;
				        case 3:System.out.println("Enter the product name to remove:");
				        	String productName = sc.nextLine();
				        	Product productToRemove = remoteProduct.getProductByName(productName);
				        	if (productToRemove != null) {
				        		remoteProduct.removeProduct(productToRemove);
				        	}
				        	else {
				        		System.out.println("product name is not valid.");
				        	}
				        break;
				        case 4:
				            System.out.println("Enter the product name to update:");
				            String productNameToUpdate = sc.nextLine();
				            Product productToUpdate = remoteProduct.getProductByName(productNameToUpdate);
				            if (productToUpdate != null) {
				                System.out.println("Enter the new price:");
				                double newPrice = sc.nextDouble();
				                sc.nextLine(); // consume the newline character
				                System.out.println("Enter the new type:");
				                String newType = sc.nextLine();
				                System.out.println("Enter the new description:");
				                String newDescription = sc.nextLine();
				                System.out.println("Enter the new quantity:");
				                int newQuantity = sc.nextInt();
				                sc.nextLine(); // consume the newline character
				                remoteProduct.updateProduct(productToUpdate, newPrice, newType, newDescription, newQuantity);
				            }
				            break;
				        case 5: Admin a = new Admin();
				        a.setUsername("admin1");
				        a.setPassword("password123");
				        a.addAdmin(a);
				        System.out.println("Admin added");
				        		break;
				        case 6: Customer c = new Customer("admin1","password123");
				        Admin a1=new Admin();
				        a1.addCustomer(c);
				        System.out.println("Admin added");break;
				        case 7: System.out.println("Customer Removed");
				        		break;
				        case 8: System.out.println("Logged out!");
								System.exit(0);
				        default:System.out.println("Invalid Input");
						}
						}while(true);
					}
				else if(n==3) { System.out.println("Thanks for visiting!");
						System.exit(0);
				}
				else
				{System.out.println("Invalid Input");}
			}while(true);
        }
		catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}

    }
}