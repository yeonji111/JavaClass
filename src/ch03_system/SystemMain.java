package ch03_system;

import java.util.Scanner;

public class SystemMain {
    public static void main(String[] args) {

        // 콘솔창에 값 출력
        // println() 는 괄호안에 있는 내용을 콘솔창에 출력 후 줄바꿈을 자동으로 해준다

        System.out.println(1);
        System.out.println(); // 아무 내용은 없지만 자동 줄바꿈만 일어난다.
        System.out.println(2);
        System.out.println(3);


        // print() 괄호 안, 내용만을 콘솔창에 출력한다. 자동 줄바꿈은 일어나지 않는다.
        System.out.print(1);
        System.out.print(2);
        System.out.print(3);

        // 콘솔창의 용도
        // 프로젝트 내에 사용중인 변수와 객체의 저장된 값을 확인하는데 사용

        System.out.println("\n ==================== \n");

        // 제어문자
        // 문자열 내에 역슬래시(\)를 이용하여 특정 기능을 넣을 수 있다.

        // \n 개행문자(줄바꿈)
        System.out.print("나도 println이 되고싶어\n");
        System.out.println("나도 println이 되고싶어"); // 위와 같음

        // \t 탭
        System.out.println("일\t월\t화\t수");
        System.out.println("7\t8\t9\t10");

        // 기능을 가지는 문자(\, "", '')를 콘솔창에 출력하고 싶다면
        // 해당 문자 앞에 \를 붙여준다.
        System.out.println("쌍따옴표(\")는 문자열로 만드는 기능"); // 문자열에 "" 를 추가하고 싶으면 앞에 역슬래시(\)를 붙여야 한다.
        System.out.println("역슬래시는 \\이다"); // \를 문자로 넣고 싶으면 \\ 두개 넣어주면 된다.

        // 특수문자도 출력 된다.
        System.out.println("😊");

        System.out.println("\n===============================\n");

        //printf() 는 포맷 문자열(format string)과 함께 사용
        System.out.printf("포맷 문자열 없이 쓰기\n");
        System.out.printf("총 인원은 %d명 입니다.",15);
        System.out.printf("오늘은 %d월 %d일입니다.\n",12, 20);
        System.out.printf("12월 25일은 %s입니다.\n","크리스마스");

        // 포맷문자열 예시
        System.out.printf("ch%02d장\n", 5);
        System.out.printf("%.3f",3.141592); // 소수 세자리까지 쓰겠다는 의미
        System.out.printf("보유금액: %,d", 1000000); // 천단위마다 콤마(,) 찍어주는 것

        System.out.println("\n========================\n");

        // 표준 입력
        // Scanner 객체 사용
        Scanner scan = new Scanner(System.in);

        String temp = "임시";

        System.out.println(temp);

        String dump = new String("덤프");
        System.out.println(dump);

        System.out.println("이름을 입력해주세요.");
        System.out.print(">>>>");
        // 콘솔창에 문구 입력 후 엔터 칠때까지 대기
        // 엔터를 치게 되면 입력받은 문구를 리턴
        String name = scan.nextLine();

        System.out.println(name + "님 환영합니다."); // 콘솔창 >>>> 옆에 이름을 입력하면 출력되는 메소드

        System.out.println("나이를 입력해주세요.");
        System.out.println(">>>>");
        // scan.next(), scan.nextInt() 이 존재하지만 scan.nextLine()만 사용하시길 권장
        // nextLine()은 항상 String타입으로 가져오므로
        // 숫자인 경우 String -> int 타입으로 형변환
       String strAge = scan.nextLine();

        System.out.println(strAge + 1);

        int age = Integer.parseInt(strAge); // 형변환 문자열인 숫자가 int 타입으로 형변환되는 것. 형변환 메소드!!!! int 변수명 = Interger.parseInt()

        System.out.println(age+1);




    }
}
