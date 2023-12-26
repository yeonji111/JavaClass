package ch05_control;

public class LoopFor {
    public static void main(String[] args) {
        // 반복문 - for문

        // 콘솔창에 1부터 10까지 출력

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");


        System.out.println("\n========================\n");

        // for(초기화식;조건식;증감식){ 조건 만족하면 출력할 내용 }
        // 초기화식에는 for문의 반복횟수를 결정해주는 변수 선언
        // 증감식에는 for문이 반복될때마다 변수의 증감을 지정
        // 조건식에는 for문이 반복실행되는 조건을 지정


        // 10번 반복 실행하는 for문
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // int i는 for문 내에서 선언된 변수이므로 for문 밖에서 사용불가 (변수의 스코프)
        // System.out.println(i);


        // 1부터 10까지 출력
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }


        // for문의 내부 변수 i는 for문의 반복횟수를 결정하기 위함
        // 꼭 i를 for문 내에서 쓸 필요는 없다.
        // i는 단순히 변수명 이므로, i가 아닌 다른 단어를 사용해도 된다.
        int num = 1;
        for (int i = 0; i < 10; i++) { // 10번 반복 실행
            System.out.println(num++);
        }
        System.out.println(num++);


        System.out.println("\n==============================\n");

        // 1부터 20까지 더한 값
        // 변수의 스코프 이용
        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += i;
        }
        System.out.println(sum);


        System.out.println("\n==============================\n");

        // 1부터 40까지 중에 짝수끼리만 더한 값
        sum = 0; // 1번 방법

        for (int i = 1; i <= 40; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        sum = 0;  // 2번 방법, 실행 결과는 같은데 for문의 반복 실행 횟수가 더 적다.
        // (반복 실행 횟수 감소 = 프로그램 실행 속도 증가 = 성능 증가)
        for (int i = 0; i <= 40; i += 2) {
            sum += i;
        }
        System.out.println(sum);


        System.out.println("\n==============================\n");

        // 1부터 40까지 중에 홀수끼리만 더한 값
        sum = 0;
        for (int i = 1; i <= 40; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        System.out.println("\n==============================\n");
        // 0부터 2까지 0.2마다 출력
        // 소수인 double, float 타입의 연산은 정확도가 떨어질 수 있으므로 비추
        double testNum = 0;
        for (double i = 0; i <= 2; i += 0.2) {
            System.out.println(i);
        }

        System.out.println("\n==============================\n");
        // 0부터 2까지 0.2마다 출력
        for (int i = 0; i <= 20; i += 2) { // 0,2,4,6,,,,,20
            // 0,0.2,0.4,,,,2
            System.out.println(i / 10.0);
        }

        System.out.println("\n==============================\n");
        // 구구단 2단 출력
        // 2 X 1 = 2
        // 2 X 2 = 4
        // 2 X 3 = 6
        // 2 X 9 = 18

        for (int i = 1; i < 10; i++) {
            System.out.println("2 x " + i + " = " + (i * 2));
        }

        System.out.println("\n==============================\n");

        System.out.println("*");
        System.out.println("**");
        System.out.println("***");
        System.out.println("****");
        System.out.println("****");
        System.out.println("*****");

        System.out.println("\n==============================\n"); // for문 트리 만들기!!!!!!!!!!!!!!!!!!!!!!!!!!


        String tree = ""; // i번 붙이기
        for (int i = 0; i < 5; i++) {
            tree += "*";
            System.out.println(tree);

        }

        for (String s = "*"; s.length() <= 5; s += "*") {
            System.out.println(s);
        }

        System.out.println("\n==============================\n");
        // 나머지 연산자 (%)의 사용 예시
        // for문 내에서 순환하는 숫자에 대해 사용ㅇ하면 좋다.

        // 국수 공장에서 면을 20cm 뽑고 있다.
        // 국수를 5cm 마다 자른다.
        for (int i = 0; i < 20; i++) {
            System.out.println("||||||||");

            // i가 4,9,14,19 24, ... 일때 자르기
            // i를 5로 나눈 나머지가 4인 숫자들
            if (i == 4 || i == 9 || i == 14 || i == 19) {
                System.out.println("---------");
            }

            if (i % 5 == 4) {
                System.out.println("---------");
            }
        }
        System.out.println("\n==============================\n");

        // 라면 공장에서 면을 30cm 뽑고 있는데
        // 6cm 마다 잘라주어야 한다. 5,11,17,23,29
        /*  /////////
            \\\\\\\\\
           //////////
           \\\\\\\\\\
            /////////
            \\\\\\\\\
            -----------
             /////////
            \\\\\\\\\
         */

        // 내가 한 버전
        for (int i = 0; i < 30; i++) {
            if (i % 6 == 5) {
                System.out.println("-----------");
            } else if (i % 2 == 0) {
                System.out.println("\\\\\\\\\\\\\\\\");
            } else if (i % 2 == 1) {
                System.out.println("////////");
            }
        }


        // 수업 버전
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                System.out.println("////////");
            } else {
                System.out.println("\\\\\\\\\\\\\\\\");
            }
            // i가 5,11,17,23, ...
            // 조건을 체크하는 목적이 다른 경우 if문을 분리한다.
            if (i % 6 == 5) {
                System.out.println("------------");
            }

        }
            System.out.println("\n==============================\n");

            // 10부터 1까지 출력
            // 거꾸로 for문
            for(int i = 10; i > 0 ; i --){
                System.out.println(i);
            }

        System.out.println("\n==============================\n");

        // for문으로 String을 가지고 놀기

        // 숫자형 문자열의 각 자리수를 더한 결과를 얻기
        String example = "867223867";

        // for문의 반복횟수? = 글자수 = example.length()
        // 글자 수만큼 반복하는 for문
        int result = 0;
        for (int i = 0; i < example.length(); i++){
           String word =  example.substring(i,i+1);
            int n = Integer.parseInt(word);
            result += n;
        }
        System.out.println(result);

        System.out.println("\n==============================\n");

        // 슈의 갯수는?
        String syusyu = "슈슈슈슈슈슈슛슈슈슈슛";


        // syusyu에서 "슈"가 몇글자 들어가있는지 세어보기

        int total = 0;

        for (int i = 0; i < syusyu.length(); i++){
            String word = example.substring(i,i+1);

            if (word.equals("슈")) {
                total += 1;

            }
        }
        System.out.println(total);






        }
    }



