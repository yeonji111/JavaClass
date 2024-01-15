package yeonji.semi;


import java.util.Scanner;

public class Archaeology {
    public static void main(String[] args) {
        // todo 로그인
        Scanner scan = new Scanner(System.in);
//        while (true) {
//            System.out.println("ID: ");
//            System.out.println(">>>  ");
//            String id = scan.nextLine();
//
//            System.out.println("PW: ");
//            System.out.println(">>>  ");
//            String pw = scan.nextLine();
//
//            Member login = memList.signIn(id, pw);
//            if (login != null) {
//                System.out.println("로그인 성공");
//                System.out.println(login.getMemName() + "님 환영합니다.");


        while (true) {
            // todo 고고학
            int inventory = 0;
            boolean leftLife = true;
            int limit = 20;
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 고고학 하기 | 2. 인벤토리 확인하기 | 3. 판매하기 | 4. 강화하기 | 5. 로그아웃");
            System.out.println(">>> ");

            int select = Integer.parseInt(scan.nextLine());
            // todo 1번

            int itemNum = 0;
            itemNum = (int) (Math.random() * 101) + 200; // 빛바랜 조각 200~300 사이

//            while (leftLife == true){
            if (select == 1) {
                // todo 회당 1을 소진하는 사이클 만들기
                //  회당 빛바랜 조각 200~300 랜덤 획득하는 코드
                //  획득할때마다 성공 등급 안내 (200~270 '성공', 271~300이면 '대성공' 메시지 출력)
                // todo 남은 생활의 기운 출력하기

                if (leftLife = true) {
                    if (itemNum >= 200 && itemNum <= 270) {
                        limit -= 1;
                        System.out.println("성공!");
                        System.out.println(itemNum + "개를 획득하였습니다.");
//                        System.out.println("남은 생활의 기운: " + limit);

                    }
                   else if (270 < itemNum && itemNum <= 300) {
                        limit -= 1;
                        System.out.println("대성공!!");
                        System.out.println(itemNum + "개를 획득하였습니다.");
//                        System.out.println("남은 생활의 기운: " + limit);

                    }

                    if (limit == 0) {
                        leftLife = false;

                    }
                    System.out.println("남은 생활의 기운: " + limit);
                }
                if (leftLife == false) {
                    System.out.println("남은 생활의 기운이 없습니다.");
                }


            }

            System.out.println("남은 생활의 기운: " + limit);

            if (select == 2) {
                // todo 인벤토리 확인하기 ( 빛바랜 조각, 골드 )


            }

            if (select == 3) {
                // todo 아이템 판매하기
                // todo 남은 빛바랜 조각 갯수와 가지고 있는 골드 재화 출력


            }
            if (select == 4) {
                // todo 강화하기


            }

            if (select == 5) {
                // todo 로그아웃


            }


        }

    }
}


//    }
//}
