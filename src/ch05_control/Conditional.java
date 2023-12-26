package ch05_control;

public class Conditional {

    public static void main(String[] args) {
        // 조건문

        // if문
        int price = 10000;
        int myMoney = 3000;

        // myMoney가 price보다 작으면 "돈이 부족합니다" 문구 출력
        // if문의 조건 안에는 true/false가 들어간다.
        // 프로그래밍에서 괄호는 열렸으면 닫히는 부분이 있어야 한다.
        // if문의 소괄호 안 조건이 true이면 중괄호 내부 코드가 실행된다.
        // 만약 조건이 false면 중괄호 내부 코드가 실행되지 않는다.

        if (myMoney < price) {
            System.out.println("돈이 부족합니다");
        }

        // 한줄로 써도 컴퓨터는 상관하지 않는다.
        if (myMoney < price) {
            System.out.println("돈이 부족합니다");
        }

        // if문 중괄호 블록 내 코드가 한줄뿐이라면
        // 중괄호 블록을 생략할 수 있다.

        if (myMoney < price)
            System.out.println("돈이 부족합니다");
//            System.out.println("불금"); -- 중괄호 없이 조건이 두개라면 if분 외부에 있는 걸로 인식해서 오류 발생

        System.out.println("\n============================\n");

        // 변수의 사용범위 (Scope)
        // 중괄호 블록 {} 안에 선언된 변수는
        // 해당 중괄호 블록 바깥에서는 사용할 수 없다.
        String review = "맛있어요~!!!";
        if (review.length() <= 5) {
            // 메모리에 warning 등록
            String warning = "리뷰는 5글자 이상 작성해주세요.";
        } // 메모리에서 warning 삭제

        // warning의 존재를 모른다.
//        System.out.println(warning);

        String warning = "통과";
        if (review.length() <= 5) {
            warning = "리뷰는 5글자 이상 작성해주세요.";
        }
        System.out.println(warning);


        // 조건에 따른 변수값 변화 시 삼항연산자를 쓰면 좋다.
//        () ? () :
        warning = (review.length() <= 5) ? ("리뷰는 5글자 이상 작성해주세요") : ("통과");
        System.out.println(warning);

        System.out.println("\n===============================\n");


        // else와 else if
        int numZero = 0;

        if (numZero < 0) {
            System.out.println("numZero가 0보다 작은 경우");
        } else {
            //if문 조건이 false면 else 내부 코드가 실행
            System.out.println("numZero가 0과 같거나 크다");
        }

        // 주민번호 뒷자리의 첫번째 숫자가 홀수면 남성, 짝수면 여성

        int perNum = 3;
        if (perNum % 2 == 0) {
            System.out.println("여성입니다");
        } else {
            System.out.println("남성입니다.");
        }

        numZero = 0;
        if (numZero < 0) {
            System.out.println("0보다 작음");
        } else if (numZero == 0) {
            System.out.println("0과 같음");
        } else {
            System.out.println("0보다 크다");
        }

        System.out.println("\n===============\n");

        // 모든 가전 제품에는 프로그래밍 코드가 들어있다.
        // 리모콘은 전원 버튼 하나로 on/off가 가능하다.

        // 조건 (TV의 전원 상태)
        // TV가 꺼져있으면 TV를 켠다.
        // TV가 켜져있으면 TV를 끈다.
        boolean isPowerOn = false;

        // 전원 버튼 누름
        if (isPowerOn == true) {
            //TV가 켜져있는 경우
            System.out.println("TV를 끈다.");
            isPowerOn = false;
        } else {
            //TV가 꺼져있는 경우
            System.out.println("TV를 켠다.");
            isPowerOn = true;
        }

        if (!isPowerOn) {
            //isPowerOn이 false(꺼져있을때) 실행되는 if(조건)문
            //TV가 켜져있는 경우
            System.out.println("TV를 끈다.");
            // isPowerOn == false인 경우
        } else {
            //TV가 꺼져있는 경우
            System.out.println("TV를 켠다.");
            // isPowerOn == true인 경우
        }
        isPowerOn = !isPowerOn;

        // boolean 타입의 true/false 값만을 가지는 성질을
        // 마치 스위치의  on/off 처럼 사용하는 변수에 대해
        // 토글(toggle) 혹은 플래그(flag) 라고 부른다.

        System.out.println("\n=================\n");


        // 예제 직접 풀이) score에 따른 등급 부여
        int score = 85;
        String grade = "";

        // if, else if, else 를 이용하여
        // score 가 90점 이상이면 grade "A" , score가 80점 이상이면 grade "B", 그 외 나머지는 grade 가 "C"

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else System.out.println("C");


        // 예제 선생님 풀이) score에 따른 등급 부여, 조건 위와 동일 ----------- 좀 더 깔끔한 버전
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else grade = "C";

        System.out.println(grade);

        // 예제 선생님 풀이2) 더 깔끔한 버전
        grade = "C";
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        }
        System.out.println(grade);


