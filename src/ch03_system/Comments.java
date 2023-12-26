package ch03_system;

public class Comments {


    // 자바 문서(javadoc) 주석
    // 메소드 사용법에 대해 설명하는 용도로 사용

//    / + ** + enter
    /**
     * 내가 좋아하는 과일
     */
    static String apple = "사과";



    public static void main(String[] args) {
        // 주석 (Commment)

        // 단일 주석(코드 앞에 //)
        // 프로그래밍 언어마다 주석이 다른 경우가 많다.
        // 단일 주석 단축키 [Ctrl + /]

        // 영역 선택(Shift + 방향키) 후 단축키를 통해 여러 개의 코드 라인도 주석 처리, 해제 가능
        System.out.println("오늘은 수요일");
        System.out.println("오늘은 수요일");
        System.out.println("오늘은 수요일");
        System.out.println("오늘은 수요일");

        /* 다중 주석 */


        /*
        / + * + enter
         */

        System.out.println(apple); // javadoc에 저장한 내용이 apple에 커서를 가져다대면 뜸

        // TODO 주석
        // 개발 중에 나중에 구현해야할 부분에 대해 미리 코멘트를 남겨두는 경우 사용
        // Menu - View - Tool Windows - TODO ( 남겨 놓은 모든 TODO 주석을 확인할 수 있음)


    }
}
