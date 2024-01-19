package ch10_extends_interface.lol;

import java.util.ArrayList;
import java.util.List;

public class lolMain {
    public static void main(String[] args) {
        Shen shen = new Shen();
        shen.skillQ();

        Sona sona = new Sona();
        sona.skillQ();


        // 다형성을 이용하여 인터페이스로 형변환 가능
        List<Sona> sonaList = new ArrayList<>();
        Skill sona2 = new Sona();
        // 해당 인터페이스를 implements 해야만 형변환이 가능하다.
//        Skill shne2 = new Shen();


        System.out.println(sona.name);
        // Skill 인터페이스로 형변환 했기 때문에
        // 인터페이스에 선언한 메소드만 사용 가능
        // 인터페이스에 name을 선언하지는 않았음(인터페이스에는 상수, 메소드만 선언 가능)
//        System.out.println(sona2.name);
        sona2.skillE();


    }
}
