package ch09_class.school;

public class Fish {

    String fishName;
    int fishPrice;


    public Fish(String fishName, int fishPrice) {
        this.fishName = fishName;
        this.fishPrice = fishPrice;
    }

    @Override
    public String toString() {
        return fishName
                + fishPrice
                ;
    }

    // 생선 이름, 가격 꺼내기
    public String getFishName() {
        return fishName;
    }

    public int getFishPrice() {
        return fishPrice;
    }


}
