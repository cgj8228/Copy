package commerce.test;

public enum CustomerGrade {
    BRONZE("BRONZE", 0),
    SILVER("SILVER", 5),
    GOLD("GOLD", 10),
    PLATINUM("PLATINUM", 15);

    private final String gradeName;
    private final int discountRate;

    CustomerGrade(String gradeName, int discountRate) {
        this.gradeName = gradeName;
        this.discountRate = discountRate;
    }

    public String getGradeName() {
        return gradeName;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int applyDiscount(int originalAmount) {
        return originalAmount - (originalAmount * discountRate / 100);
    }

    public int getDiscountAmount(int originalAmount) {
        return originalAmount * discountRate / 100;
    }

    public static void displayGrades() {
        System.out.println("고객 등급을 입력해주세요.");
        for (int i = 0; i < CustomerGrade.values().length; i++) {
            CustomerGrade grade = CustomerGrade.values()[i];
            System.out.println((i + 1) + ". " + grade.getGradeName() + "   : " +
                    String.format("%2d", grade.getDiscountRate()) + "% 할인");
        }
    }

    public static CustomerGrade getGradeByIndex(int index) {
        if (index >= 1 && index <= CustomerGrade.values().length) {
            return CustomerGrade.values()[index - 1];
        }
        return null;
    }
}
