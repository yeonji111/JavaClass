package yeonji.submit03;

import java.util.Scanner;

public class SubmitSsam {
    // Q.01
    // 10!
    // 10 * 9 * 8 * ... * 1
    public static void main(String[] args) {
        int sum = 1;
        for (int i = 10; i > 0; i--){
//            System.out.println(i);  i가 10부터 1까지 차례대로 출력되는지
            sum *= i;
        }
        System.out.println(sum);


        // Q.01 + a
        //15!
        long sum2 = 1;
        for (int i = 15; i > 0; i--){
            // [Alt + Shift + 방향키 위,아래]
            sum2 *= i;
//            System.out.println(i + ": " + sum2);
        }
        System.out.println(sum2);

        //Q.02
        // 월리를 찾아라.
        String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
//
//        Q.02 - 01.VER
//        int count = 0;
//        for (int i = 0; i < findWally.length(); i += 2) {
//            String wally = findWally.substring(i, i + 2);
//            System.out.println(i + ": " +wally);
//
//            if (wally.equals("월리")) {
//                System.out.println("일치!!");
//                count++;
//            }
//        }
//        System.out.println(count);

//        Q.02 - 02.VER
        int count = 0;
        for (int i = 0; i < findWally.length()-1; i ++) {
            String wally = findWally.substring(i, i + 2);
            System.out.println(i + ": " +wally);

            if (wally.equals("월리")) {
                System.out.println("일치!!");
                count++;
            }
        }
        System.out.println(count);

//        Q.03
//        거꾸로 트리

        String stars = "*****";

//        트리의 규칙 찾는용으로 프린트 해보기.
//        System.out.println(stars.substring(0,5)); // i = 0 , 5
//        System.out.println(stars.substring(0,4)); // i = 1, 4
//        System.out.println(stars.substring(0,3)); // i = 2, 3
//        System.out.println(stars.substring(0,2)); // i = 3, 2
//        System.out.println(stars.substring(0,1)); // i = 4, 1

//        트리 1번 버전(오른쪽에서 하나씩 *을 줄여나가는 방식)
        for (int i = 0; i < 5; i++){
            System.out.println(stars.substring(0,5-i));

//        트리 2번 버전(왼쪽에서 하나씩 *을 줄여나가는 방식)
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(stars.substring(i));
        }

//        Q.04 로꾸거
        Scanner scan = new Scanner(System.in);
        System.out.println(">>>> 거꾸로 뒤집을 문자열 입력해주세요 >>>>");
        String word = scan.nextLine();


//        String word = "곧 2024년";
        word.substring(6,7); // i = 7
        word.substring(5,6); // i = 6
        word.substring(4,5); // i = 5
        word.substring(0,1); // i = 4

        String reverse = "";
        for(int i = word.length(); i > 0; i--){
            // 뒤에서부터 한글자씩 잘라서 reverse에 추가해주기

            System.out.println(word.substring(i-1,i)); // 뒤에서부터 한글자씩 자르는거니까 word(6,7)인
            reverse += word.substring(i-1,i);

        }
        System.out.println(reverse);
    }
}
