package common;
import java.io.Serializable;

public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
	private String type;
    private String description;
    private double price;
    private int quantity;

    public Product(String type, String description, double price, int quantity) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    	this.type = " ";
        this.description = " ";
        this.price = 0;
        this.quantity = 0;
	}

	public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
    
	public double getPrice() {
        return price;
    }
	
    public int getQuantity() {
        return quantity;
    }

    public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
	@Override
    public String toString() {
        return "Product [type=" + type + ", description=" + description + ", price=" + price + ", quantity=" + quantity + "]";
    }
}