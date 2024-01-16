package yeonji.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        // todo 게임 설명 출력

        System.out.println("어서오세요. 미니게임에 오신걸 환영합니다.");
        System.out.println();


        System.out.println();
        System.out.println("원하는 카테고리를 선택해주세요");
        System.out.println("1. 게임 플레이 | 2. 랭킹 보기");
        int input = Integer.parseInt(scan.nextLine());

        if (input == 1) {
            System.out.println("플레이어님의 이름을 입력해주세요.");
            System.out.print(">>>   ");
            // 플레이어A 이름 입력받기, 게임 시작& 끝 한세트
            // 플레이어A 기록 정산
            String playerA = scan.nextLine(); /* 플레이어 A */
            System.out.println(playerA + "님 환영합니다.");
            System.out.println("게임을 시작하려면 [엔터키]를 눌러주세요.");
            scan.nextLine();
            System.out.println(playerA + "님의 기록 측정을 시작합니다.");


            long beforeA = System.currentTimeMillis();

            System.out.println("기록 측정을 중단하고 싶으시면 [엔터키]를 눌러주세요");
            scan.nextLine();
            System.out.println();
            long afterA = System.currentTimeMillis();

            long diffA = afterA - beforeA;
            System.out.println(diffA / 1000.0 + "초 경과했습니다.");


            // 기준이랑 얼마나 차이나는지?
            float resultA = (float) Math.abs(10.000 - (diffA / 1000.0)); //
            System.out.println("===============" + "플레이어 " + playerA + "님의 결과===============");
            System.out.println("10초보다 " + resultA + "초 차이 납니다!!");
            System.out.println("====================================================");


            // 플레이어B 이름 입력받기, 게임 시작 & 끝 한세트
            // 플레이어B 기록 정산

            System.out.println("새로운 플레이어님의 이름을 입력해주세요.");
            System.out.print(">>>   ");
            String playerB = scan.nextLine(); /* 플레이어 B */
            System.out.println(playerB + "님 환영합니다.");
            System.out.println("게임을 시작하려면 [엔터키]를 눌러주세요.");
            scan.nextLine();
            System.out.println(playerB + "님의 기록 측정을 시작합니다.");


            long beforeB = System.currentTimeMillis();

            System.out.println("기록 측정을 중단하고 싶으시면 [엔터키]를 눌러주세요");
            scan.nextLine();
            System.out.println();
            long afterB = System.currentTimeMillis();

            long diffB = afterB - beforeB;
            System.out.println(diffB / 1000.0 + "초 경과했습니다.");


            // 기준이랑 얼마나 차이나는지?
            float resultB = (float) Math.abs(10.000 - (diffB / 1000.0)); //
            System.out.println("===============" + "플레이어 " + playerB + "님의 결과===============");
            System.out.println("10초보다 " + resultB + "초 차이 납니다!!");
            System.out.println("====================================================");


            // todo 플레이어 A와 B의 기록 비교 & 대결 결과 출력
            if (resultA < resultB) { // 플레이어A가 이겼을 경우
                System.out.println("플레이어 " + playerA + "님의 승리!!");
            } else if (resultA > resultB) {
                System.out.println("플레이어 " + playerB + "님의 승리!!");// 플레이어B가 이겼을 경우
            }

            // todo 플레이어 A,B의 기록 recordDB 생성 후 저장
            HashMap<String, Float> recordMap = new HashMap<String, Float>();
            recordMap.put(playerA, resultA);
            recordMap.put(playerB, resultB);

            System.out.println(recordMap.get(playerA)+recordMap.get(resultA));
            System.out.println(recordMap.get(playerB)+recordMap.get(resultB));

        }

        if(input == 2){
            // todo 랭킹 조회



        }




    }
}
