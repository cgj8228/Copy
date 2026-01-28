package commerce.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    Scanner sc = new Scanner(System.in);
    private String passWord = "456";
    private List<Category> categoryList;
    private Cart cart;

    public Manager(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Manager(List<Category> categoryList, Cart cart, Scanner sc) {
        this.categoryList = categoryList;
        this.cart = cart;
        this.sc = sc;
    }

    public void managerLogin() {
        Integer count = 2;

        while (true) {
            System.out.printf("[잔여 횟수 %d]관리자 비밀번호를 입력해주세요: ",count+1);
            String input = sc.nextLine();
            boolean key = true; // true 진행 false 메인 으로

            if (count.equals(0)) {
                return;
            } // 3번 틀리면 아웃

            if (passWord.equals(input)) {
                    mangerMode();
                    return;
            } else {
                count--;
            }

        }
    }

    // 관리자 페이지 선택
    public void mangerMode() {
        while (true) {
            System.out.println("[ 관리자 모드 ]");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 수정");
            System.out.println("3. 상품 삭제");
            System.out.println("4. 전체 상품 현황");
            System.out.println("0. 메인으로 돌아가기");

            Integer input = sc.nextInt();

            if (input.equals(1)) { // 상품 추가
                System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");
                for (int i = 0; i < categoryList.size(); i++) {
                    System.out.println(i + 1 + ". " + categoryList.get(i).getName()); // 카테고리 출력
                }
                int categoryInput = sc.nextInt(); // 몇 번 카테고리에 들어 갈건지
                sc.nextLine(); // 버퍼 엔터
                Category categorySelect = categoryList.get(categoryInput - 1); // 번호 적은 카테고리를 Select에 넣기
                addManageProduct(categorySelect); // 그 번호의 카테고리에 상품을 추가

            } else if (input.equals(2)) {
                System.out.println("어느 카테고리에 상품을 수정하시겠습니까?");
                for (int i = 0; i < categoryList.size(); i++) {
                    System.out.println(i + 1 + ". " + categoryList.get(i).getName()); // 카테고리 출력
                }
                int categoryInput = sc.nextInt(); // 몇 번 카테고리에 들어 갈건지
                sc.nextLine(); // 버퍼 엔터
                Category categorySelect = categoryList.get(categoryInput - 1); // 번호 적은 카테고리를 Select에 넣기
                ManageProductModification(categorySelect);

            } else if (input.equals(3)) {
                System.out.println("어느 카테고리의 상품을 삭제 하시겠습니까?");
                for (int i = 0; i < categoryList.size(); i++) {
                    System.out.println(i + 1 + ". " + categoryList.get(i).getName()); // 카테고리 출력
                }
                int categoryInput = sc.nextInt(); // 몇 번 카테고리에 들어 갈건지
                sc.nextLine(); // 버퍼 엔터
                Category categorySelect = categoryList.get(categoryInput - 1); // 번호 적은 카테고리를 Select에 넣기
                ManageProductDeletion(categorySelect);

            } else if (input.equals(4)) {
                ManageAllProduct();
            } else if (input.equals(0)) {
                break;
            }
        }
    }

    // 4. 전체 상품 현황
    // 1번 Category 에서 -> ProductList를 출력
    public void ManageAllProduct(){
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println(i + 1 + ". " + categoryList.get(i).getName()); // 카테고리 출력
            for (int j = 0; j<categoryList.get(i).getProductList().size(); j++){
                System.out.println(categoryList.get(i).getProductList().get(j).getMyInfo());
            }
            System.out.println();
        }
    }

    // 3. 상품 삭제
    public void ManageProductDeletion(Category category){
        List<Product> productList = category.getProductList();
        System.out.println("[ " + category.getName() + " 카테고리 상품 목록 ]");
        for (Product product : productList) {
            System.out.println(product.getMyInfo());
        }
        System.out.println("삭제 하실 제품은 몇번 입니까?");
        Integer productInput = sc.nextInt();
        sc.nextLine();
        Product target = productList.get(productInput - 1);

        target.getMyInfo();
        System.out.println("정말 제품을 삭제 하시겠습니까?");
        System.out.println("1. 확인    2. 취소");
        Integer delete = sc.nextInt();
        if(delete.equals(1)){
            // 상품 삭제 코드 작성
            cart.removeProductName(target.getName());
            productList.remove(target);
        } else if (delete.equals(2)) {
            System.out.println("상품 삭제를 취소 합니다.");
            return;
        }
    }
    // 2. 상품 수정
    public void ManageProductModification(Category category) {
        List<Product> productList = category.getProductList();

        System.out.println("[ " + category.getName() + " 카테고리 상품 목록 ]");
        for (Product product : productList) {
            System.out.println(product.getMyInfo());
        }
        System.out.printf("수정 하실 제품은 몇번 입니까?: ");
        Integer productInput = sc.nextInt();
        sc.nextLine();

        Product target = productList.get(productInput - 1);

        System.out.println("수정 항목 선택");
        System.out.println("1. 가격");
        System.out.println("2. 설명");
        System.out.println("3. 재고수량");
        System.out.print("입력: ");

        Integer menu = sc.nextInt();
        sc.nextLine(); // [추가] 버퍼 엔터

        if (menu == 1) {
            System.out.print("새 가격: ");
            Integer newPrice = sc.nextInt();
            sc.nextLine();
            target.setPrice(newPrice); // Product에 setPrice 필요
            System.out.println("가격 수정 완료");

        } else if (menu == 2) {
            System.out.print("새 설명: ");
            String newDesc = sc.nextLine();
            target.setDescription(newDesc); // Product에 setDescription 필요
            System.out.println("설명 수정 완료");

        } else if (menu == 3) {
            System.out.print("새 재고수량: ");
            Integer newCount = sc.nextInt();
            sc.nextLine();
            target.setCount(newCount);
            System.out.println("재고 수정 완료");

        } else if (menu == 0) {
            return;

        } else {
            System.out.println("없는 번호 입니다.");
        }


    }

    // 1. 상품 추가 메서드
    public void addManageProduct(Category category) {
        System.out.printf("상품명: ");
        String name = sc.nextLine();
        // 동일한 상품명
        for (Product product : category.getProductList()){
            if(name.equals(product.getName())){
                System.out.println("동일한 상품명의 상품이 있습니다!!");
                return;
            }
        }

        System.out.printf("가격: ");
        Integer price = sc.nextInt();
        sc.nextLine();

        System.out.printf("설명: ");
        String description = sc.nextLine();

        System.out.printf("수량: ");
        Integer count = sc.nextInt();
        sc.nextLine();

        System.out.printf("\n%s | %,d | %s | 재고: %d개\n", name, price, description, count);
        System.out.println("위 정보로 상품을 추가하시겠습니까?");
        System.out.println("1. 확인    2. 취소");
        Integer check = sc.nextInt();
        if (check.equals(1)) {
            category.getProductList().add(new Product(name, price, description, count));
            System.out.println("상품이 성공적으로 추가되었습니다!");
        } else {
            System.out.println("상품 추가 실패!!");
            return;
        }
    }
}
