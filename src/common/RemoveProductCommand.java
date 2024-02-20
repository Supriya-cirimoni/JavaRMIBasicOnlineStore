package common;
import java.util.List;

public class RemoveProductCommand implements Command {
    private Product product;
    private List<Product> productList;

    public RemoveProductCommand(Product product, List<Product> productList) {
        this.product = product;
        this.productList = productList;
    }

    public void execute() {
        productList.remove(product);
    }
}