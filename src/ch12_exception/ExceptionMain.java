package ch12_exception;

import java.text.ParseException;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        // 대부분 예외 상황에 대해 에러가 났다고 표현 ( = 뻑났다)
        // 예외는 예측이 가능한 예외와, 예측하지못한 예외로 나눌 수 있다.
        // 두 경우 모두 예외처리가 가능하다.

        int[] intArray = {1,2,3};

        // try~catch 구문
        try{
            // try 중괄호 블록 내부에는
            // 에러가 발생할 가능성이 있는 코드를 넣는다.
            System.out.println(intArray[10]); // 예외 상황에 맞는 객체 생성
            System.out.println("인덱싱이 끝났습니다.");
        }catch (ArrayIndexOutOfBoundsException aioobe){ // 타입과 일치하는 객체가 들어온다.
            // 해당 예외 객체에 대한 정보를 볼 수 있음
            // (에러 메시지, 에러가 발생한 위치)
            aioobe.printStackTrace();

        }
        // try~catch로 예외처리하면 에러가 발생해도 프로그램이 중단되지 않는다.
        System.out.println("인덱싱 예외처리 성공적~!");

        try{
            System.out.println(intArray[10]);
        } catch (Exception exception){
            // Exception은 모든 예외 클래스의 최상위 객체이므로
            // 어떤 예외가 발생하든 catch 된다.
            exception.printStackTrace();

            // 에러가(빨간글씨) 콘솔창에 출력되는 시점과
            // println()이 콘솔창에 출력되는 시점이 다르다.
            System.out.println("빨간글씨 위");
            System.err.println("딸기맛");
            System.out.println("빨간글씨 아래");

            // 만약 스프링 프레임워크 프로젝트에서의 예외처리라면
            // 여기서 에러 페이지로 전환하도록 한다.
        }

        System.out.println("예외 클래스들의 대부 Exception");

        // 예외처리는 충분한 테스트 이후에 적용하는 것을 권장
        // 개발 후반부에 전체적으로 예외처리를 해주는 경우가 많다.

        System.out.println("\n==================\n");

        Scanner scan = new Scanner(System.in);

//        while (true){
//            System.out.println("행동선택");
//            System.out.println("1. 밥먹기 | 2. 잠자기 | 3. 종료");
//            System.out.println(">>> ");
//
//            int command = 0;
//            try {
//               command = Integer.parseInt(scan.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println("숫자만 입력해!!");
//                continue;
//            }
//
//            if (command == 1){
//                System.out.println("냠냠");
//            } else if (command == 2) {
//                System.out.println("쿨쿨");
//            } else if (command == 3){
//                break;
//            }else {
//                System.out.println("숫자는 1~3 중에 하나만 입력해");
//            }
//        }

        System.out.println("\n==========================\n");

        // catch는 여러개 쓸 수 있음
        try{
            System.out.println(intArray[100]);
        }catch (ArrayIndexOutOfBoundsException e){
            // 예측 가능한 예외 처리에 대한 catch
            System.out.println("배열의 인덱스를 넘어감");
        }catch (Exception e){
            // 예측하지 못한 예외 상황 발생 시 처리를 위한 catch (최후의 보험)
            System.out.println("예측하지 못한 예외발생");
        }

        // 일반적으로 예측 가능한 예외 상황 처리를 위해
        // 따로 Exception을 상속받은 예외 클래스를 만들어서 사용
        // = BizException (= 비즈니스 익셉션)

        System.out.println("\n======================\n");
        // 실행순서에 주의
        long sec = 0;
        try {
            sec = ExMethod.dateToMillSec("2024.01.25");
            System.out.println("날짜 포맷팅 완료");
        } catch (ParseException e) {
            System.out.println("날짜 형식은 yyyy.MM.dd 로 해주세요.");
        }
        System.out.println(sec); // 형식을 지켰을 경우 long 리턴, 틀렸을 경우 0 리턴


        try{
            System.out.println(ExMethod.rsp(1));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()); // getter 로 에러 메세지만 출력 가능 : 숫자 0~2만 넣으세요.
        }

        try {
            ExMethod.printName("정상수");
        } catch (BizException e) {
            e.printStackTrace();
        }

        try {
            ExMethod.printName("1232"); // 에러 발생 시 catch 구문이 활성화되며 printName 메소드가 작동하지 않음(1232가 출력X)
        } catch (BizException e) {
            e.printStackTrace();
            System.out.println(e.getMessage()); // 에러 메세지 "숫자가 들어왔다" 출력
            System.out.println(e.getErrCode()); // 에러 코드 2 출력
        } catch (Exception e){ // 예상치 못한 에러를 위한 보험깔기
            e.printStackTrace();
            System.out.println("알 수 없는 에러");
        }

        System.out.println("\n====================================\n");

        // try~catch~fianlly 구문
        try {
            ExMethod.printName("123");
        } catch (BizException e) {
            e.printStackTrace();
        } finally {
            System.out.println("에러가 나든 말든 실행");
        }

        // 어차피 try~catch 밖에 있는 코드는
        // 에러가 나든 말든 실행됨
        System.out.println("탈출");

        Scanner sca = new Scanner(System.in);
        try{
            String temp = ExMethod.rsp(1);
            String name = sca.nextLine();
            System.out.println(name + temp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally는 주로 자원을 닫기 위한 목적으로 사용된다.
            // Java에서 DB와 연결하는 JDBC 챕터에서 자세히 볼 예정
            sca.close();
        }



    }
}
