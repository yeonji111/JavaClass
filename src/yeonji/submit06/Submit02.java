package yeonji.submit06;

import java.util.Arrays;

/*

최댓값, 최솟값 구하기

int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};

for문을 이용해 intArr의 최댓값과 최솟값을 출력해주세요.

 */
public class Submit02 {
    public static void main(String[] args) {
        // 첫번째 방법) intArr
        // 메소드를 만든 후 오름차순 정렬해서 인덱스 0번과 인덱스 (배열 길이 - 1)번 출력하기
        int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
        // 오름차순 배열하고 인덱스 0번과 인덱스 (길이-1)을 출력
        Arrays.sort(intArr);
//        printArray(intArr);
        System.out.println("최솟값: " + intArr[0]); // 최솟값
        System.out.println("최댓값: " + intArr[intArr.length - 1]); // 최댓값


        System.out.println("\n============다른 방법=============\n");
        // 두번째 방법) for,if문 넣어서 버블 정렬 ,
        // int[] intArrB
        int[] intArrB = {23, 456, 213, 32, 464, 1, 2, 4};
        for (int j = 0; j < intArrB.length - 1 - j; j++) {
            for (int i = 0; i < intArrB.length - 1; i++) {
                if (intArrB[i] > intArrB[i + 1]) { // 크면 맨 한칸씩 뒤로 이동해, 한사이클
                    int tmp = intArrB[i];
                    intArrB[i] = intArrB[i + 1];
                    intArrB[i + 1] = tmp;
                }
            }
        }
        System.out.println("최댓값: " + intArrB[(intArrB.length-1)]); //  최댓값
        System.out.println("최솟값: " + intArrB[0]); //  최솟값

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
