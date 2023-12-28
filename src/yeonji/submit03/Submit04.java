package yeonji.submit03;

import java.util.Scanner;

public class Submit04 {
    public static void main(String[] args) {
//        String blank = "";
//        String ori = "로꾸꺼 로꾸꺼";
//        for (int i = 0; i < 7; i++){
//            ori.substring(i,i+1);
//            blank = blank + ori.substring(i,i+1);
//            System.out.println(blank);
//        }
        Scanner scan = new Scanner(System.in);
        String blank = "";
        String text = scan.nextLine();


//        // 궁리 1
//        for (int i = 0; i < text.length(); i++){
//            text.substring(i,i+1); // 한글자씩 자름
//          // 한글자씩 맨 뒤로 옮김
//            text = blank  + text.substring(text.length()-i,text.length());
//
//        }
//        System.out.println(text);
//
//    }
//}
// 로(0,1) -> 맨 뒤(text.length,text.length) 고정

// 궁리 2
        for (int i = 0; i < text.length(); i++) {
//            text.substring(i, i + 1);
            for (int j = text.length(); j > 0; j--) {
                text.substring(j - i, j);

                System.out.print(text.substring(j - i, j));
            } // 출력 결과 거꾸로 거꾸로꾸거로꾸 로거 꾸거로꾸

//            // 궁리 3
//            for (int i = 0; i < text.length(); i++) { // 여기는 글자수만큼 반복해야하는게 맞음
////            text.substring(i, i + 1);
//                for (int j = text.length(); j > 0; j--) { //
//                    text.substring(j - i, j);
//
//                    System.out.print(text.substring(j - i, j));

                }
            }
        }

