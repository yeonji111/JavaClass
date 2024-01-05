package yeonji.submit07;

import java.util.ArrayList;
import java.util.Arrays;

public class SubmitSsam {
    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>();

        // 10~20 랜덤 숫자 10번 담기
        for (int i = 0; i < 10; i++) {

            // (int)(Math.random() * 10) : 0~9
            // (int)(Math.random() * 10) + 10 : 10~19
            // (int)(Math.random() * 45) : 0~44
            // (int)(Math.random() * 45) + 1 : 1~45
            // a부터 b 랜덤숫자?
            // (int)(Math.random() * (b-a+1) ) + a

            int rand = (int) (Math.random() * 11) + 10;

            intList.add(rand);
        }

        System.out.println(intList);

        System.out.println("\n=================\n");

        // 중복된 숫자 제거
        ArrayList<Integer> newList = new ArrayList<>();

        // intList의 요소들을 newList에 옮기기
        for (int i = 0; i < intList.size(); i++) {

            // 현재의 intList.get(i) 값이
            // newList에 존재하지 않을때에만 add 실행
            // newList를 for문으로 순회하면서
            // intList.get(i)와 일치하는 경우가 없을때에만 add 실행
            boolean isContain = false;
            for (int k = 0; k < newList.size(); k++) {
                if (newList.get(k) == intList.get(i)) {
                    isContain = true;
                }
            }
            if (isContain == false) {
                newList.add(intList.get(i));
            }

        }

        System.out.println(newList);
        System.out.println("\n========= remove를 사용해서 제거 1 ========\n");
        // 새로운 리스트 생성 없이 remove로 중복 제거
        // remove를 사용하면 배열이 앞당겨질수있으므로
        // 뒤에서부터 비교하는게 바람직함
        for (int i = 0; i < intList.size(); i++) {
            // i가 0일때, 인덱스 1~9과 비교
            // i가 1일때, 인덱스 2~9과 비교
            // i가 2일때, 인덱스 3~9와 비교
            for (int k = i + 1; k < intList.size(); k++) {
                // intList.get(i)와 intList.get(k) 비교하여
                // 값이 같다면 remove
                if (intList.get(i) == intList.get(k)) {
                    intList.remove(k);
                }
            }


        }
        System.out.println(intList);
        System.out.println("\n========= remove를 사용해서 제거 2 ========\n");
        // .remove를 사용한 바람직한 방법
        for (int i = 0; i < intList.size(); i++) {
            // i가 0일때, 인덱스 1~9과 비교
            // i가 1일때, 인덱스 2~9과 비교
            // i가 2일때, 인덱스 3~9와 비교
            for (int k = i - 1; k > i; k--) {
                // intList.get(i)와 intList.get(k) 비교하여
                // 값이 같다면 remove
                if (intList.get(i) == intList.get(k)) {
                    intList.remove(k);
                }
            }


        }
        System.out.println(intList);


        System.out.println("\n======== 2번 아내, 남편 구매 목록 =========\n");

        ArrayList<String> wipeList = new ArrayList<>(Arrays.asList("냉장고", "로봇청소기", "세탁기", "에어컨"));
        ArrayList<String> husbList = new ArrayList<>(Arrays.asList("노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"));

        ArrayList<String> bothWant = new ArrayList<>();
        for (int i = 0; i < wipeList.size(); i++) {


            boolean isContain = false;
            for (int k = 0; k < husbList.size(); k++) {
                if (wipeList.get(i).equals(husbList.get(k))) {
                    isContain = true;
                }
            }
            if(isContain == true){
                bothWant.add(wipeList.get(i));
            }
        }
        System.out.println(bothWant);
    }
}
