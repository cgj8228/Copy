package test;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart(){this.cartItems = new ArrayList<>();}

    public void addProduct(Product product, Integer quantity){
        for (CartItem item : cartItems) {
            if(item.getProduct().getName().equals(product.getName())){
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product,quantity));
    }

    public List<CartItem> getCartItems(){return cartItems;}

    public boolean isEmpty(){return cartItems.isEmpty();}

    public Integer getTotalAmount(){
        Integer total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice(); // 제품*개수
        }
        return total;
    }

    public void clear(){cartItems.clear();}

    public void displayCart(){
        if(isEmpty()){
            System.out.println("장바구니가 비었습니다.");
            return;
        }

        System.out.println();
        System.out.println("[ 장바구니 내역 ]");
        for (CartItem item : cartItems){
            System.out.println(item.getCartItemInfo());
        }
        System.out.println();
        System.out.println("[ 총 주문 금액 ]");
        System.out.println(String.format("%,d원",getTotalAmount()));
        System.out.println();
    }
}
