package common;
public class UpdateProductCommand implements Command {
    private Product product;
    private double newPrice;
    private String newType;
    private String newDescription;
    private int newQuantity;

    public UpdateProductCommand(Product product, double newPrice,String type,String des, int Quantity) {
        this.product = product;
        this.newPrice = newPrice;
        this.newType=type;
        this.newDescription=des;
        this.newQuantity=Quantity;
    }

    public void execute() {
        product.setPrice(newPrice);
        product.setDescription(newDescription);
        product.setQuantity(newQuantity);
        product.setType(newType);
    }
}