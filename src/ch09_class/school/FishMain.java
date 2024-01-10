package ch09_class.school;

import java.util.ArrayList;
import java.util.Scanner;

public class FishMain {
    public static void main(String[] args) {

        ArrayList<Fish> fishList = new ArrayList<>();

        fishList.add(new Fish("고등어", 5000));
        fishList.add(new Fish("광어", 25000));
        fishList.add(new Fish("우럭", 27000));
        fishList.add(new Fish("참돔", 30000));
        fishList.add(new Fish("돌돔", 35000));
        fishList.add(new Fish("능성어", 7000));
        fishList.add(new Fish("다금바리", 120000));

//        System.out.println(fishList);
        Scanner scan = new Scanner(System.in);

        // 잡은 물고기를 담을 가방
        ArrayList<Fish> fishBag = new ArrayList<>();

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println(1 + ". " + "낚시하기" + " | " + 2 + ". 잡은 물고기 목록" + " | " + 3 + ". " + "떠나기");
            System.out.println(">>> ");

            int select = Integer.parseInt(scan.nextLine());

            if (select == 1) {
                int rand = 0;
                // todo 낚시하기 / fishList 중 랜덤한 하나의 물고기를 잡아 fishBag에 저장
//               for (int i = 0; i < fishList.size(); i++){
                rand = (int) (Math.random() * (fishList.size()));
                fishList.get(rand);
                fishBag.add(fishList.get(rand));
//               }
                System.out.println(fishList.get(rand).getFishName() + "을 잡았다!!");

            } else if (select == 2) {
                // todo 잡은 물고기 목록 보기 / 잡은 물고기의 목록과 가격합산

                int price = 0;
                for (int i = 0; i < fishBag.size(); i++) {
                    price += fishBag.get(i).getFishPrice();
                }
//                System.out.println(fishBag); // 가격 확인용 , 합산할때 맞는지 보려고
                System.out.println("내 가방 =============");
                for (int j = 0; j < fishBag.size(); j++){
                    String getFish = fishBag.get(j).getFishName();
                    System.out.println("[" +getFish+", 가치: "+fishBag.get(j).getFishPrice() +"]");
                }
                System.out.println("총 " + price + "원 ============");
            } else if (select == 3) {
                // todo 중료
                break;
            }
            System.out.println();
        }
    }
}





