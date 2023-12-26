package ch02_variable;

public class VariableMain {
    // manin 메소드 만들기
    public static void main(String[] args) {
        // 변수(variable)의 선언
        // [변수 타입] [변수명] 의 형태
        // int 정수타입 float 실수타입 double 실수타입
        // myMoney 변수명
        // 자바는 코드 라인 끝에 [;] 를 꼭 붙여주어야한다.

        int myMoney;

//         변수에 값을 담지 않은 경우 사용할 수 없다.
//         주석 처리 단축키 [Ctrl + /]
//         System.out.println(myMoney);
//         변수에 값 할당(=저장)
//         변수에 값을 할당하는 작업에 대해 변수 초기화(Initialization = Init)라고 한다.
//         등호(=) : 오른쪽의 값을 왼쪽에 담는 기호
//        우리가 알던 등호 -> ==
        myMoney = 10000;
        System.out.println(myMoney);

        // 변수의 값 변경
        // (값을 변경할 수 있어서 변수라고 부름)

        myMoney = 50000;
        System.out.println(myMoney);

        // 변수를 선언함과 동시에 값을 할당한다.
        int number = 10;

        System.out.println(number);

        // 변수의 타입

        // 정수(Integer) 타입
        byte byteNumber = 100; // byte는 256개의 숫자를 담을 수 있는 크기, -128 ~ -127까지 선언 가능
        short shortNumber = -20000; //short 는 -128 * 256개 ~ 127 * 256개의 숫자를 담을 수 있는 크기
        int intNumber = 30000;
        long longnNumber = 3000000000L; // 21억이 넘는 값을 담을때는 long타입으로 선언 후 값에 L를 붙여주어야 한다.

        // 소수(float) 타입
        // 소수값을 입력하면 기본적으로 double로 인식
        // long 타입처럼 float은 f를 붙어주어야 한다.
        float pi = 3.141592f;
        double doubleNumber = 100.3456;

        // 논리형,불리언(boolean) 타입
        // 값이 true 혹은 false 둘 중 하나

        boolean todayIsHappy = false;
        System.out.println(todayIsHappy); // 텍스트 "false" 와 다름

        // 변수의 다중 선언, int numOne, numTwo; 와 동일한 코드
        int numOne, numTwo;
        numOne = 1;
        numTwo = 2;
//        int numOne;
//        int numTwo;
//        numOne = 1;
//        numTwo = 2; 와 56-58줄은 같은 의미의 코드

        // 다중 선언과 동시에 값을 부여할 수 없다(Java 기준)
        // int numA, numb = 5,10;

        // 상수의 선언
        // [final] [상수타입] [상수명]
//        double MATH_PI = 3.14;       -> final이 없으므로 MATH_PI는 명명규칙은 상수 명명규칙을 따랐지만 아직 변수로 인식함.
//        MATH_PI = 2.33;

//        상수는 값을 바꿀 수 없다. (=바뀔 일이 없는 값을 상수에 담아서 사용한다.)
//        final double MATH_PI = 3.14;
//        MATH_PI = 2.33;
//        System.out.println(MATH_PI);

        System.out.println("\n===== 변수를 사용하는 이유 ====\n"); // \n 줄바꿈

        // 변수를 사용하는 이유

        // 콘솔창에 숫자 7을 10줄 출력해보기

        int testNumber = 7;
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);

        // 콘솔창에 숫자 19를 출력해보기



        testNumber = 19;
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);
        System.out.println(testNumber);

        // 값에 대한 이름을 부여할 수 있다.
        // 값은 값을 이곳 저곳에서 사용하는 경우, 변수에 담아서 사용하는 것이 권장됨
        // = 수정할때 매우매우 용이하다.
        // = 수정을 미처 하지 못하는 경우를 방지할 수 있다 !!!!!!!!!!!!!!!!!!!!!!

        int ssamCarNumber = 6344; // 변수명을 a,b같은 무의미하게 지으면 후에 한눈에 식별 불가하므로
        System.out.println(ssamCarNumber);

        System.out.println("\n======= char 타입 =======\n");

        // char 타입은 하나의 문자를 담는데 사용된다.
        // 유니코드에 등록된 각 문자들의 넘버링을 담을 수 있다.
        // 작은따옴표('') 안에 하나의 문자를 담을 수도 있다.

        // 알파벳 A는 유니코드에서 65번째에 위치한다.
        char unicodeA = 65;
        System.out.println(unicodeA);

        char wordA = 'A';
        System.out.println(wordA);

        // 변수에 1 더하기
        wordA++; // 65+1 = 66
        System.out.println(wordA); // 유니코드의 66번째인 B가 출력됨

        // 한글 '가'는 유니코드에서 44032번째에 위치
        char hangul = 44032;
        System.out.println(hangul);

        // 1을 더한다.
        hangul++;
        System.out.println(hangul);

        // 1을 더한다.
        hangul++;
        System.out.println(hangul);

        // byte는 -128 ~ 127 을 담을 수 있음
        byte byteNum = 127;
        byteNum++; // 127 + 1 = ?  128이 아닌 한바퀴를 돌아서 -128를 출력

        System.out.println(byteNum); // -128로 돌아감


}
}
