package ch10_extends_interface.lol;

// 인터페이스는 implements 를 이용하여 구현한다.
// 상속선언할때 implements 앞에 extends를 붙여야함.
public class Sona extends Champion implements Skill, Voice{
    String name;
    int damage;
    int hp;

    @Override
    public void skillQ() {
        System.out.println("공격 음파");
    }

    @Override
    public void skillW() {
        System.out.println("회복 음파");
    }

    @Override
    public void skillE() {
        System.out.println("이동속도 음파");
    }

    @Override
    public void skillR() {
        System.out.println("기절 음파");
    }

    @Override
    public void ctrl1() {

    }

    @Override
    public void ctrl2() {

    }

    @Override
    public void ctrl3() {

    }

    @Override
    public void ctrl4() {

    }
}
