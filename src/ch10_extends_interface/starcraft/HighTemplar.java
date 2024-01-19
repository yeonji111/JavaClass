package ch10_extends_interface.starcraft;

public class HighTemplar extends StarUnit{

    private int shield;
    private int mp;

    public HighTemplar() {
        this("하이템플러", 40,40,0,0,0,1,200);
    }

    public HighTemplar(String name, int hp, int shield, int damage, int armor, int kill, int moveSpeed, int mp) {
       super(name, hp, damage, armor, kill, moveSpeed);
        this.shield = shield;
        this.mp = mp;
    }


    // 사이오닉 스톰
    public void psionicStorm(){
        System.out.println("파지지직!!");
        this.mp -= 75;
    }

    @Override
    public String toString() {
        return "HighTemplar{" + super.toString();
    }


    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
}
