package test;

import java.util.List;
import java.util.Scanner;

public class Category {
    private List<Product> productList;
    private String name;

    public Category(List<Product> productList, String name){
        this.productList=productList;
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    // 카테고리 제품 출력
    public void start(){
            Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("[ " + this.name + " 카테고리 ]");
            for (Integer index = 0; productList.size() > index; index++) {
                System.out.println(index + 1 + ". " + productList.get(index).getMySimpleInfo());
            }

            Integer result = 0;
            System.out.println("0. 뒤로가기");
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
