package yeonji.submit09;


public class Product {
    // 클래스 국룰 4개
    // 1. 필드변수 private

    private String name;     /* 제품명 */
    private int price;       /* 제품 가격 */




    // 2. 기본생성자와 풀생성자 만들기
    public Product() {}

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 3. toString 만들기
    @Override
    public String toString() {
        return "Product{" +
                "Name='" + name + '\'' +
                ", Price=" + price +
                '}';
    }

    // 4. Getter and Setter 만들기
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
