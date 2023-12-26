package yeonji.submit02;

import java.util.Scanner;

public class SubmitSsam1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("이름을 입력해주세요.");
        System.out.println(">>>>>>>");
        String name = scan.nextLine();

        System.out.println("국어 점수를 입력해주세요.");
        System.out.println(">>>>");
        String strKor = scan.nextLine();
        int kor = Integer.parseInt(strKor); // scan은 무조건 문자열을 담기 때문에 int로 형변환해줌

        System.out.println(kor);

        System.out.println("영어 점수를 입력해주세요.");
        System.out.println(">>>>");
        int eng = Integer.parseInt(scan.nextLine()); // 다음에 입력하는 정보를 스캔 ->  int로 형변환 -> 변수 eng에 정수로 담기

        System.out.println("수학 점수를 입력해주세요.");
        System.out.println(">>>>");
        int math = Integer.parseInt(scan.nextLine()); //

        System.out.println("이름: "+name);
        System.out.println("국어: "+kor);
        System.out.println("영어: "+eng);
        System.out.println("수학: "+math);

        double avg = (kor + eng + math)/3; // 변수 확인 제대로 해야함.
        System.out.println("평균: " + avg);

        // 소숫점 둘째자리까지 출력되게
        System.out.printf("평균: %.2f",avg); // printf ~~~~~~ %.2f
    }
}
