package yeonji.submit09;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductMain {
    public static void main(String[] args) {
        Product fre = new Product("냉장고",2000000 );
        Product air = new Product("에어컨",800000 );
        Product tv = new Product("TV",1000000 );
        Product com = new Product("컴퓨터",1300000 );
        Product cir = new Product("선풍기",100000 );


        ArrayList<Product> proList = new ArrayList<>();
        proList.add(fre);
        proList.add(air);
        proList.add(tv);
        proList.add(com);
        proList.add(cir);

//        System.out.println(proList);

        System.out.println("\n=====================\n");


        // 람다식 정렬(오름차순)
        Collections.sort(proList, (o1, o2) -> o1.getPrice() - o2.getPrice());
        for(int i = 0; i < proList.size(); i++){
            System.out.println(proList.get(i));
        }



        // for문으로 순회하면서 담겨져 있는 객체의 이름이 TV인 경우 인덱스 출력
        for (int i = 0; i < proList.size(); i++) {
            if (proList.get(i).getName().equals("TV")) {
                System.out.println(i);
            }
        }
        System.out.println(proList.contains(tv));
        System.out.println(proList.indexOf(tv));

        Product tel = new Product("TV", 1000000);
        System.out.println(tv);
        System.out.println(tel);

        System.out.println(proList.contains(tel)); // false, contains,indexOf는 컴퓨터가 메모리를 저장하는 방식에 따라 딱히 도움이 안됨
        System.out.println(proList.indexOf(tel)); // -1

        proList.add(new Product("커피머신",300000));
//        proList.contains()


    }
}

