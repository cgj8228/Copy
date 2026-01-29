package commerce.Challenge3;

public class Customer {
    private String name = "giljung";
    private String email = "choil8228@gmail.com";
    private CustomerGrade grade = CustomerGrade.SILVER; // [수정] String -> Enum

    public String getName() { return name; }
    public String getEmail() { return email; }
    public CustomerGrade getGrade() { return grade; }
}
