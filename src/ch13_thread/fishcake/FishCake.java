package ch13_thread.fishcake;

public class FishCake {
    public FishCake() {
    }

    private static FishCake instance = new FishCake();

    public static FishCake getInstance(){
        return instance; // 202호
    }

    // 붕어빵의 수량
    int count = 0;

    // 붕어빵 굽기 (= Chef 클래스가 사용 예정)
    // wait() 나 notify() 등의 동기화 전용 메소드를 사용하기 위해
    // 해당 메소드에 synchronized 를 붙여준다.

    public synchronized void makeFishCake() {
        count++;
        System.out.println("붕어빵을 하나 구웠습니다. 수량: " + count);

        // wait set에서 대기중인 임의의 스레드를 하나 깨운다.
        notify();

        // wait set에서 대기중인 모든 스레드를 깨운다.
        // -> 실용성이 낮음
//        notifyAll();
    }

    // 붕어빵 구매 (= Customer 클래스가 사용 예정)
    // num은 손님이 구매하고자 하는 수량
    // count가 메소드에 따라 변화되어야하므로 sychronized 추가
    public synchronized void buyFishCake(int num) {
        // 붕어빵의 수량이 구매하고자 하는 개수보다 적은 경우.
        // 해당 쓰레드를 대기시킨다.
        if (num > count) {
            try {
                // wait()를 실행한 스레드는
                // 다른 스레드에서 notify()로 깨울때까지
                // 대기 상태에 놓인다.
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 대기에서 풀려나면 다시 구매시도
            buyFishCake(num);

        } else {
            count -= num;
            System.out.println("붕어빵을 " + num + "개 구매하였습니다.");
            System.out.println("남은 수량: " + count);
        }
    }

}


