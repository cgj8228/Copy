package commerce.step2;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Product> productList; // new ArrayList()<> 초기값 필요없음

    public CommerceSystem(List<Product> productList){
        this.productList = productList;
    }

    public void start(){
        while(true) {
            Scanner sc = new Scanner(System.in);

            for (Integer index = 0; productList.size() > index; index++) {
                System.out.println(index + 1 + ". " + productList.get(index).getMySimpleInfo());
            }

            Integer result = 0;
            System.out.println("0. 종료           | 프로그램 종료");
            try {
                result = sc.nextInt();
            }catch (Exception e){
                System.out.println("잘못된 입력 입니다.");
            }
            System.out.println("들어온 값은 "+result+"입니다");

            if (result > 0 && productList.size()>=result) {
                System.out.println(productList.get(result-1).getMyInfo());
            } else {
                break;
            }
        }
    }
}
