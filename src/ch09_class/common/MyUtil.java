package ch09_class.common;

// 내가 만든 유용한 함수들을 가지고 있는 클래스
public class MyUtil {

    /**
     * 소수를 소수 n번째 자리로 반올림하여 리턴해주는 함수
     * @param num   반올림하고자 하는 소수(double)
     * @param n     소수 n번째 자리
     * @return      반올림된 소수 리턴(double)
     */
    public static double myRound(double num, int n) { // double타입의 원본 (실수), int타입의 자릿수 (정수)
        int pow = (int) Math.pow(10, n); // 10.0
        return (double) Math.round(num * pow) / pow;
    }

}
