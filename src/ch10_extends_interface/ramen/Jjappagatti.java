package ch10_extends_interface.ramen;

public class Jjappagatti extends Ramen{


    public Jjappagatti(String name, int price, String company) {
        super(name,price,company);
    }

    @Override
    public void printRecipe(){
        System.out.println("끓는 물에 면과 건더기를 넣고 3분간 끓인 후 물을 버리고 스프를 넣어 비벼드세요.");
    }
}
