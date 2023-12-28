package ch05_control;

public class RacingGame {

    public static void main(String[] args) throws InterruptedException {
        String lane1 = "1. ";
        String lane2 = "2. ";
        String lane3 = "3. ";
        String lane4 = "4. ";
        String lane5 = "5. ";

        String team1 = "🐇";
        String team2 = "🐂";
        String team3 = "🐏";
        String team4 = "🐎";
        String team5 = "🐅";

        System.out.println(lane1 + team1);
        System.out.println(lane2 + team2);
        System.out.println(lane3 + team3);
        System.out.println(lane4 + team4);
        System.out.println(lane5 + team5);

        while (true){
            // 랜덤 숫자 생성
            // Math.ceil()
            // Math.random() 은 0~1 사이의 소수를 리턴
            // Math.random() * 6 은 0부터 6 사이의 소수를 리턴
            // int로 바꿔주면 0~5범위의 정수
            int random = (int)(Math.random() * 6); //Math.random 메소드 앞에 소괄호를 치지 않으면 Math.radom() 이 항상 0으로 정수화

            // random이 1이면 lane1에 공백 문자 추가
            // random이 2이면 lnae2에 공백 문자 추가 ...
            if(random == 1){
                lane1 += " ";

            } else if (random == 2) {
                lane2 += " ";

            } else if (random == 3) {
                lane3 += " ";

            } else if (random == 4) {
                lane4 += " ";

            } else if (random == 5) {
                lane5 += " ";

            }
            // 콘솔창에 줄바꿈 20번 넣어 기존 내용 위로 올려버리기
            for (int i = 0; i < 20; i++){
                System.out.println();
            }

            // 레이싱 상황
            System.out.println(lane1 + team1);
            System.out.println(lane2 + team2);
            System.out.println(lane3 + team3);
            System.out.println(lane4 + team4);
            System.out.println(lane5 + team5);

            // lane의 길이가 40이 되면 우승을 알린 후 break;
            if (lane1.length() >= 40){
                System.out.println("1팀 승리");
                break;
            } else if (lane2.length() >= 40) {
                System.out.println("2팀 승리");
                break;

            } else if (lane3.length() >= 40) {
                System.out.println("3팀 승리");
                break;
            }else if (lane4.length() >= 40) {
                System.out.println("4팀 승리");
                break;
            }else if (lane5.length() >= 40) {
                System.out.println("5팀 승리");
                break;
            }

            // 잠깐 쉬기 (Thread 쓰레드)
            // 100 밀리초만큼 쉬도록 한다. (=0.1초)
            Thread.sleep(100);

        }
    }
}
