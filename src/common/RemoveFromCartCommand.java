package common;
import java.util.List;
public class RemoveFromCartCommand implements Command {
    private Product product;
    private List<Product> cart;

    public RemoveFromCartCommand(Product product, List<Product> cart) {
        this.product = product;
        this.cart = cart;
    }

    public void execute() {
        cart.remove(product);
    }
}