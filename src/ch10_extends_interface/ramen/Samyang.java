package ch10_extends_interface.ramen;

public class Samyang extends Ramen{

    public Samyang(String name, int price, String company) {
        super(name, price, company);
    }

    @Override
    public void printRecipe() {
        System.out.println("끓는물에 분말스프와 건더기를 넣고 3분간 익혀드세요.");
    }
}
