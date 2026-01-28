package commerce.step3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Category {
    private List<Product> productList;
    private String name;


    public Category(List<Product> productList, String name){
        this.productList = productList;
        this.name = name;
    }


    public String getName() {
        return this.name=name;
    }

    public void start(){
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
        }
    }
}
