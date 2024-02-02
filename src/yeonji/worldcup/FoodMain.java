package yeonji.worldcup;

import java.util.ArrayList;
import java.util.Scanner;

    /* 추가해야하는 것
    1) 음식 리스트 클래스(FoodDB)
    2) 게임 돌리는 메소드(FoodDB.playGame) */

public class FoodMain {
    public static void main(String[] args) {

        FoodDB foodDB = FoodDB.getIntstnace();

        Scanner scan = new Scanner(System.in);

        foodDB.playGame();





        // 리스트를 하나씩 넣는 것도 너무 길고,
        // 중복되는 코드들이 너무 많기 때문에 클래스와 메소드화 하기

//        ArrayList<String> foodList = new ArrayList<>();
//        foodList.add("짜장면");
//        foodList.add("짬뽕");
//        foodList.add("볶음밥");
//        foodList.add("김치찌개");
//        foodList.add("제육볶음");
//        foodList.add("돈까스");
//        foodList.add("카레");
//        foodList.add("김밥/라면");
//        foodList.add("순대국밥");
//        foodList.add("냉면");
//        foodList.add("삼겹살");
//        foodList.add("생선구이");
//        foodList.add("햄버거");
//        foodList.add("떡볶이");
//        foodList.add("소고기국밥");
//        foodList.add("시래기");
//
//        int select = 0;
//
//
//        if (foodList.size() == 16) {
//            System.out.println("16강");
//            System.out.println("메뉴를 선택해주세요");
//
//
//            for (int i = 0; i < foodList.size(); i++) {
//                System.out.println("1. " + foodList.get(i)
//                        + " | " + "2. " + foodList.get(i + 1));
//                System.out.print(">>>  ");
//                select = Integer.parseInt(scan.nextLine());
//
//                if (select == 1) {
//                    foodList.remove(foodList.get(i + 1));
//                } else if (select == 2) {
//                    foodList.remove(foodList.get(i));
//                }
////                System.out.println(foodList);
//            }
//
//
//            if (foodList.size() == 8) {
//                System.out.println("8강");
//                System.out.println("메뉴를 선택해주세요");
//
//                for (int i = 0; i < foodList.size(); i++) {
//                    System.out.println("1. " + foodList.get(i)
//                            + " | " + "2. " + foodList.get(i + 1));
//                    System.out.print(">>>  ");
//                    select = Integer.parseInt(scan.nextLine());
//
//                    if (select == 1) {
//                        foodList.remove(foodList.get(i + 1));
//                    } else if (select == 2) {
//                        foodList.remove(foodList.get(i));
//                    }
////                    System.out.println(foodList);
//                }
//            }
//            if (foodList.size() == 4) {
//                System.out.println("4강");
//                System.out.println("메뉴를 선택해주세요");
//
//                for (int i = 0; i < foodList.size(); i++) {
//                    System.out.println("1. " + foodList.get(i)
//                            + " | " + "2. " + foodList.get(i + 1));
//                    System.out.print(">>>  ");
//                    select = Integer.parseInt(scan.nextLine());
//
//                    if (select == 1) {
//                        foodList.remove(foodList.get(i + 1));
//                    } else if (select == 2) {
//                        foodList.remove(foodList.get(i));
//                    }
////                    System.out.println(foodList);
//                }
//            }
//            if (foodList.size() == 2) {
//                System.out.println("결승");
//                System.out.println("메뉴를 선택해주세요");
//
//                for (int i = 0; i < foodList.size(); i++) {
//                    System.out.println("1. " + foodList.get(i)
//                            + " | " + "2. " + foodList.get(i + 1));
//                    System.out.print(">>>  ");
//                    select = Integer.parseInt(scan.nextLine());
//
//                    if (select == 1) {
//                        foodList.remove(foodList.get(i + 1));
//                    } else if (select == 2) {
//                        foodList.remove(foodList.get(i));
//                    }
//                    System.out.println(foodList.get(0) + " 우승!!");
//                }
//
//            }
//
//
//        }


    }


}
