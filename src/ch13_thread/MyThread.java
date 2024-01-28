package ch13_thread;

// 1. Thread를 상속 시킴
public class MyThread extends Thread{

    private int range;

    public MyThread(int range) {
        this.range = range;
    }

    // 2. Thread 클래스 내에 있는 run  메소드를
    //    Override 한다.(= 멀티스레드로 던질 일에 해당)
    @Override
    public void run() {
        for(int i = range; i < range+5; i++){
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
