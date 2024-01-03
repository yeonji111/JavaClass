package yeonji.submit06;

import static yeonji.submit06.Submit02.printArray;

/*
로또 번호 생성기 Math.random()

1~45 까지의 랜덤 숫자 6개를 배열에 중복되지 않도록 담고, 이를 정렬한 배열을 리턴하는 makeLotto() 함수를 만들어주세요.

 */
public class Submit03 {
    public static void main(String[] args) {
        int[] myLotto = makeLotto(6);
        for (int i = 0; i < myLotto.length; i++){
            System.out.print(myLotto[i] + " ");
        }

    } //(int) (Math.random() * 45) + 1) 1~45 로또 번호 랜덤 생성
    public static int[] makeLotto(int n) {
        int[] myLotto = new int[n]; // n개 짜리 배열(myLotto) 생성
        for (int i = 0; i < n; i++) { // myLotto 인덱스에 숫자 채우기
            myLotto[i] = (int) (Math.random() * 45) + 1;

//            중복되지 않도록 인덱스 앞번호랑 뒷번호가 같다면 다시 반복
            if (myLotto[i] == myLotto[n - 1 - i]) { // 인덱스 범위를 벗어났다고함
                for(int j = 0; j < n; j++) {
                    myLotto[i] = (int) (Math.random() * 45) + 1;
                }


            }

        }
        return myLotto;
    }
}
