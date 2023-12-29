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
        // 다 짜놓고 syusyu.substring(i,i+1) 인데 example.substring(i,i+1)이라고 써놔서 오래걸림
        String syusyu = "슈슈슈슈슈슈슛슈슈슈슛";

        // syusyu에서 "슈"가 몇글자 들어가있는지 세어보기
        int count = 0;

        for (int i = 0; i < syusyu.length(); i++){
            String word = syusyu.substring(i,i+1);
            if (word.equals("슈")) {
                count += 1;
            }
        }
        System.out.println(count);



        // 슈의 갯수는?(선생님.ver)
        syusyu = "슈슈슈슈슈슈슛슈슈슈슛";
        count = 0;
        //syusyu에서 "슈"가 몇글자 들어가있는지 세어보기
        // syusyu를 한글자씩 잘라야겠다.(substring)
        // 자른 글자가 "슈"와 일치하는지 체크(equals)
        // 일치하면 카운팅하기
        for (int i = 0; i < syusyu.length(); i++){
            String syu = syusyu.substring(i,i+1);
            if(syu.equals("슈")){
                System.out.println("일치!!");
                count++;

            }
        }
        System.out.println(count);


        System.out.println("\n==============================\n");
        //break 문
        // 반복문을 종료시키는데 사용

        // 내 이름을 유니코드로 표현한다면?
        // 유니코드는 세상 모든 문자를 0부터 65000+a 숫자에 매칭시켜놓은걸 의미

        //48149, 50672, 51648
        char name = 0;
        for(int i = 0; i < 70000; i++){ // 7만번 반복 실행
            if(name == '지'){
                System.out.println(i);
                System.out.println(name);
                break; // 컴퓨터가 break문을 실행하면 가까운 반복문(for, while) 하나를 즉시 종료한다.
            }
            name++;
        }


        System.out.println("\n==============================\n");

        // continue 문

        // 구구단 출력하는데 너무 쉬운 1,2,3 은 출력 안한다.
        for(int i = 1; i <= 9; i++){
            if (i < 4){
                // 반복문 내에서 continue문이 실행되면
                // 바로 다음 반복문으로 넘어간다. (증감식, 조건식 실행하러 감)
                // (continue의 아래 코드는 실행되지 않는다.)
                continue;
            }
            System.out.println("8 X "+i + " = " + (8*i));
        }

        System.out.println("\n==============================\n");

        // 구구단 출력
        // 2 x 2 = 4
        // 2 x 3 = 6
        // 2 x 9 = 18
        // -----------------
        // 3 x 2 = 6
        // 3 x 3 = 9
        // 3 x 9 = 37
        // ---------
        // 9 x 2 = 18
        // 9 x 3 = 27
        // 9 x 9 = 81
        // for문 두개 써서 구구단 출력
        // tab 들여쓰기, shift + tab 내어쓰기
        // 자동 줄맞춤 [Ctrl + Alt + L]
        // 내가 다시 해보기 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        for (int i = 1; i < 10; i++){
//            if(i % 10 == 0){
//                System.out.println("------------------");
//            }
//        }
//
//        for (int i = 1; i <= 9; i++){
//            if (i<2) {
//                continue;
//            }   System.out.println(2 + " x " + i + " = " + (i*2));

        for (int i = 2; i <= 9; i++){
            for (int j = 2; j <= 9; j++){
                System.out.println(i + " x " + j + " = " + (i*j));
            }
            System.out.println("------------------");
        }
        System.out.println("\n==============================\n");
        // 선생님 버전

        for(int left = 2; left <= 9; left++){  // 메모리에 변수명 i가 등록
            for (int right = 2; right <= 9; right++){ // 내부에 있는 for문에서는 외부 for 문의 내부 변수명 사용 불가
                System.out.println(left + " x " + right + " = " + (left*right));

            }
            System.out.println("----------------");
        }

        /*

        디버깅 모드

        코드라인 좌측 (코드라인 숫자가 적혀있는 부분)
        마우스 좌클릭하면 breakpoint가 생성된다.

        생성된 breakpoint는 다시 클릭하면 제거된다.

        breakpoint를 생성한 후 디버깅모드 실행 시
        (상단 재생 버튼 옆 벌레 버튼 클릭 혹은 shift + F9)

        컴퓨터가 코드를 위에서부터 실행하다가
        breakpoint가 있는 지점에 멈춰서 대기를 한다.

        이후 하단 Debug 탭의 Step Over [F8]를 클릭하면 한줄씩 실행이 이루어진다.

        코드를 한줄씩 실행해보며 컴퓨터가 정확히 어디를 실행하는지,
        그때마다 변수에 어떤 값이 담기고 있는지 확인 가능하다.

        디버깅 모드 종료하려면 중지 버튼(Terminate) [Ctrl + F2]

         */


        System.out.println("\n========================\n");

        // 트리(반쪽)
        //    * .substring(4,4) // i가 0일때 공백 4개, 별 1개
        //   ** .substring(3,4) // i가 1일때 공백 3개, 별 2개
        //  *** .substring(2,4) // i가 2일때 공백 2개, 별 3개
        // **** .substring(1,4) // i가 3일때 공백 1개, 별 4개
        //***** .substring(0,4) // i가 4일때 공백 0개, 별 5개

        System.out.println("\n========================\n");
        for (int i = 0; i < 5; i++){
            String blank ="";
            for (int j = 0; j < 4-i; j++){
                blank+= " ";
            }

            String strars = "";
            for(int k = 0; k < (i+1) ; k++){
                strars += "*";
            }
            System.out.println(blank + strars);

        }

        System.out.println("\n========================\n");

        // 트리
        //     * // 공백 5개, 별 1개 - i가 0일때 별 1 // 1
        //    ***  // 공백 4개, 별 3개 - i가 1일때 별 3 // 2
        //   ***** // 공백 3, 별 5 - i가 2일때 별 5개 // 3
        //  ******* // 공백 2, 별 7 - i가 3일때 별 7개  //4
        // ********* //  공백 1, 별 9 - i가 4일때 별 9개 //5
        int floor = 4;
        for (int i = 0; i < floor; i++){
            String blank ="";
            for (int j = 0; j < (floor-i); j++){
                blank += " ";
            }

            String starTest = "";
            for (int j = 0; j < (i+(i+1)); j++){
                starTest += "*";
            }
            System.out.println(blank + starTest);

        }




    }
    }



