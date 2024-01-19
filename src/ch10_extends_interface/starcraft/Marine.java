package ch10_extends_interface.starcraft;

public class Marine extends  StarUnit{
//    private String name;
//    private int hp;
//    private int damage;
//    private int armor;
//    private int kill;
//    private int moveSpeed;

    public Marine() {
        this("마린", 200,10,0,0,1);
    }

    public Marine(String name, int hp, int damage, int armor, int kill, int moveSpeed) {
        super(name, hp, damage, armor, kill, moveSpeed);
//        this.name = name;
//        this.hp = hp;
//        this.damage = damage;
//        this.armor = armor;
//        this.kill = kill;
//        this.moveSpeed = moveSpeed;
    }

    // 이동 메소드
//    public void move(int x, int y){
//        System.out.println("좌표: " + x + ", " + y + "로 이동하였습니다.");
//    }

    // 공격 메소드
    // 다형성 이용

    public void attack(StarUnit enemy){
        System.out.println("투두두둥");
        enemy.setHp( enemy.getHp() - super.getDamage() );
    }

//    public void attack(HighTemplar enemy){
//        System.out.println("투두두둥");
//        enemy.setHp( enemy.getHp() - super.getDamage() );
//    }

    // 스팀팩 스킬
    public void stimpack(){
        System.out.println("으어어어어!!");
        // 200 - 10 = 190
//        super.hp -= 10;
        // getter, setter를 이용한 체력 감소
        super.setHp(super.getHp() - 10);
//        this.moveSpeed *= 2;
        super.setMoveSpeed( super.getMoveSpeed() * 2);
    }

    @Override
    public String toString() {
        return "Marine{" + super.toString();
    }


}
