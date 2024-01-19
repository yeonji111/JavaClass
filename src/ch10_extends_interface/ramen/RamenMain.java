package ch10_extends_interface.ramen;

public class RamenMain {

    public static void main(String[] args) {
        Samyang samyang = new Samyang("삼양라면",900,"삼양");
        samyang.printRecipe();


        Jjappagatti jp = new Jjappagatti("짜파게티",1000,"농심");
        jp.printRecipe();


    }
}
