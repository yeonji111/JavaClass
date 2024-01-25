package ch11_java_api;

public class ApiStringBuffer {
    public static void main(String[] args) {
        // 문자열하면? String
        // String을 수정하게 되면 힙 메모리 영역에
        // 새로운 String 객체가 만들어지고,
        // 가비지 컬렉터가 기존 String 객체를 지우는 등
        // 메모리적으로 비효율적이다. (= 시간이 오래 걸린다 = 성능 저하)

        // 문자열을 수정해야하는 경우
        // StringBuffer 나 StringBuilder를 이용하는 것이 권장된다.

        // StringBuffer 사용법
        StringBuffer strBuff = new StringBuffer();
        System.out.println(strBuff); // "" 와 같음 (empty)

        // 문자열 추가
        strBuff.append("안녕하세요");
        System.out.println(strBuff); // "안녕하세요"와 같음

        strBuff.append("굿모닝");      // 문자열 더하기와 같음
        System.out.println(strBuff);  // "안녕하세요굿모닝"과 같음

        // 문자열 비우기
        strBuff = new StringBuffer(); // 다시 빈문자열로 생성
        System.out.println(strBuff); // "" 와 같음 (empty)

        // 선언할 때 문자열 넣기
        strBuff = new StringBuffer("선언과 동시에 문자열 넣어보기");
        System.out.println(strBuff);
        System.out.println(strBuff.toString()); // toString으로 문자열 꺼내서 출력하기

        // 수정하여 완성된 문자열을 다른 곳에서 쓰기 위해
        // String 으로 꺼내서 사용함
        String content = strBuff.toString();
        System.out.println(content);

        // 랜덤 숫자를 가진 문자열 생성
        // String 은 1000000에 대해 62초 걸림
        String text = "";
        // StringBuffer 은 1000000에 대해 1초도 안걸림
        StringBuffer sb = new StringBuffer();

        long before = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++){
            // 0~9 사이의 랜덤숫자 생성 후 text에 이어붙이기
            int rand = (int)(Math.random()*10);
            text += rand;
            sb.append(rand);

            // 5만번 마다 콘솔창에 현재 진행사항 출력
            if (i % 50000 == 0){
                System.out.println(i + "...");
            }
        }
        long after = System.currentTimeMillis();
        long diff = after - before;
        diff /= 1000;
        System.out.println(diff + "초 걸림");


        System.out.println("\n===================================\n");

        // StringBuilder 사용법
        // StringBuffer와 사용법이 같음
        StringBuilder strBuild = new StringBuilder();

        strBuild.append("추가");

        System.out.println(strBuild);

        // StringBuffer와 StringBuilder의 차이점
        // StringBuffer는 동기화 지원
        // StringBuilder는 동기화 미지원

        // 동기화 지원이란?
        // 멀티 쓰레드 환경에서 해당 객체가
        // 모든 쓰레드에서 안정적으로 사용 된다.

        // 동기화 지원 StringBuffer
        // 쓰레드 A,B,C에서 각각의 쓰레드들이
        // 하나의 StringBuffer 객체를 사용할 때
        // 쓰레드 A가 StringBuffer 객체를 수정한 경우
        // 다른 쓰레드 B, C에서 이 사실을 안다. (= 안정적)
        // 단일 쓰레드에서 조금 낮은 성능

        // 동기화를 지원하지 않는 미지원 StringBuilder
        // 쓰레드 A,B,C에서 각각의 쓰레드들이
        // 하나의 StringBuilder 객체를 사용할 때,
        // 쓰레드 A가 StringBuilder 객체를 수정한 경우
        // 다른 쓰레드 B,C에서 이 사실을 모를 수도 있다. (= 문제가 발생할 수 있음)
        // 단일 쓰레드에서 좀 더 좋은 성능






    }
}
