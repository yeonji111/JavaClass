package yeonji.submit02;

public class SubmitSsam2 {
    public static void main(String[] args) {

        int example = 278;

        String strEx = example + ""; // "278"

        //'2' + '7' + '8' = 161
        // charAt을 이용하면 숫자 문자의 유니코드 넘버링으로 연산이 됨 -------- charAt으로 시도해봤지만 실패했었음
        System.out.println( strEx.charAt(0) + strEx.charAt(1) + strEx.charAt(2));

//        System.out.println(strEx.charAt(0));          ------------- charAt으로 리턴한 문자열을 정수로 형변환해서 계산한다해도 불가능
//        System.out.println(strEx.charAt(1));
//        System.out.println(strEx.charAt(2));
//        int int4 = Integer.parseInt(strEx.charAt(0));
//        System.out.println(int4);

        // .substring 메소드를 이용해서 자르고, 정수로 바꾸기

       String str1 = strEx.substring(0,1); // "2"
       String str2 =  strEx.substring(1,2); //"7"
        String str3 = strEx.substring(2,3); // "8"

        int int1 =  Integer.parseInt(str1); // 2
        int int2 = Integer.parseInt(str2); // 7
        int int3 = Integer.parseInt(str3); // 8

        System.out.println(int1 + int2 + int3);



        // 코드라인 한줄로 만들기
        int sum1 = Integer.parseInt(str1) + Integer.parseInt(str2) + Integer.parseInt(str3);

        System.out.println(sum1);




        // 더 간략하게 만들기
        int sum2 = Integer.parseInt(strEx.substring(0,1))
                + Integer.parseInt(strEx.substring(1,2))
                + Integer.parseInt(strEx.substring(2,3));

        System.out.println(sum2);

    }
}
