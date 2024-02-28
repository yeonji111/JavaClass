package home;

import java.util.Scanner;

public class ControlUpgrade {
    public static void main(String[] args) {
        int iniA = 10;
        int iniB = 4;
        Scanner scan = new Scanner(System.in);


        while(true){
            System.out.println("\n============ 희영빌딩 엘리베이터 ============\n");
            System.out.println("승강기 A의 현재 위치: " + iniA +"층");
            System.out.println("승강기 B의 현재 위치: " + iniB +"층");
            System.out.print("몇층에 계신가요?[종료하시려면 q 또는 exit 입력]: ");
            String sta = scan.nextLine();
            if(sta.equals("q") || sta.equals("exit")){
                System.out.println("프로그램이 종료되었습니다.");
                break;
            }

            int userStatus = Integer.parseInt(sta);
            System.out.println(userStatus + "층에서 엘리베이터를 호출합니다.");

            if(Math.abs(iniA - userStatus) > Math.abs(iniB - userStatus)){
                // 승강기B가 더 가까워서 B를 움직이는 코드
                iniB = userStatus;
                System.out.println("승강기 B가 "+iniB+"층으로 이동하였습니다. ");
            } else {
                // 승강기A가 더 가까워서 A를 움직이는 코드
                iniA = userStatus;
                System.out.println("승강기 A가 "+iniA+"층으로 이동하였습니다. ");
            }
        }



    }
}
