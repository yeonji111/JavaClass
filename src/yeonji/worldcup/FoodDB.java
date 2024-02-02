package yeonji.worldcup;

import java.util.ArrayList;
import java.util.Scanner;

/* 리스트에 음식들 담는 싱글톤 클래스, 게임 실행 메소드 작성 */

public class FoodDB {

    // foodList 에 음식들 담기
    ArrayList<Food> foodList = new ArrayList<>();

    private FoodDB() {
        foodList.add(new Food("짜장면"));
        foodList.add(new Food("짬뽕"));
        foodList.add(new Food("볶음밥"));
        foodList.add(new Food("김치찌개"));
        foodList.add(new Food("제육볶음"));
        foodList.add(new Food("돈까스"));
        foodList.add(new Food("카레"));
        foodList.add(new Food("김밥/라면"));
        foodList.add(new Food("순대국밥"));
        foodList.add(new Food("냉면"));
        foodList.add(new Food("삼겹살"));
        foodList.add(new Food("생선구이"));
        foodList.add(new Food("햄버거"));
        foodList.add(new Food("떡볶이"));
        foodList.add(new Food("소고기국밥"));
        foodList.add(new Food("시래기"));
    }

    private static FoodDB intstnace = new FoodDB();

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    public static FoodDB getIntstnace() {
        return intstnace;
    }

    public static void setIntstnace(FoodDB intstnace) {
        FoodDB.intstnace = intstnace;
    }


    // 게임 메소드
    public void playGame(int num) {

        while (foodList.size() > 0) {
            Scanner scan = new Scanner(System.in);

            if (foodList.size() % 4 == 0) {
                System.out.println(foodList.size() + "강");

            } else if (foodList.size() == 1) {
                // todo 리스트에 하나 남았을때, 남은 데이터를 출력하고 우승 메세지 띄우기 + 종료하기
                System.out.println("결승");
                System.out.println(foodList.get(0).getFoodName() + " 우승!!");
                break;

            }
            for (int i = 0; i < foodList.size(); i++) {

                System.out.println("1. " + foodList.get(i).getFoodName()
                        + " | " + "2. " + foodList.get(i + 1).getFoodName());
                System.out.print(">>>  ");

                int select = Integer.parseInt(scan.nextLine());

                if (select == 1) {
                    foodList.remove(foodList.get(i + 1));
                } else if (select == 2) {
                    foodList.remove(foodList.get(i));
                }
            }
        }
    }
}
