package home.sort;

import static ch07_array.ArrayMain.printArray;

public class BubbleSort {
    public static void main(String[] args) {


        int [] number = new int[6];

        number[0] = 4;
        number[1] = 3;
        number[2] = 9;
        number[3] = 10;
        number[4] = 1;
        number[5] = 2;

//        System.out.println(number.length); // ->6

        // [1, 2, 3, 4, 9, 10]
        // 버블정렬 내림차순
        // 작은 수가 앞에, 큰 수가 뒤에
        // 움직여야하는건 큰 수
        // 반복문이 길이를 넘으면 index 에러를 발생하지 않고, 마지막 인덱스는 앞 인덱스에서
        // 비교되었을 것이므로 조건식에서 number.length-1 과 number.length-1-k 로 조건
        for (int k = 0; k< number.length-1; k++){
            for(int i = 0; i < number.length-1-k; i++){
                if (number[i] > number[i+1]){
                    int tmp = number[i];
                    number[i] = number[i+1];
                    number[i + 1] = tmp;
                }
            }
        }
            printArray(number);

        // [1, 2, 3, 4, 9, 10]
        // 버블정렬 내림차순
        // 큰수가 앞에, 작은수가 뒤에
        // 움직여야하는건 작은수
        for (int i = 0; i < number.length-1 ; i++){
            for (int j = 0; j < number.length -1-i; j++){
                if (number[j] < number[j+1]){
                    int tmp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = tmp;
                }
            }
        }
        printArray(number);

    }

}
