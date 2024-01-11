package yeonji.submit09;

import ch09_class.common.MyUtil;
import jdk.management.jfr.FlightRecorderMXBean;

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

        // 미끼의 개수가 10개라고 하고, 1번 낚시하기를 할때마다
        // 미끼가 하나씩 소모되면서 갯수가 콘솔창에 출력되고,
        // 미끼가 0개라면 더이상 1번 낚시하기를 할 수 없다.
        int limit = 10;
        // 1번 낚시하기를 할때, 10% 확률로 낚시대가 부러져서
        // 더이상 1번 낚시하기를 할 수 없도록 코드 추가
        boolean isBroken = false;

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println(1 + ". " + "낚시하기" + " | " + 2 + ". 잡은 물고기 목록" + " | " + 3 + ". " + "떠나기");
            System.out.println(">>> ");

            int select = Integer.parseInt(scan.nextLine());

            if (select == 1) {
                // todo 낚시하기 / fishList 중 랜덤한 하나의 물고기를 잡아 fishBag에 저장

                if (isBroken == true){
                    System.out.println("낚시대가 부러진 상태입니다.");
                    continue;
                }
                // 미끼가 0개면 못하게 함
                if (limit == 0) {
                    System.out.println("미끼가 부족합니다.");
                    continue;
                }

                // 10% 확률로 낚시대를 부러트림
                int fail = (int) (Math.random() * 10) + 1;
                if (fail == 1) {
                    System.out.println("낚시대가 부러졌습니다.");
                    isBroken = true;
                    continue;
                }

                // fishList의 인덱스는 0~6까지 존재
                // 랜덤 숫자의 범위 0~6 설정

                /* 다금바리 5% 확률
                // 농성어 10% 확률
                // 돌돔 15%, 참돔 15%, 우럭 15%, 광어 15% 확률
                // 고등어 25% 확률로 잡히도록 코드 수정 fishList에 백마리만들어서 무식하게 다 때려넣어?


                // 1~100 사이의 랜덤 숫자를 뽑고
                // 물고기의 확률 적용
                //int rnad = MyUtil.randomNum(1,100);
                int idx = 0;

                if (rand <= 5){
                    // 다금바리 잡음
                    idx = 6;
                } else if (5 < rand && rand <= 15) {
                    // 능성어
                    idx = 5;
                } else if (rand <= 30){
                    // 돌돔
                    idx = 4;
                } else if (rand <= 45) {
                    // 참돔
                    idx = 3;
                } else if (rand <= 60) {
                    // 우럭
                    idx = 2;
                } else if (rand <= 75) {
                    // 광어
                    idx = 1;
                } else {
                    // 고등어}
                }
                System.out.println(fishList.get(idx).getFishName() + "을 잡았다.");

*/

                int rand = MyUtil.randomNum(0, 6);


                fishList.get(rand);
                fishBag.add(fishList.get(rand));

                limit--;
                System.out.println("총 남은 미끼의 수: " + limit);
                System.out.println(fishList.get(rand).getFishName() + "을 잡았다!!");

            } else if (select == 2) {
                // todo 잡은 물고기 목록 보기 / 잡은 물고기의 목록과 가격합산

                int price = 0;

//                System.out.println(fishBag); // 가격 확인용 , 합산할때 맞는지 보려고
                System.out.println("내 가방 =============");
                for (int j = 0; j < fishBag.size(); j++) {
                    String getFish = fishBag.get(j).getFishName();
                    price += fishBag.get(j).getFishPrice();
                    System.out.println("[" + getFish + ", 가치: " + fishBag.get(j).getFishPrice() + "]");
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





