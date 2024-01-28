package ch13_thread;

// 1. Runnable 인터페이스 구현
public class MyRunnable implements Runnable{

    private int range;

    public MyRunnable(int range) {
        this.range = range;
    }

    @Override
    public void run() {
        for(int i = range; i < range+5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
