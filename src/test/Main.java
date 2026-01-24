package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();


        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        productList.add(new Product("Galaxy S25", 1200000,"최신 안드로이드 스마트폰",50));
        productList.add(new Product("iPhone 16", 110000,"최신 안드로이드 스마트폰",50));
        productList.add(new Product("MacBook Pro", 10000,"최신 안드로이드 스마트폰",50));
        productList.add(new Product("AirPods Pro", 9000,"최신 안드로이드 스마트폰",50));

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
