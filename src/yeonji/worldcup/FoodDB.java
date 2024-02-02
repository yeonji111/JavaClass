package yeonji.worldcup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 리스트에 음식들 담는 싱글톤 클래스, 게임 실행 메소드 작성 */

public class FoodDB {

    // foodList 에 음식들 담기
    private ArrayList<Food> foodList = new ArrayList<>();

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
    public void playGame() {
        // todo foodList 에 데이터를 추가해서 16강 이상의 이상형 월드컵으로 사용할때 쓸 수 있는 메소드로 만들기
        //  (많은 데이터가 있으면 파라미터로 입력받는 num 강 이상형 월드컵 게임이 될 수 있도록 하기)

        Scanner scan = new Scanner(System.in);
//        boolean isDuple = false;
        ArrayList<Food> gameList = new ArrayList<>();
        // todo foodList 에서 랜덤으로 파라미터로 들어온 변수값만큼 뽑기
        Collections.shuffle(foodList);

        System.out.println("======= 음식 이상형 월드컵 =======");

        while (foodList.size() > 0) {

            if (foodList.size() % 4 == 0) {
                System.out.println(foodList.size() + "강");

            } else if (foodList.size() == 1) {
                // 리스트에 하나 남았을때, 남은 데이터를 출력하고 우승 메세지 띄우기 + 종료하기
                System.out.println("결승");
                System.out.println(foodList.get(0).getFoodName() + " 우승!!");
                break;
            }

            for (int i = 0; i < foodList.size(); i++) {
                System.out.println("메뉴를 선택해주세요");
                System.out.println("1. " + foodList.get(i).getFoodName()
                        + " | " + "2. " + foodList.get(i + 1).getFoodName());
                System.out.print(">>>  ");

                int select = Integer.parseInt(scan.nextLine());

                // todo select 에 1이나 2가 아닌 값이 들어온 경우 다시 재출력
                // todo 해결법을 모르겠어서 그냥 프로그램 강제종료로 마무리 지었는데 좀 더 찾아보고 질문할것
                if (select != 1 && select != 2) {
                    System.out.println("다시 선택해주세요.");
                    return;

                } else if (select == 1) {
                    foodList.remove(foodList.get(i + 1));
                } else if (select == 2) {
                    foodList.remove(foodList.get(i));
                }
            }
        }
    }
}
