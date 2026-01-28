package commerce.test;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    // 필드
    Scanner sc = new Scanner(System.in);
    private List<Category> categoryList;

    // 생성자
    public CommerceSystem(List<Category> categoryList){
        this.categoryList = categoryList;
    }

    // 메인 화면
    public void start(){
        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (Integer index = 0; index < categoryList.size(); index++) {
                System.out.println(index + 1 + ". " + categoryList.get(index).getName());
            }

            Integer result = sc.nextInt(); // 카테고리 선택
            
            // 카테고리 제품 들어가기 선택
            if (result>0 && categoryList.size()+1 >= result){
                categoryList.get(result-1).start();
            }else {
                break;
            }

            // 몇개를 장바구니에 담을건지 물어봐야겠지? 그리고 장바구니에 넣어야겠지?
        }
    }
}
