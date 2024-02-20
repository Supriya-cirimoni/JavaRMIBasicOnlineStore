package common;
import java.util.List;

public class AddToCartCommand implements Command {
    private Product product;
    private List<Product> cart;

    public AddToCartCommand(Product product, List<Product> cart) {
        this.product = product;
        this.cart = cart;
    }

    public void execute() {
        cart.add(product);
    }
}