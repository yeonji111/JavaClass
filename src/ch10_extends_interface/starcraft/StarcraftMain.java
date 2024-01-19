package ch10_extends_interface.starcraft;

import ch10_extends_interface.simple.Parent;

import java.util.ArrayList;

public class StarcraftMain {

    public static void main(String[] args) {
        Marine marine = new Marine("마린", 200, 10, 0, 0, 1);
        System.out.println(marine);

        Marine marine2 = new Marine();
        System.out.println(marine2);

        marine.move(10, 30);
        marine.stimpack();
        System.out.println(marine);

        Zealot zealot = new Zealot("질럿", 240, 240, 16, 1, 0, 1);
        Zealot zealot2 = new Zealot();
        Zealot zealot3 = new Zealot();
        Zealot zealot4 = new Zealot();
        Zealot zealot5 = new Zealot();
        Zealot zealot6 = new Zealot();

        System.out.println(zealot2);

        HighTemplar highTemplar = new HighTemplar();
        highTemplar.psionicStorm();

        // 테란 본진(x: 100, y:200)에 쳐들어가기
//        zealot.move(100,200);
//        zealot2.move(100,200);
//        zealot3.move(100,200);
//        zealot4.move(100,200);
//        zealot5.move(100,200);
//        zealot6.move(100,200);

        // 드래그해서 한번에 이동시키기
        ArrayList<Zealot> zealotList = new ArrayList<>();
        zealotList.add(zealot);
        zealotList.add(zealot2);
        zealotList.add(zealot3);
        zealotList.add(zealot4);
        zealotList.add(zealot5);
        zealotList.add(zealot6);

        for (int i = 0; i < zealotList.size(); i++) {
            zealotList.get(i).move(200, 300);
        }

        // 하이템플러도 같이 출동
        // ArrayList<Zealot>에 HighTemplar 객체를 담을 수 없음
//        zealotList.add(highTemplar);

        // 다형성 (Polymorphism)
        // 하나의 객체가 여러 타입을 가질 수 있는 성질

        // 기본적으로 자식 객체에서 부모 객체로 형변환이 가능하다.
        // zealot 객체가 Zealot 타입에서 StarUnit 타입으로 자동형변환
        StarUnit starZealot = zealot;
        StarUnit starHigh = highTemplar;

        // StarUnit을 담을 수 있는 ArrayList
        ArrayList<StarUnit> starList = new ArrayList<>();
        starList.add(starZealot);
        starList.add(zealot2); // Zealot -> StarUnit으로 자동 형변환되어 담김
        starList.add(zealot3);
        starList.add(zealot4);
        starList.add(zealot5);
        starList.add(zealot6);
        starList.add(highTemplar);

        for (int i = 0; i < starList.size(); i++){
            starList.get(i).move(50,150);
        }

        // 마린에 attack 메소드 추가
        marine.attack(zealot);
        System.out.println(zealot);

        marine.attack(highTemplar);
        System.out.println(highTemplar);

        System.out.println("\n========================\n");

        // 하이템플러는 starList.get(6)
        System.out.println(starList.get(6));

        // starList.get(6) 은 HighTemplar 타입이었던 highTemplar
        // 객체가 StarUnit으로 변경된 상태
//        starList.get(6).psionciStorm();

        // starList.get(6)에 대해 StarUnit -> HighTemplar
        // 로 되돌려 주어야 사이오닉스톰 사용 가능


        // (HighTemplar) // starList.get(6).psionicStorm(); 으로 나뉨
        ((HighTemplar)starList.get(6)).psionicStorm();

        // Zealot -> StarUnit로 바뀐 객체를 HighTemplar로 형변환 불가 !!!!!!!!!!!!!!!!!!!
//        ((HighTemplar)starList.get(0)).psionicStorm();  ---- 런타임 에러를 일으킴

        // 리스트 안에 있는 요소에 대해
        // 원래 어떤 객체(타입)이었는지 체크하기
        starList.add(marine);

        for (int i = 0; i < starList.size(); i++){
            // 하이템플러를 찾아서 사이오닉스톰을 실행
            if (starList.get(i).getName().equals("하이템플러")){
                ((HighTemplar)starList.get(i)).psionicStorm();
            }

            // 객체 instanceof 클래스
            // 좌측의 객체가 우측의 클래스 타입으로 형변환이 가능하다면 true
            // 가능하지않으면 false
            if (starList.get(i) instanceof HighTemplar){
                ((HighTemplar)starList.get(i)).psionicStorm();
            }

            // 1번. instanceof를 이용하여 마린을 찾아 스팀팩 사용
            if (starList.get(i) instanceof Marine){
                ((Marine) starList.get(i)).stimpack();
            }

            // 2번. .equals를 이용하여 마린을 찾아 스팀팩 사용
            if (starList.get(i).getName().equals("마린")){
                ((Marine) starList.get(i)).stimpack();
            }

        }

        System.out.println("\n====================\n");

        // 부모 객체 생성
        StarUnit star = new StarUnit();

        // 일반적으로 부모 객체는 자식 클래스로 형변환할 수 없다.
        System.out.println( star instanceof Marine);
        System.out.println( star instanceof Zealot);
        System.out.println( star instanceof HighTemplar);

        // 일반적으로 자식 객체는 부모 클래스로 형변환이 가능하다.
        System.out.println( marine instanceof StarUnit);
        System.out.println( zealot instanceof StarUnit);
        System.out.println( highTemplar instanceof StarUnit);

        // 부모 클래스로 형변환 되었던 자식 객체는
        // 다시 자식 클래스로 형변환이 가능하다.
        StarUnit temp = marine;
        System.out.println(temp instanceof Marine);

        StarUnit temp2 = new Marine();
        System.out.println(temp2 instanceof Marine);









    }

}
