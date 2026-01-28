package commerce.test1;

import java.util.Scanner;

public class ManagerMode {
    private String passWord = "456";


    public void managerLogin(){
        Scanner sc = new Scanner(System.in);
        Integer count = 0;

        while(true) {
            System.out.println("관리자 비밀번호를 입력해주세요: ");

            if (count == 3) {
                return;
            } // 3번 틀리면 아웃

            String input = sc.nextLine();
            if (passWord.equals(input)) {
                // 다음 메서드 집어 넣고 진행
            } else {
                count++;
            }
        }
    }
}
