package ch05_control;

import java.util.Scanner;

public class LoopWhile {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        // while문은 소괄호 내 조건이 true이면
        // 조건이 false가 될때까지 중괄호 내부 코드를 반복 실행
        int i = 1; // 초기화식
        while (i <= 10) { // 조건식
            System.out.println(i);
            i++; // 증감식
        }

        // for문 while문처럼 사용하기
        int k = 1; // 초기화식
        for (; k <= 10; ) {
            System.out.println(k);
            k++;
        }



        System.out.println("\n====================================\n");


        // 둘 다 반복문이지만
        // for문은 반복횟수가 정해진, 뚜렷한 경우에 사용하는 편
        // while문은 반복횟수가 애매한 경우에 사용하면 좋음





        // 채팅을 하는데 Q를 입력하기 전까지 채팅을 한다.
        // [Q를 입력하면 채팅 종료]
        Scanner scan = new Scanner(System.in);


        // while을 사용한 첫번째 방법!!!!!!!!!!!!!!!!!!!!!!!!
//        boolean isChat = true; // 초기화식
//
//        while (isChat){ // 조건식
//            System.out.print("채팅 입력: ");
//            String input = scan.nextLine();
//
//            if (input.equals("q")){
//                isChat = false;
//            }
//            System.out.println(input);
//
//        }




        // while을 사용한 두번째 방법!!!!!!!!!!!!!!!!!!!!!!!!
//        while (true){
//            System.out.print("채팅 입력: ");
//            String input = scan.nextLine();
//
//            if(input.equals("q")){
//                break; // while문 또한 break 실행 시 바로 반복문이 종료된다.
//            }
//            System.out.println(input);
//        }




        // do-while문
        // 반복해야할 내용이 최소 한번은 무조건 실행되게 하고 싶을때 사용
        // (굳이 몰라도 된다.)

//        String input = "";
//        do{
//            System.out.println("채팅 입력: ");
//            input = scan.nextLine();
//            System.out.println(input);
//        }while(!input.equals("q"));

        System.out.println("\n===============================\n");

        // while문 다중 사용

        // 포켓몬스터
        int hp = 100; // 파이리의 체력


        while (true){
            System.out.println("야생의 파이리를 만났다");
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 공격 | 2. 도망");
            System.out.println(">>>>>>>>>");

            int command = Integer.parseInt(scan.nextLine());


            if (command == 1) {
                // TODO 공격

                // 바깥 while문에 outer라는 네임태그 부여
               outer: while (true) {
                    System.out.println("공격 방법 선택");
                    System.out.println("1. 백만볼트  | 2. 전광석화 | 3. 취소");
                    System.out.println(">>>>");

                    int attack = Integer.parseInt(scan.nextLine());
                    if (attack == 1) {
                        System.out.println("피카츄 백만볼트");
                        hp -= 40;

                    } else if (attack == 2) {
                        System.out.println("피카츄 전광석화");
                        hp -= 20;

                    }
                    System.out.println("파이리 체력: " + hp);  // attack에 1,2 둘 다 중복되는 코드이므로 바깥에 선언
                    if (hp <= 0) {
                        System.out.println("전투에서 승리");

                        // 프로그램 종료
                        System.exit(0);


                        // 외부 while문에 네임태그 설정
//                        break outer; // outer라는 이름을 가진 while문 즉시종료

                    } else if (attack == 3) {
                        System.out.println("전투를 취소한다.");
                        // 가까운 반복문 1개를 즉시 종료
                        break; // 내부 공격 while문만 종료된다.
                    }
                }
            } else if (command == 2) {
                //  도망
                System.out.println("도망쳤습니다");
                break;


            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
