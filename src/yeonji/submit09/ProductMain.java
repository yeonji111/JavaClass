package yeonji.submit09;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductMain {
    public static void main(String[] args) {
        Product fre = new Product();
        fre.name = "냉장고";
        fre.price = 2000000;


        Product air = new Product();
        air.name = "에어컨";
        air.price = 800000;


        Product tv = new Product();
        tv.name = "TV";
        tv.price = 1000000;

        Product comp = new Product();
        comp.name = "컴퓨터";
        comp.price = 1300000;

        Product cir = new Product();
        cir.name = "선풍기";
        cir.price = 100000;

        ArrayList<Product> proList = new ArrayList<>();
        proList.add(fre);
        proList.add(air);
        proList.add(tv);
        proList.add(comp);
        proList.add(cir);

//        System.out.println(proList);

        System.out.println("\n=====================\n");

        // 가격별로 정렬
        Collections.sort(proList, new Comparator<Product>() {
            @Override
            public int compare(Product proA, Product proB) {
                int result = 1; // proB가 더 큰 경우
                if (proA.getPrice() - proB.getPrice() < 0) { // proA가 더 큰 경우
                    result = -1;
                }
                return result;
            }
        });

        for (int i = 0; i < proList.size(); i++) {
            System.out.println(proList.get(i));
        }

        // for문으로 순회하면서 담겨져 있는 객체의 이름이 TV인 경우 인덱스 출력
        for (int i = 0; i < proList.size(); i++) {
            if (proList.get(i).getName().equals("TV")) {
                System.out.println(i);
            }
        }

    }
}

