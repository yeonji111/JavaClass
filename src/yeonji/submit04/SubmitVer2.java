package yeonji.submit04;

import java.util.Scanner;

public class SubmitVer2 {


    /*

     엘리베이터 A,B문제 푸는데 메모장처럼 쓴 코드가 들어가있는 클래스
    (정답 아님)

     */
    public static void main(String[] args) {

        int elevatorA = 10;
        int elevatorB = 4;

        Scanner scan = new Scanner(System.in);


        while (true){
            System.out.println("엘리베이터 A 위치: " + elevatorA);
            System.out.println("엘리베이터 B 위치: " + elevatorB);
            System.out.println("몇층에 계시나요? : ");
//            int command = Integer.parseInt(scan.nextLine());
            String command = scan.nextLine();
            if (command.equals("q")){
                System.out.println("프로그램이 종료되었습니다.");
                System.exit(0);
            } else if (command.equals("exit")){
                System.out.println("프로그램이 종료되었습니다.");
                System.exit(0);
            }
            int goFloor = Integer.parseInt(command); // 가고 싶은 층
            System.out.println(command +"층에서 엘리베이터를 호출합니다.");

            int comEleA = Math.abs(10 - elevatorA); // elvatorA(10)-command > 5 보다 크면 B 호출
            int comEleB = Math.abs(10 - elevatorB);
//            if (elvatorA - goFloor > 5) // todo goFloor(가고 싶은 층) 과 elevatorA의 차이가 절대값 5이상이 나면 elevatorB가 1층으로 이동 (역도 )
            if (comEleA > 5) {
                System.out.println("승강기 B가"+ goFloor + "층으로 이동하였습니다.");
            }else if (comEleB > 5){
                System.out.println("승강기 A가" + goFloor +"층으로 이동하였습니다.");
            }else if (comEleA < 5){
                System.out.println("승강기 A가" + goFloor +"층으로 이동하였습니다.");
            }else if (comEleB < 5){
                System.out.println("승강기 B가" + goFloor +"층으로 이동하였습니다.");
            }
        }
    }
}
