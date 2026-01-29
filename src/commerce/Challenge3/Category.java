package commerce.Challenge3;

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

    // 게터
    public String getName() {
        return this.name;
    }
    public List<Product> getProductList() {return productList;}

    // 카테 고리 제품들 소개
    public void start(Cart cart){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 - "+ this.name +" ]");

            // 100만원 필터
            System.out.println("[ 100만원 이하 상품 목록 ]");
            productList.stream()
                    .filter(p -> p.getPrice() <= 1_000_000)
                    .forEach(p -> System.out.println(p.getMySimpleInfo()));
            System.out.println();

            System.out.println("[ 100만원 이상 상품 목록 ]");
            productList.stream()
                    .filter(p -> p.getPrice() >= 1_000_000)
                    .forEach(p -> System.out.println(p.getMySimpleInfo()));


//            // 스트림으로 상품 출력**************
//            productList.stream()
//                    .forEach(p -> System.out.println(p.getMySimpleInfo()));

            System.out.println("0. 뒤로가기");

            Integer result = 0;

            try {
                result = sc.nextInt();
                if (result == 0){break;}
            } catch (InputMismatchException e) {
                System.out.println("값이 잘못 입력되었습니다.");
                sc.next();
                continue;
            }

            if (result>0 && productList.size()+1 > result){
                System.out.println(productList.get(result-1).getMyInfo());
            }else{
                System.out.println("없는 번호 입니다.");
                continue;
            }

            Product select = productList.get(result-1);
            Integer buy = 0;
            // 구매 > 재고
            System.out.printf("몇개 구매 하시겠습니까?: ");

            // 문자 입력
            try {
                buy = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("값이 잘못 입력되었습니다.");
                sc.next();
                continue;
            }

            if (buy > select.getCount()){
                System.out.println("재고 보다 많은 양을 입력하였습니다.");
                continue;
            }
            cart.addCartItemList(select,buy);
        }
    }
}
