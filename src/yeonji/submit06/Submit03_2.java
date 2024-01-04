package yeonji.submit06;

import static ch07_array.ArrayMain.printArray;

/*
 중복되지 않는 6개의 로또 번호 생성
 */
public class Submit03_2 {
    public static void main(String[] args) {


        // 선생님 버전
        // 6칸짜리 랜덤한 수를 담는 배열을 만듦
        // false를 담은 변수 선언
        // true일때만 랜덤한 수 생성

        int lotto[] = new int[9];

        for(int i = 0; i < lotto.length; i++) {
            lotto[i] = (int) (Math.random() * 10) + 1; // lotto 배열 크기만큼 반복해서 담을거임

            // 중복번호 제거

            for(int j = 0; j < i; j++){ // i가 1이상일때부터 실행돼서 인덱스 마지막까지 실행되는 반복문
                // 맨 마지막은 break 걸어서 빠져나와야함

            // 중복되면 중복되게 생성된 인덱스에서 다시 랜덤한 정수 생성
                  if(lotto[i] == lotto[j]) {
                      i--;
                      break;

                  }

            }
        }
        printArray(lotto);
      }
    }

