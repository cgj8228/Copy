package commerce.step2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();


        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        productList.add(new Product("Galaxy S25", 1200000,"최신 안드로이드 스마트폰",50));
        productList.add(new Product("iPhone 16", 110000,"최신 안드로이드 스마트폰",50));
        productList.add(new Product("MacBook Pro", 10000,"최신 안드로이드 스마트폰",50));
        productList.add(new Product("AirPods Pro", 9000,"최신 안드로이드 스마트폰",50));

        CommerceSystem commerceSystem = new CommerceSystem(productList);

        commerceSystem.start();
    }
}
