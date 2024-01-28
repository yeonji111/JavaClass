package ch13_thread;

public class MakeString {

    public static void main(String[] args) {
        // 문자열을 아주 길~~~게 만들기

        // StringBuffer 동기화 지원
        StringBuffer strBuff = new StringBuffer();

        // StringBuilder 동기화 미지원
        StringBuilder strBuild = new StringBuilder();

        Thread thA = new Thread(() -> {
           for (int i = 0; i < 50000000; i++){
               strBuild.append("금");
           }
        System.out.println("A " +strBuild.length());
        });

        Thread thB = new Thread(() -> {
            for (int i = 0; i < 50000000; i++){
                strBuild.append("금");
            }
        System.out.println("B " +strBuild.length());
        });

        thA.start();
        thB.start();

        System.out.println(strBuild.length());

    }
}
