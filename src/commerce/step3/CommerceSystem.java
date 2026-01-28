package commerce.step3;

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


    // 프로그램 시작
    public void start(){
        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (Integer index = 0; index < categoryList.size(); index++) {
                System.out.println(index + 1 + ". " + categoryList.get(index).getName());
            }

            Integer result = sc.nextInt();

            if (result>0 && categoryList.size()+1 >= result){
                categoryList.get(result-1).start();
            }else {
                break;
            }
        }
    }
}
