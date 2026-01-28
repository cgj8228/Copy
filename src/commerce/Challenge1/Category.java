package commerce.Challenge1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Category {
    private List<Product> productList;
    private String name;

    // 생성자
    public Category(List<Product> productList, String name){
        this.productList = productList;
        this.name = name;
    }

    // 이름 가져오기
    public String getName() {
        return this.name;
    }

    // 카테 고리 제품들 소개
    public void start(Cart cart){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 - "+ this.name +" ]");
            for (Integer index = 0; index < productList.size(); index++) {
                System.out.println(index + 1 + ". " + productList.get(index).getMySimpleInfo());
            }
            System.out.println("0. 뒤로가기");

            Integer result = 0;
            try {
                result = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("값이 잘못 입력되었습니다.");
            }

            if (result>0 && productList.size()+1 > result){
                System.out.println(productList.get(result-1).getMyInfo());
            }else{
                break;
            }

            Product select = productList.get(result-1);

            System.out.printf("몇개 구매 하시겠습니까?: ");
            Integer buy = sc.nextInt();
            cart.addCartItemList(select,buy);
        }
    }
}