        // 범위를 명확히
        score = 92;  // 컴퓨터는 앞에서부터 처리하므로 첫번재 조건이 80점 이상을 충족하므로 B를 출력하고 작동 종료
        if (score >= 80 && score < 90) { // 그러므로 범위를 논리연산자(&&)를 사용해 명확히 함
            grade = "B";
        } else if (score >= 90) {
            grade = "A";

        } else {
            grade = "C";
        }
        System.out.println(grade); // Ctrl + ALT + L =  코드 자동 정렬 기능 단축키

        score = 92;  // 컴퓨터는 앞에서부터 처리하므로 첫번재 조건이 80점 이상을 충족하므로 B를 출력하고 작동 종료
        if (score >= 80) {
            grade = "B";
        } else if (score >= 90) {
            grade = "A";

        } else {
            grade = "C";
        }
        System.out.println(grade);


        System.out.println("\n====================================\n");

        // 예제 직접 풀이 ) 회원 가입 조건 체크
        // 이름은 한글자 이상
        // 나이는 14세 이상
        // 휴대폰 번호는 10자리 또는 11자리
        String name = "개똥이";
        int age = 20;
        String phone = "01047959464";

        if (name.length() >= 1){
            if (age >= 14){
                if (phone.length() == 10 || phone.length() == 11){
                    System.out.println("회원 가입 성공");
                }else System.out.println("불통");
                    System.out.println("불통");
                }
            }else {
                System.out.println("불통");
            }




        // 논리연산자를 이용
        if (name.length() >= 1 && age >= 14 && (phone.length() == 10 || phone.length() == 11)) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("불통");
        }

        System.out.println("\n========================\n");

        //switch문
        // if문으로 충분히 구현 가능
        // 특정 변수에 대한 값에 따라 다른 구문을 실행하는 경우 사용

        // 여러분들의 교육기간(단위: 월)

        int month = 3;
        if (month == 0) {
            System.out.println("자바, DB 수업");
        } else if (month == 1) {
            System.out.println("자바, 화면 구현 수업");
        } else if (month == 2) {
            System.out.println("IoT, 화면 구현");
        } else if (month == 3) {
            System.out.println("중간 프로젝트");
        } else if (month == 4) {
            System.out.println("파이썬");
        } else if (month == 5) {
            System.out.println("리액트");
        } else
            System.out.println("팀 프로젝트");


        // 위의 if문을 switch문으로 변경
        // swich문의 소괄호 () 안에는 변수를 넣는다(=month)
        month = 3;
        switch (month) {
            case 0:
                System.out.println("자바,DB 수업");

            case 1:
                System.out.println("자바, 화면구현 수업");
                break; // 실행 후 나머지 case 구문이 실행되지 않도록 한다.
            case 2:
                System.out.println("IoT, 화면구현 수업");
                break; // 실행 후 나머지 case 구문이 실행되지 않도록 한다.

            case 3:
                System.out.println("중간 프로젝트");
                break;
            case 4:
                System.out.println("JSP/스프링, 파이썬");
                break;
            case 5:
                System.out.println("JSP/스프링, 리액트");
                break;
            default: // if문의 else에 해당
                System.out.println("팀 프로젝트");
        }


        // 람다식 적용
        // 프로그래밍 코드에서 ->, => 화살표가 등장한다면 람다식이 적용된 코드
        // 람다식 장점: 코드를 간결하게 만들어준다.
        // 람다식 단점: 초급자 기준으로는 명시적이지 않아서 해석이 어렵다.
        switch (month) {
            case 0 -> {
                System.out.println("자바,DB 수업");
            }

            case 1 -> {
                System.out.println("자바, 화면구현 수업");
            }

            case 2 -> {
                System.out.println("IoT, 화면구현 수업");
            }

            case 3 -> {
                System.out.println("중간 프로젝트");
            }
            case 4 -> {
                System.out.println("JSP/스프링, 파이썬 수업");
            }
            case 5 -> {
                System.out.println("JSP/스프링, SPA(리액트) 수업");
            }
            default -> {
                System.out.println("팀 프로젝트");
            }
        }

        System.out.println("\n===========================\n");

        month = 6;
        // month에 대한 계절을 출력해주는 조건문 만들기

        // 1번 방법

        switch (month) {
            case 12:
                System.out.println("겨울");
                break;
            case 1:
                System.out.println("겨울");
                break;
            case 2:
                System.out.println("겨울");
                break;
            case 3:
                System.out.println("봄");
                break;
            case 4:
                System.out.println("봄");
                break;
            case 5:
                System.out.println("봄");
                break;
            case 6:
                System.out.println("여름");
                break;
            case 7:
                System.out.println("여름");
                break;
            case 8:
                System.out.println("여름");
                break;
            default:
                System.out.println("가을");
        }


        // 2번 방법
        month = 6;
        if (month == 1 || month == 2 || month == 12) {
            System.out.println("겨울");
        } else if (3 <= month && month <= 5) {
            System.out.println("봄");
        } else if (6 <= month && month <= 8) {
            System.out.println("여름");
        } else {
            System.out.println("가을");
        }

        // 3번 방법
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            default:
                System.out.println("가을");
        }
    }
}