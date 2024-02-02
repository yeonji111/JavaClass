package yeonji.worldcup;


/* FoodDB의 기본생성자, getter, setter, toString 만들어둔 클래스 */

public class Food {
    private String foodName; /* 이상형 월드컵 음식 이름*/

    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                '}';
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
