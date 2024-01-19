package ch10_extends_interface.starcraft;

public class Zealot extends StarUnit{
    private int shield;



    public Zealot() {
        this("질럿", 240, 240, 16, 1, 0, 1);
    }


    public Zealot(String name, int hp, int shield, int damage, int armor, int kill, int moveSpeed) {
        super(name, hp, damage, armor, kill, moveSpeed);
        this.shield = shield;
    }


    @Override
    public String toString() {
        return "Zealot{" + super.toString();
    }

    // 부모클래스인 StarUnit에 없는 shield만 남기기
    public int getShield() {
        return shield;
    }
    public void setShield(int shield) {
        this.shield = shield;
    }



}

