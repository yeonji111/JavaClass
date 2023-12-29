package yeonji.submit04;

import java.util.Scanner;

public class SubmitSsam01 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int elevatorA = 10;
        int elevatorB = 4;

        while (true){
            System.out.println("엘리베이터 A 위치: " + elevatorA);
            System.out.println("엘리베이터 B 위치: " + elevatorB);
            System.out.println("몇층에 계시나요? : ");


            // Q 또는 숫자를 입력
            String input = scan.nextLine();

            if (input.equals("q")){
                System.out.println("프로그램이 중지되었습니다.");
                break;
            }

            // 사용자의 층을 입력 받는 부분

           int floor = Integer.parseInt(input);

           // 입력 받은 층과 엘리베이터 A 의 위치 차이 계산
            int diffA = Math.abs(elevatorA - floor);

           // 입력 받은 층과 엘리베이터 B 의 위치 차이 계산
            int diffB = Math.abs(elevatorB- floor);

            // diffB가 음수면 양수로 변경
            if(diffB < 0){
                diffB *= -1;
            }


            // A 위치차이와 B 위치차이 크기를 비교해서
            // 크기가 더 작은 엘리베이터를 이동시킨다.

            if (diffA > diffB){
                System.out.println("엘리베이터 B가 " + floor +"층으로 이동");
                elevatorB = floor;
            } else if (diffA < diffB) {
                System.out.println("엘리베이터 A가 " +  floor +"층으로 이동");
                elevatorA = floor;
            } else if (diffA==diffB) {
                // 층수 차이가 같다면 A와 B중에 더 높은 위치에 있는 엘리베이터가 이동한다.
                if (elevatorA > elevatorB) {
                    System.out.println("엘리베이터 A가 " + floor + "층으로 이동");
                    elevatorA=floor;
                } else{
                    System.out.println("엘리베이터 B가 " + floor+"층으로 이동");
                    elevatorB=floor;
                }

            }

        }

        }
}
