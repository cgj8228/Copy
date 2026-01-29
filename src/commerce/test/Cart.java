package commerce.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cart {
    private List<CartItem> cartItemList;

    // 삭제된 상품이 장바구니에 있다면 장바구니에서도 제거
//    public void removeProductName(String name){
//        for (int i=0; i<cartItemList.size(); i++){
//            if(cartItemList.get(i).getProduct().getName().equals(name)){
//                cartItemList.remove(i);
//            }
//        }
//    }


    // 스트림 필터로 제거
    public void removeProductName(String name){
        cartItemList = cartItemList.stream()
                .filter(item -> !item.getProduct().getName().equals(name))
                .collect(Collectors.toList());
    }


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
        if (cartItemList.isEmpty()) { // [추가] 장바구니 비었을 때 처리
            System.out.println("장바구니가 비었습니다.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer(); // [추가] 고정 고객 1명

        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ 장바구니 내역 ]");
        for (CartItem cartItem : cartItemList) {
            System.out.println(cartItem.printCartItem());
        }
        System.out.println();
        System.out.println("[ 총 주문 금액 ]");
        int originalAmount = getTotalAmount();
        System.out.printf("%,d원\n", originalAmount);

        System.out.println("1. 주문 하기      2. 메인으로 돌아가기");
        int input = sc.nextInt();
        sc.nextLine();

        if (input == 2) return;

        if (input == 1) {
            System.out.println("고객 이메일을 입력해주세요.");
            System.out.print("입력 : ");
            String emailInput = sc.nextLine();

            if (!emailInput.equals(customer.getEmail())) {
                System.out.println("등록되지 않은 이메일입니다.");
                return;
            }

            CustomerGrade grade = customer.getGrade();

            System.out.printf("해당 유저는 %s 등급 이므로 %d%% 할인이 적용됩니다.\n",
                    grade.getGradeName(), grade.getDiscountRate());

            System.out.println("주문 하시겠습니까?");
            System.out.println("1. 주문 확정  2. 메인으로 돌아가기");
            int confirm = sc.nextInt();
            sc.nextLine();

            if (confirm != 1) return;

            // 재고 부족 체크
            for (CartItem cartItem : cartItemList) {
                Product p = cartItem.getProduct();
                int buy = cartItem.getQuantity();
                if (buy > p.getCount()) {
                    System.out.printf("%s 재고 부족! (재고:%d, 요청:%d)\n", p.getName(), p.getCount(), buy);
                    return;
                }
            }

            // 재고 차감, 업데이트 출력
            for (CartItem cartItem : cartItemList) {
                Product p = cartItem.getProduct();
                int buy = cartItem.getQuantity();

                int before = p.getCount();
                deductedProduct(p, buy);

                System.out.printf("%s 재고가 %d개 → %d개로 업데이트되었습니다.\n",
                        p.getName(), before, p.getCount());
            }

            int discountAmount = grade.getDiscountAmount(originalAmount);
            int finalAmount = grade.applyDiscount(originalAmount);

            System.out.println("주문이 완료되었습니다!");
            System.out.printf("할인 전 금액: %,d원\n", originalAmount);
            System.out.printf("%s 등급 할인(%d%%): -%,d원\n",
                    grade.getGradeName(), grade.getDiscountRate(), discountAmount);
            System.out.printf("최종 결제 금액: %,d원\n", finalAmount);

            cartItemList.clear(); // 주문 완료 후 장바구니 비우기(원하면)
            return;

        } else {
            System.out.println("없는 번호 입니다.");
            return;
        }
    }

}
