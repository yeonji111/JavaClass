package yeonji.submit02;

import java.util.Scanner;

public class Submit01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("이름을 입력해주세요.");
        System.out.print(">>>>");
        String name = scan.nextLine();
        System.out.println("국어 점수를 입력해주세요.");
        System.out.println(">>>>");
        String koScore = scan.nextLine();
        System.out.println("영어 점수를 입력해주세요.");
        System.out.println(">>>>");
        String enScore = scan.nextLine();
        System.out.println("수학 점수를 입력해주세요.");
        System.out.println(">>>>");
        String matscore = scan.nextLine();

        double scoreKo = Integer.parseInt(koScore);
        double scoreEn = Integer.parseInt(enScore);
        double scoreMa = Integer.parseInt(matscore);

        double scoreAve = (scoreKo + scoreEn + scoreMa) / 3;

//        System.out.println(scoreAve); -------결과값 70.33333

        String aveScore = scoreAve + "";
        System.out.println("평균: " + aveScore.substring(0,5)); // 문자열로 바꾸고 substring으로 바꿈




    }
}
