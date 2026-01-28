package commerce.Challenge1;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    // 필드
    Scanner sc = new Scanner(System.in);
    private List<Category> categoryList;
    private Cart cart = new Cart();
    private List<CartItem> cartItemList;
    // 생성자
    public CommerceSystem(List<Category> categoryList){
        this.categoryList = categoryList;
    }

    // 메인 화면
    public void start(){
        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (Integer index = 0; index < categoryList.size(); index++) {
                System.out.println(index + 1 + ". " + categoryList.get(index).getName());
            }
            System.out.println("0. 종료      | 프로그램 종료");
            System.out.println();
            System.out.println("[ 주문 관리 ]");
            System.out.println("4. 장바구니 확인    | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 주문 취소       | 진행중인 주문을 취소합니다.");
            Integer result = sc.nextInt(); // 카테고리 선택

            Integer cartMenu = categoryList.size() + 1;
            Integer clearService = categoryList.size() + 2;

            if (result >= 1 && result <= categoryList.size()) {
                categoryList.get(result - 1).start(cart); // [수정] cart 넘겨줌
            } else if (result == cartMenu) {
                cart.printCart();
            } else if (result == clearService) {
                cart.ClearCart();
            } else {
                System.out.println("없는 메뉴입니다.");
            }

            // 몇개를 장바구니에 담을건지 물어봐야겠지? 그리고 장바구니에 넣어야겠지?
        }
    }
}
