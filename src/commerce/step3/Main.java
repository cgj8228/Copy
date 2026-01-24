package commerce.step3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Category> categoryList = createCategory();
        CommerceSystem commerceSystem = new CommerceSystem(createCategory());
        commerceSystem.start();
    }

    public static List<Category> createCategory(){
        List<Category> categoryList = new ArrayList<>();

        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("Galaxy S24", 1200000, "최신 스마트폰", 50));
        productList.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
        productList.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        productList.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50));
        categoryList.add(new Category(productList,"전자제품"));

        List<Product> productList2 = new ArrayList<Product>();
        productList2.add(new Product( "아디다스 아디제로 EVO SL", 135000, "아디다스 러닝화", 40));
        productList2.add(new Product( "아식스 노바블라스트 5", 159000, "아식스 러닝화", 24));
        productList2.add(new Product( "나이키 줌 플라이 6", 137000, "나이키 러닝화", 60));
        productList2.add(new Product( "뉴발란스 퓨어셀 슈퍼컴프 엘리트V4", 274000, "뉴발란스 러닝화", 50));
        categoryList.add(new Category(productList2,"의류"));

        List<Product> productList3 = new ArrayList<Product>();
        productList3.add(new Product( "프로틴바", 2500, "단백질 간식", 200));
        productList3.add(new Product( "스테비아 대추방울토마토 2Kg", 23900, "달콤한 토마토", 12));
        productList3.add(new Product( "펩시 제로슈거 라임향1.5L", 1900, "제로 칼로리 탄산음료", 1000));
        productList3.add(new Product("라라스윗 초콜릿 아이스크림474ml", 8290, "저칼로리 아이스크림", 120));
        categoryList.add(new Category(productList3,"식품"));

        return categoryList;
    }
}