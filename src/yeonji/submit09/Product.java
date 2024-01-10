package yeonji.submit09;

public class Product {
// 필드 변수 선언
String name;
int price;


 // 아무것도 입력안해도 되는 거
    public Product(){}
    @Override
    public String toString() {
        return "Product{" +
                "Name='" + name + '\'' +
                ", Price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
