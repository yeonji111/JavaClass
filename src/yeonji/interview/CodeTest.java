package yeonji.interview;

public class CodeTest {
    public static void main(String[] args) {

        // 배열 내 홀수의 갯수를 계산하여 출력하는 코드를 작성하시오
        // 배열의 내부 요소는 변경될 수 있음
        int[] numArray = {34, 45, 21, 5, 14, 7, 2,};

        int cnt = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] % 2 == 1) {
                cnt++;
            }
        }
        System.out.println("배열 내 홀수의 갯수 : " + cnt);


        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) {
                System.out.println("4의 배수" + i);
                cnt++;
            }
        }
        System.out.println("1부터 100까지의 정수에서 4의 배수의 갯수 : " + cnt);
    }


}
