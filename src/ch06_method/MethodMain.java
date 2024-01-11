package ch06_method;

import java.util.Scanner;

public class MethodMain {

    public static void main(String[] args) {
        // 메소드 = method = 함수 = function
        // 굳이 나누자면 메소드는 클래스에 종속된 함수를 말하며,
        // 함수는 클래스에 독립적인 함수를 말한다.

        // 1부터 100까지 다 더하면 결과는?

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;

        }
        System.out.println("1부터 100까지 더한 값 : " + sum);

        // 30부터 60까지 다 더하면 결과는?
        sum = 0;
        for (int i = 30; i <= 60; i++) {
            sum += i;
        }
        System.out.println("30부터 60까지 다 더한 값 : " + sum);

        // 25부터 50까지 다 더하면 결과는?
        sum = 0;
        for (int i = 25; i <= 50; i++) {
            sum += i;
        }
        System.out.println("25부터 50까지 다 더한 값 : " + sum);

        // a부터 b까지 다 더하면 결과는?
        // a부터 b까지 더한 값을 출력하는 메소드 만들기

        // 메소드의 실행
        // argument = parameter = 파라미터
        // 15부터 35까지 더한 값을 출력
        printSum(15, 35);

        System.out.println("\n===================\n");

        System.out.println("printSum 실행 전");
        printSum(10, 20);
        System.out.println("printSum 실행 후");

        printSum(70, 90);
        printSum(7, 14);

        // 메소드를 쓰면 좋은 점
        // 실행부의 코드가 간결해진다.( = 가독성이 좋다)
        // 중복된 코드를 한 곳에서 관리할 수 있으므로 수정이 용이


        // 리턴값이 존재하는 함수
        String fruit = "apple";
        fruit.substring(1, 3);
        System.out.println(fruit.substring(1, 3));
//        System.out.println(printSum(1,5)); // 리턴값이 없으므로 에러 발생

        // 실행만 하고, 리턴값을 사용하지 않는 상황
        returnSum(1, 5);
        System.out.println(returnSum(1, 5));


        // 리턴값을 변수에 담을 수 있다.
        int result = returnSum(2, 6);
        System.out.println(result);

        System.out.println("\n==========================\n");

        // System.out.println()
        // console.log()
        // print()
        print("hello, World");
        System.out.println("hello, World");

        // print 선언시 파라미터에 String 타입이 들어온다고
        // 선언했기 때문
        // returnSum의 파라미터는 int 이므로
        // String 타입이 파라미터인 print 메소드에는 returnSum(int타입)이 들어올 수 없음.
        print(returnSum(5, 10));
        System.out.println(returnSum(5, 10));

        System.out.println("\n===========================\n");

        // Math.abs(): 절대값을 리턴해주는 함수
        int rst = Math.abs(-10);
        System.out.println("Math.abs를 사용해서 절대값을 리턴한 결과 " + rst);

        // 함수명 : myAbs
        // 파라미터타입 : int
        // 리턴타입 : int
        // 파라미터로 음수가 들어오면 양수로 바꿔서 리턴
        // 양수가 들어오면 양수 그대로 리턴
        rst = myAbs(-10);
        System.out.println(rst);

        System.out.println("\n===========================\n");


        // makeCard() 메소드 만들기
        makeCard("박연지", 90, 87, 79);

        // 실행시
        // ======= 성적표 ========
        // 이름: 박연지
        // 국어점수 : 90
        // 영어점수 : 87
        // 수학점수 : 79
        // 평균 : 85.45
        // 등급 : B
        // =================
        // 위와 같이 콘솔창에 성적표가 출력되도록 메소드 만들기

        System.out.println("\n=========================\n");

        //LooopWhile의 포켓몬을 메소드로 만들기
        playPokemon();

        System.out.println("\n=========================\n");


        // 팩토리얼 메소드화
        // 어느 파일에서 했더라.. ? [단축키 Ctrl + Shift + F]
        System.out.println("팩토리얼 메소드화");
        System.out.println(factorial(5));
        System.out.println(factorial(3));

