package ch09_class.typing;

import ch09_class.common.Constants;
import ch09_class.common.MyUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class TypingMain {

    public static void main(String[] args) {

        // 타자연습
        Scanner scan = new Scanner(System.in);

        System.out.println("타자연습 종류를 선택하세요.");
        System.out.println("1. 한글 | 2. 영어");
        System.out.println(">>> ");

        int type = Integer.parseInt(scan.nextLine());


        ArrayList<String> wordList = Dictionary.makeWordList(type);





        // 1704940447019
        // 1970년 1월 1일을 기준으로
        // 현재까지 경과된 시간을 밀리초 단위로 리턴값 (1초 = 1000밀리초)
        System.out.println(System.currentTimeMillis());
        long before = System.currentTimeMillis();
//        int idx = 0;
        while (true) {

            // 제시어 랜덤 출력
            // 랜덤 숫자 생성
            int ran = MyUtil.randomNum(0,wordList.size()-1);
            System.out.println(wordList.get(ran));

            System.out.println(">> ");
            String input = scan.nextLine();

            if (wordList.get(ran).equals(input)) {
                wordList.remove(ran);
            }

            if (wordList.size() == 0) {
                break;
            }
        }

        long after = System.currentTimeMillis();

        long diff = after - before;
        System.out.println(diff/1000.0 +"초 걸렸습니다.");
    }
}
