package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Category> categoryList; // new ArrayList()<> 초기값 필요없음, 카테고리로 받으면 제품을 못받지 않나?

    public CommerceSystem(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    // 메인 커머스 시스템
    public void start() {
        while (true) {

            Scanner sc = new Scanner(System.in);

            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (Integer index = 0; categoryList.size() > index; index++) { // 제품 출력
                System.out.println(index + 1 + ". " + categoryList.get(index).getName());
            }
            System.out.println("0. 종료           | 프로그램 종료");

            Integer result = sc.nextInt();

            if (result > 0 && categoryList.size()>=result){ // 번호 입력시 필터링
                categoryList.get(result-1).start(); // 입력한 카테고리로 이동
            }else {
                break;
            }
        }
    }
}