        System.out.println("\n=====================\n");
        // 재귀함수
        // 메소드 내에서 해당 메소드를 실행하는 케이스

        // 콘솔창에 1부터 n까지 출력하는 메소드
        printNum(10);

        recPrintNum(10);

        System.out.println(recFactorial(5));
        recFactorial(5);


    } // main 메소드 끝


    // 재귀함수로 팩토리얼 메소드 만들기
    public static long recFactorial(int n){

        if (n <= 1){
            return 1;
        }
        return n * recFactorial(n-1);
        // return 5 * recFactorial(4)
        // return 5 * 4 * recFacotorial(3)
        // return 5 * 4 * 3 * recFactorial(2)
        // return 5 * 4 * 3 * 2 * recFactorial(1)
        // return 5 * 4 * 3 * 2 * 1(if문에 n이 1이거나 1보다 작으면 1을 리턴하기로 했으므로 1을 리턴 후 종료)
    }

    public static void recPrintNum(int n){
        System.out.println(n);

        if(n <= 1){
            return;
        }

        // 자기자신을 호출(=재귀함수)
        // 무한 반복 실행을 주의해야한다.
        recPrintNum(n-1);
    }



    // printNum 메소드 만들기
    public static void printNum(int n){
        for (int i = 1; i <= n; i++){
            System.out.println(i);
        }
    }

    public static void playPokemon() {
        Scanner scan = new Scanner(System.in);
        int hp = 100; // 파이리의 체력


        while (true) {
            System.out.println("야생의 파이리를 만났다");
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 공격 | 2. 도망");
            System.out.println(">>>>>>>>>");

            int command = Integer.parseInt(scan.nextLine());


            if (command == 1) {
                // TODO 공격

                // 바깥 while문에 outer라는 네임태그 부여
                outer:
                while (true) {
                    System.out.println("공격 방법 선택");
                    System.out.println("1. 백만볼트  | 2. 전광석화 | 3. 취소");
                    System.out.println(">>>>");

                    int attack = Integer.parseInt(scan.nextLine());
                    if (attack == 1) {
                        System.out.println("피카츄 백만볼트");
                        hp -= 40;

                    } else if (attack == 2) {
                        System.out.println("피카츄 전광석화");
                        hp -= 20;

                    }
                    System.out.println("파이리 체력: " + hp);  // attack에 1,2 둘 다 중복되는 코드이므로 바깥에 선언
                    if (hp <= 0) {
                        System.out.println("전투에서 승리");

                        // 프로그램 종료

                        // 리턴 타입이 void 없더라도
                        // return은 사용가능하다.
                        // 메소드 내에서 return이 실행되면
                        // 해당 메소드는 즉시 종료된다.

                        return;


                        // 외부 while문에 네임태그 설정
//                        break outer; // outer라는 이름을 가진 while문 즉시종료

                    } else if (attack == 3) {
                        System.out.println("전투를 취소한다.");
                        // 가까운 반복문 1개를 즉시 종료
                        break; // 내부 공격 while문만 종료된다.
                    }
                }
            } else if (command == 2) {
                //  도망
                System.out.println("도망쳤습니다");
                break;


            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }

    }
    // 메소드 선언
    // public : 접근 제어자
    // static : 정적 메소드 선언
    // void : 메소드 리턴값이 없음을 의미
    // (리턴값이 있으면 이 자리에 해당 리턴값의 타입을 적어준다.)
    // printSum은 함수명을 의미
    // () 안에 파라미터를 입력받을 수 있음.
    // a부터 b까지 숫자를 다 더한 값을 콘솔창에 출력하는 메소드

    public static void printSum(int a, int b) {
        // main 메소드 내부에서 선언된 변수 사용불가
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        System.out.println(a + "부터 " + b + "까지 더한 값: " + sum);
    }

    // a부터 b까지 더한 값을 리턴하는 메소드
    public static int returnSum(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        // 변수 sum에 저장된 값을 리턴
        return sum;
    }

    // System.out.println() 을 대체하는 메소드
    public static void print(String word) {
        System.out.println(word);
    }

    // 기본적으로 중복된 변수명 선언을 할 수 없듯이
    // 중복된 함수명 또한 선언할 수 없다.
    // 하지만 파라미터의 타입이나 파라미터의 개수가 다르다면
    // 중복된 함수명을 사용할 수 있다.
    // = 메소드 오버로딩 (Method Overloading)
    public static void print(int num) {
        System.out.println(num);
    }

    // 함수명 : myAbs
    // 파라미터타입 : int
    // 리턴타입 : int
    // 파라미터로 음수가 들어오면 양수로 바꿔서 리턴
    // 양수가 들어오면 양수 그대로 리턴
    public static int myAbs(int num) {
        if (num < 0) {
            num *= -1;
        }
        return num;  // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    // makeCard() 메소드
    // makeCard("이름", 90, 87, 79);

    // 실행시
    // ======= 성적표 ========
    // 이름: 박연지
    // 국어점수 : 90
    // 영어점수 : 87
    // 수학점수 : 79
    // 평균 : 85.45
    // 등급 : B
    // =================
    // 위와 같이 콘솔창에 성적표가 출력되도록 메소드 만들기
    //(평균이 90점 이상 A, 80점 이상 B, 그 외 C)


    public static void makeCard(String name, int kor, int eng, int math) {
        System.out.println("\n===================\n");
        System.out.println("이름: " + name);
        System.out.println("국어: " + kor);
        System.out.println("영어: " + eng);
        System.out.println("수학: " + math);

        double scoreAvg = (double) (kor + eng + math) / 3;

        // scoreAvg를 소수 셋째자리에서 반올림하여 소수 둘째자리로 만들기
        // Math.round() 는 소수 첫째자리에서 반올림한 정수값 리턴 10.3 -> 10
        // 우리만의 반올림 메소드 myRound()를 만들어보자
        scoreAvg = myRound(scoreAvg, 2);
        System.out.println("평균: " + scoreAvg);

        String grade = "";
        if (scoreAvg >= 90) {
            grade = "A";
        } else if (scoreAvg >= 80) {
            grade = "B";
        } else grade = "C";
        System.out.println("등급: " + grade);

        System.out.println("\n======================\n");

    }

    // 반올림 메소드 만들기
    public static double myRound(double num, int n) { // double타입의 원본 (실수), int타입의 자릿수 (정수)
        // Math.round()은 소수 첫째자리에서 반올림한 정수 리턴
        // 3.141592
        // Math.round(3.141592) -> 3 리턴

        // 3.141592 에 10을 곱함 = 31.41592
        // Math.round(31.41592) -> 31 리턴
        // 리턴값을 10으로 나눔 = 3.1

        // 3.141592에 100을 곱함 = 314.1592
        // Math.round(314.1592) -> 314
        // 리턴값을 100으로 나눔 = 3.14

        // n이 1이면 10을 곱하고 나눔
        // n이 2이면 100을 곱하고 나눔
        // n이 3이면 1000을 곱하고 나눔
        // = 10^n 을 구하기
        // Math.pow(10,n): 10의 n승 값을 리턴
        int pow = (int) Math.pow(10, n); // 10.0

        // 1. num에 pow를 곱한다.
        // 2. 1번값에 Math.round()를 적용한다.
        // 3. 2번값에 pow를 나눈다.
        // 4. 3번값을 리턴한다.

        // Math.round()는 정수타입 리턴 -> 소수타입으로 형변환
        return (double) Math.round(num * pow) / pow;
    }

    // 팩토리얼 메소드화
    public static long factorial(int n){
        int num = n;
        long factorial = 1;
        for (int i = num; i > 0; i--){
            factorial = factorial * i;
        }
        return factorial;
    }


}



