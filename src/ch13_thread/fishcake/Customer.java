package ch13_thread.fishcake;

public class Customer extends Thread{

    private int num; /* 구매하고자 하는 수량 */

    public Customer(int num) { // 구매하고자 하는 수량(num)의 기본생성자
        this.num = num;
    }

    @Override
    public void run() {
        FishCake fishCake = FishCake.getInstance(); // 202호

        fishCake.buyFishCake(num);

    }
}
