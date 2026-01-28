package commerce.Challenge1;

public class Product {
    private String name;
    private Integer price;
    private String description;
    private Integer count;

    public Product(String name, Integer price, String description, Integer count){
        this.name = name;
        this.price = price;
        this.description = description;
        this.count = count;
    }

    public String getName() {return this.name;}
    public Integer getPrice(){return this.price;}
    public String getDescription(){return this.description;}
    public Integer getCount(){return this.count;}

    public String getMySimpleInfo(){
        return this.name + " | " + this.price + " | " + this.description;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMyInfo(){
        return this.name + " | " + this.price + " | " + this.description+ " | " +this.count;
    }
}
