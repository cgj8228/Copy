package commerce.Challenge2;

public class CartItem {
    private Product product;
    private Integer quantity;

    public CartItem(Product product, Integer quantity){
        this.product=product;
        this.quantity=quantity;
    }

    public Product getProduct(){
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice(){
        return product.getPrice() * quantity;
    }

    public String printCartItem(){
        return product.getName() + " | " + product.getPrice() + "원 | " + product.getDescription() + " | " + quantity;
    }
}
