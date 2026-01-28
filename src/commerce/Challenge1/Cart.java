package commerce.Challenge1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    private List<CartItem> cartItemList;

    public Cart(){
        this.cartItemList = new ArrayList<>();
    }

    public void ClearCart(){
        cartItemList.clear();
    }
    public void addCartItemList(Product product, Integer quantity){
        for (CartItem cartItem : cartItemList) {
            if(cartItem.getProduct().getName().equals(product.getName())){
                cartItem.setQuantity(cartItem.getQuantity()+quantity);
                return;
            }
        }
        cartItemList.add(new CartItem(product,quantity));
    }

    public Integer getTotalAmount(){
        Integer total=0;
        for (CartItem cartItem : cartItemList) {
            total += cartItem.getTotalPrice();
        }
        return total;
    }

    public void deductedProduct(Product product, Integer buy){
        product.setCount(product.getCount()-buy);
    }

    public void printCart(){
        Scanner sc = new Scanner(System.in);

        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ 장바구니 내역 ]");
        for (CartItem cartItem : cartItemList) {
            System.out.println(cartItem.printCartItem());
        }
        System.out.println();
        System.out.println("[ 총 주문 금액 ]");
        System.out.printf("%,d원\n",getTotalAmount());

        System.out.println("1. 주문 확정      2. 메인으로 돌아가기");
        Integer input = sc.nextInt();
        if (input == 1) {
            for (CartItem cartItem : cartItemList) {
                Product p = cartItem.getProduct();
                int buy = cartItem.getQuantity();
                deductedProduct(p, buy);
            }
        } else if (input ==2) {
            return;
        } else {
            System.out.println("없는 번호 입니다.");
        }

    }
}
