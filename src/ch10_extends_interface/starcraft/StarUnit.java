package ch10_extends_interface.starcraft;

// 객체에 대한 클래스를 여러 개 만드는 과정에서
// 각 클래스들이 서로 공통된(중복된) 필드변수나 메소드를 가지고 있는 경우
// 이것들을 하나로 묶어줄 수 있는 클래스를 하나 만든다.
public class StarUnit {
    private String name;
    private int hp;
    private int damage;
    private int armor;
    private int kill;
    private int moveSpeed;

    public StarUnit() {
    }

    public StarUnit(String name, int hp, int damage, int armor, int kill, int moveSpeed) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.armor = armor;
        this.kill = kill;
        this.moveSpeed = moveSpeed;
    }

    // 이동 메소드
    public void move(int x, int y){
        System.out.println("좌표: " + x + ", " + y + "로 이동하였습니다.");
    }




    @Override
    public String toString() {
        return "StarUnit{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                ", armor=" + armor +
                ", kill=" + kill +
                ", moveSpeed=" + moveSpeed +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
