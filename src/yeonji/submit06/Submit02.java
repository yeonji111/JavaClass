package yeonji.submit06;

import java.util.Arrays;

/*

최댓값, 최솟값 구하기

int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};

for문을 이용해 intArr의 최댓값과 최솟값을 출력해주세요.

 */
public class Submit02 {
    public static void main(String[] args) {
        // 첫번째 방법) 메소드를 만든 후 오름차순 정렬해서 인덱스 0번과 인덱스 (배열 길이 - 1)번 출력하기
        int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
        // 오름차순 배열하고 인덱스 0번과 인덱스 (길이-1)을 출력
        Arrays.sort(intArr);
//        printArray(intArr);
        System.out.println("최솟값: " +intArr[0]); // 최솟값
        System.out.println("최댓값: " +intArr[intArr.length-1]); // 최댓값



    }


    // printArray 메소드 만들기
    public static void printArray(int[] name) {
        System.out.print("[");
        for (int i = 0; i < name.length; i++) {
            if (i == name.length - 1) {
                System.out.print(name[i]);
            } else {
                System.out.print(name[i] + ", ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }
}
