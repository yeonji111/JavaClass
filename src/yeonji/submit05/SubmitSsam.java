package yeonji.submit05;

public class SubmitSsam {

    /*
    Submit5 - 2번 문제
    나는 .substring을 사용해서 가장 맨 뒷글자부터 잘라서 빈문자열 앞에 하나씩 붙이고,
    선생님은 .substring을 사용해서 가장 앞 글자부터 잘라 빈문자열 뒤에 하나씩 붙힘.
     */


    public static void main(String[] args) {
        String example = "로꾸꺼 로꾸꺼";
        String result = reverseStr(example);
        System.out.println(result);


        System.out.println("\n========================\n");

        String myBinaryStr = makeBinary(23);
        System.out.println(myBinaryStr);


        System.out.println("\n========================\n");

        /*
        중간 공백이 있는 트리만들기 (복습)

         */
        // 4층짜리 삼각형
        //   *      i = 0, 공백 = 3, 별 = 1
        //  * *     i = 1, 공백 = 2, 별 = 1, 공백 = 1, 별 = 1
        // *   *    i = 2, 공백 = 1, 별 = 1, 공백 = 3, 별 = 1
        //*******   i = 3, 공백 = 0, 별 = 7 ( 3+4)

        // 5층짜리 삼각형
        //    *      i = 0, 공백 = 4, 별 = 1
        //   * *     i = 1, 공백 = 3, 별 = 1, 공백 = 1, 별 = 1
        //  *   *    i = 2, 공백 = 2, 별 = 1, 공백 = 3, 별 = 1
        // *     *   i = 3, 공백 = 1, 별 = 1, 공백 = 5, 별 = 1
        //********* i = 4, 공백 = 0, 별 = 9(4+5(=4+1) = (2*i)+1


        // 6층짜리 삼각형

        //     *      i =0, leftBlank = 5, 별=1
        //    * *     i =1, leftBlank = 4, 별=1, 공백=1, 별=1
        //   *   *    i = 2, leftBlank = 3, 별=1, 공백=3, 별=1
        //  *     *   i =3, leftBlank = 2, 별=1, 공백 = 5, 별 = 1
        // *       * i = 4, leftBlank = 1, 별 = 1, 공백 = 7, 별 = 1
        //************ i = 5, leftBlank = 0, 별 = 11

        makeTriangle(5);
        makeTriangle(7);


        }


        public static String reverseStr (String word){
            String result = "";
            for (int i = 0; i < word.length(); i++) {
                result = word.substring(i, i + 1) + result;
            }
            return result;
        }


    /*
    선생님)

    2번 문제와 마찬가지로 빈문자열(result) 뒤에 num을 붙인 후,
    result를 뒤집어서 정수를 2진수로 변환하는 메소드를 완성함

    나)
    2번 문제와 마찬가지로 빈문자열(result) 앞에 num를 붙혀 result 를 완성하고
    이미 뒤집힌 결과가 출력되므로 따로 뒤집는 과정은 거치지 않음.

     */
        public static String makeBinary ( int num){
            String result = "";
//        result += num % 2; // result = "1"
//        num /= 2;          // num = 11
//
//        result += num % 2; // num 11, result = "11"
//        num /= 2;          // num = 5
//
//        result += num % 2; // num = 5, result = "111"
//        num /= 2;          // num = 2,
//        // num 가 1이면 반복 그만 + result에 1추가

            while (num != 1) {
                result += num % 2;

                num /= 2;
            }
            result += "1";
            // num 가 1이면 반복 그만 + result에 1추가
            reverseStr(result);
            return result;
        }

        public static void makeTriangle(int floor){
            for (int i = 0; i < floor; i++) {
                String leftBlank = "";
                for (int k = 0; k < floor - 1 - i; k++) {
                    leftBlank += " ";

                }
                // 꼭대기
                if (i == 0) {
                    System.out.println(leftBlank + "*");
                } else if (i == floor-1) { // 밑바닥, 2i+1만큼 별이 있어야 함 = floor*2-1 만큼 별이 있어야 함
                    String blank = "";
                    for (int j = 0; j < (floor * 2) - 1; j++) {    // floor * 2 - 1을 2i+1로 바꿔서 해볼 예정
                        blank += "*";

                    }
                    System.out.println(blank);
                } else { // 중간층  i+2만큼 중간 공백
                    String innerBlank = "";
                    for (int k = 0; k < 2 * i - 1; k++) {
                        innerBlank += " ";

                    }
                    System.out.println(leftBlank+"*"+innerBlank+"*");
                }

            }
        }


    }
