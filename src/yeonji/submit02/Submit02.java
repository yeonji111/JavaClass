package yeonji.submit02;

public class Submit02 {
    public static void main(String[] args) {

        int example = 278;
        String test = example + ""; // "278"

        String numOne = test.substring(0,1);
        System.out.println(numOne); // .substring으로 순번 0~1사이 자르기

        String numTwo = test.substring(1,2);
        System.out.println(numTwo); // .substring으로 순번 1~2 사이 자르기

        String numThr = test. substring(2);
        System.out.println(numThr); // .substring으로 2번째 이후 자르기



        int sub0 = Integer.parseInt(numOne); // 문자열 numOne -> 정수형으로 담아서 변수 sub0에 담기
        int sub1 = Integer.parseInt(numTwo); // 문자열 numTwo -> 정수형으로 담아서 변수 sub1에 담기
        int sub2 = Integer.parseInt(numThr); // 문자열 numThr -> 정수형으로 담아서 변수 sub2에 담기

        System.out.println(sub0 + sub1 + sub2);







//        int numOne = test.charAt(0);
//        System.out.println(test.substring(0));

//        System.out.println(test.charAt(1));
//        System.out.println(test.charAt(2));
//
//        System.out.println(numOne);
//        int numTwe = test.charAt(1);
//        int numThr = test.charAt(2);


//        int age = Integer.parseInt(strAge);



    }
}
