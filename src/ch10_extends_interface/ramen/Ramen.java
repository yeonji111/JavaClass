package ch10_extends_interface.ramen;

// 추상 메소드를 하나라도 가지고 있는 클래스는
// abstract를 추가 해줘야한다.
public abstract class Ramen {
    String name;
    int price;
    String company;

    public Ramen(String name, int price, String company) {
        this.name = name;
        this.price = price;
        this.company = company;
    }

    // Ramen을 상속받는 객체들은 printRecipe 메소드가 존재한다.
    // 추상 메소드로 구현
    public abstract void printRecipe();



}
