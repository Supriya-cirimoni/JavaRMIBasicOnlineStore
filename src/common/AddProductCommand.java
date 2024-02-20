package common;

import java.util.List;

public class AddProductCommand implements Command {
    private Product product;
    private List<Product> productList;

    public AddProductCommand(Product product, List<Product> productList) {
        this.product = product;
        this.productList = productList;
    }
    
    public void execute() {
        productList.add(product);
    }
}