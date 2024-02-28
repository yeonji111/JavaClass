package home;

import java.util.Scanner;

public class Control {
    public static void main(String[] args) {


        long result = 1;
        for(int i = 1; i <= 15; i++){
            result *= i;
        }
        System.out.println(result);


        System.out.println("\n=========================\n");

        String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";

        int cnt = 0;
        for(int i = 0; i < findWally.length(); i+=2){
            if(findWally.substring(i,i+2).equals("월리")){
                cnt++;
            }
        }
        System.out.println("월리는 총 " + cnt +"나왔습니다");


        System.out.println("\n==================\n");

        String stars = "*****";
        // *****  0 일때 별 5 공백 0
        // **** 1일 때 별 4 공백 1
        // *** 2일 때 별 3 공백 2
        // ** 3일때 별 2 공백 3
        // * 4일때 별 1 공백 4

        String star = "*";
        for(int i = 0; i < 5; i++){
            stars = stars.substring(0,5-i);

        System.out.println(stars);
        }

        System.out.println("\n==================\n");

        Scanner scan = new Scanner(System.in);
        System.out.print("거꾸로 뒤집을 문자열 입력: ");

        String input = scan.nextLine();

        String reverse = "";
        for(int i = input.length()-1; i >= 0 ; i--){
             reverse += input.charAt(i);
        }

        System.out.println("뒤집은 결과: " +reverse);



    }

}
