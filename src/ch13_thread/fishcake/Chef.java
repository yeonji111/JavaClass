package ch13_thread.fishcake;

public class Chef extends Thread{


    @Override
    public void run() {
        // FishCake 내의 makeFishCake() 를
        // 2초마다 반복 실행 예정
        FishCake fishCake = FishCake.getInstance(); // 202호
        for(int i = 0; i < 10; i++){

            fishCake.makeFishCake();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
