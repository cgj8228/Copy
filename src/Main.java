import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<Product>();
        Scanner sc = new Scanner(System.in);

        productList.add(new Product("Galaxy S24", 1200000, "최신 스마트폰", 50));
        productList.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
        productList.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        productList.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50));

        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (Integer index = 0; index < productList.size(); index++) {
                System.out.println(index + 1 + ". " + productList.get(index).getMySimpleInfo());
            }
            System.out.println("0. 종료           | 프로그램 종료");

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
        }


    }
}