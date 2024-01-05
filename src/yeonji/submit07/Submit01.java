package yeonji.submit07;

import java.util.ArrayList;
import java.util.Collections;

public class Submit01 {
    public static void main(String[] args) {
        // ArrayList 객체 생성, 10 ~ 20 사이의 랜덤 숫자를 10개 담음
        // 10개짜리 랜덤 정수 담는 randomList 만들기
        ArrayList<Integer> randomList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int ran = (int) (Math.random() * 11) + 10; // 10에서 20
            randomList.add(i, ran); // 인덱스 i에 ran 담기


        }
        System.out.println(randomList); // 중복이 있는 리스트


        // 1.정수형 리스트에서 중복된 숫자들을 제거 후 출력 = 복잡해서 탈락
        // 2. 빈 문자열 -> 중복되지 않는 경우에만 빈문자열에 값 담기
//        for (int i = 0; i < randomList.size(); i++) {
//            for (int j = 0; j < randomList.size(); j++) {
//                if (randomList.get(i) == randomList.get(j)) {
//                    i--;
//                    break;
//                }
//            }
//        } 1번 끝


        ArrayList<Integer>dupleTestList = new ArrayList<>();
        int idx = 0;
        boolean isFalse = false; // true인 경우에만 빈 문자열에 랜덤한 수 담기
        int ran = (int) (Math.random() * 11) + 10; // 조건이 true에 만족할때만 출력
//
//        while (isFalse == false) {
//            // 모든 케이스가 true인 경우 랜덤한 수를 빈 리스트에 넣는 코드 ( 크기만큼 반복해서 넣어야)
////            int ran = (int) (Math.random() * 11) + 10; // 조건이 true에 만족할때만 출력
//
//            dupleTestList.add(ran);

            for (int i = 0; i < randomList.size(); i++){ // 크기만큼 반복할것
                if (dupleTestList.get(i) == ran) { // 일치하면 불리언타입의 내용만 변화
                    isFalse = true;
                }
                if (isFalse == false) {  // 일치하지 않으면 빈 문자열에 랜덤한 수 담기
                    dupleTestList.add(idx,ran);
                    idx++;
                }
                else if (i == randomList.size()){ // 맨 마지막 인덱스이면 빠져나오기
                    break;
                }


//                while (isFalse == false) {
//                    // 모든 케이스가 true인 경우 랜덤한 수를 빈 리스트에 넣는 코드 ( 크기만큼 반복해서 넣어야)
////            int ran = (int) (Math.random() * 11) + 10; // 조건이 true에 만족할때만 출력
//
//                    dupleTestList.add(ran);



            }  System.out.println(dupleTestList);
        }


        // 3. 정수형 리스트를 오름차순으로 정렬
//        Collections.sort(randomList);
//        System.out.println(randomList);




    }



