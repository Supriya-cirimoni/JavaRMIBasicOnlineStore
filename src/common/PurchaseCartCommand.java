package common;
import java.util.List;

public class PurchaseCartCommand implements Command {
    private List<Product> cart;

    public PurchaseCartCommand(List<Product> cart) {
        this.cart = cart;
    }

    public void execute() {
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
        System.out.println("Total cost: $" + totalCost);
        cart.clear();
    }
}