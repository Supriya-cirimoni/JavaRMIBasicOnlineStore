package common;

import java.util.List;

public class BrowseCartCommand implements Command {
    private final Product product;
    private final List<Product> cart;

    public BrowseCartCommand(Product product, List<Product> cart) {
        this.product = product;
        this.cart = cart;
    }

    @Override
    public void execute() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (Product product : cart) {
                System.out.println(product.getDescription());
            }
        }
    }
}
