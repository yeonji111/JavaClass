package yeonji.submit04;

import java.util.Scanner;

public class Submit01 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int elevatorA = 10;
        int elevatorB = 4;

        while (true) {
//            System.out.println("엘리베이터 A 위치: " + elevatorA);
//            System.out.println("엘리베이터 B 위치: " + elevatorB);
            System.out.println("몇층에 계시나요? : ");
//            int command = Integer.parseInt(scan.nextLine());
            String command = scan.nextLine();
            if (command.equals("q")) {
                System.out.println("프로그램이 종료되었습니다.");
                System.exit(0);
            } else if (command.equals("exit")) {
                System.out.println("프로그램이 종료되었습니다.");
                System.exit(0);
            }
            int goFloor = Integer.parseInt(command); // 가고 싶은 층
            System.out.println(command + "층에서 엘리베이터를 호출합니다.");

            int comEleA = elevatorA - goFloor; // elvatorA(10)-command > 5 보다 크면 B 호출
            int comEleB = elevatorB - goFloor;
//            if (elvatorA - goFloor > 5) // todo goFloor(가고 싶은 층) 과 elevatorA의 차이가 절대값 5이상이 나면 elevatorB가 1층으로 이동 (역도 )
            if (comEleA > 5) {
                System.out.println("승강기 B가" + goFloor + "층으로 이동하였습니다.");
            } else if (comEleB > 5) {
                System.out.println("승강기 A가" + goFloor + "층으로 이동하였습니다.");
            } else if (Math.abs(elevatorA - goFloor) == Math.abs(elevatorB - goFloor)) {

                // 10-goFloor가 적은쪽이 움직여 (높은층에 있는 승강기)
                /* else if 문 안에 if문을 넣어 보완해야함 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */
                System.out.println("승강기 A가" + (goFloor) + "층으로 이동하였습니다.");
            }
        }
    }
}
