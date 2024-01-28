package ch13_thread;

public class ThreadMain {

    public static void main(String[] args) {
        // 20에서 25까지 차례대로 출력
//        printNum(20);


        // 100부터 105까지 차례대로 출력
//        printNum(100);

        // 기본적으로 멀티스레드를 구현하지 않으면
        // 스레드 하나만(메인 스레드) 일을 하므로
        // 위에서부터 차례대로 코드가 한줄씩 실행된다.(= 동기)

        System.out.println("\n=================================\n");

        // 1. Thread를 상속받은 클래스를 이용하여 멀티스레드 구현
        MyThread myTh = new MyThread(10);

        // 메인 스레드가 아닌 다른 스레드에게
        // MyThread 내 run 메소드를 실행시킴 .start()
        myTh.start(); // 스레드 B

        // 위에서부터 차례대로 코드가 실행되지 않고 동시에 실행됨(= 비동기)
//        printNum(30); // 메인 스레드

        MyThread myTh2 = new MyThread(30);
        myTh2.start(); // 스레드 C

        // 기본적으로 멀티스레드를 구현하였을때
        // 다른 스레드에게 일을 던지면
        // 일의 순서를 알 수 없다. 언제 끝날지 모른다.

        // 2. Runnable 인터페이스를 구현(implement)한 클래스 이용
        MyRunnable myRun = new MyRunnable(70);

        // Thread 클래스 내의 .start()를 실행해야 함
        Thread th = new Thread(myRun);
        th.start();

        // 3. 람다식 사용
        Thread lamda = new Thread(new Runnable() {
            @Override
            public void run() {
                printNum(90);
            }
        });
        lamda.start();


        Thread realLamda = new Thread(() -> printNum(130));
        realLamda.start();




    }

    static void printNum(int num) {
        for (int i = num; i <= num + 5; i++) {
            System.out.println(i);

            // 0.5초마다 출력되도록
            try {
                // 실행에 텀을 주고 싶을때 사용
                // sleep() 안에 숫자는 밀리초 단위
                // 이 코드를 직접 실행한 Thread만 밀리초만큼 잠에 든다.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
