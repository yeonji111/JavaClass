package ch10_extends_interface.simple;

import ch09_class.nextit.NextStudent;
import ch09_class.school.Student;

public class SimpleMain {

    public static void main(String[] args) {
        Parent hyeongman = new Parent("신형만", 30);

        // Object 클래스를 기본적으로 상속받고 있기 때문에
        // Parent 클래스에 toString을 만들지 않아도
        // 저절로 데이터의 주소를 출력해냄 :   ch10_extends_interface.simple.Parent@4eec7777
        System.out.println(hyeongman.toString());

        hyeongman.hello();
        hyeongman.work();

        Child jjanggu = new Child("짱구", 5, "떡잎유치원");

        // Parent{name='null', age=0}
        System.out.println(jjanggu); // Parent의 toString이 실행

        // 기본적으로 자식 클래스는 부모 클래스의 필드변수와
        // 메소드를 사용할 수 있다.
        jjanggu.hello();
        jjanggu.work();

        // 접근 제어자가 private인 필드변수와 메소드는
        // 상속을 받더라도 사용할 수 없다.

        Child jjangah = new Child("짱아",2, "백수");
        System.out.println(jjangah); // Child 클래스에서 Parent의 toString을 Override한 후, Child{name=짱아,age =2}

        jjangah.hello(); // Parent의 hello 메소드를 오버라이딩해서 안녕하세요. 어린이입니다. 출력
        jjangah.work();


        // 다형성 문제
        // 자식, 부모 간에는 형변환 가능하다.
//        NextStudent me = new NextStudent();
//        Student stu = (Student)me; // 기본적으로 객체 간 형변환은 불가능

        Parent adultJjangah = jjangah;
        System.out.println(adultJjangah); // 타입이 Parent이지만 본체인 Child가 출력, Child{name=짱아,age =2, school=백수}



        // 면접, 정처기 단골 문제
        // Parent에도 있고 Child에도 있는 메소드면 Child의 메소드 실행
        adultJjangah.hello();
        adultJjangah.work(); // Child에 work 메소드가 없기때문에 Parent에 선언해둔 메소드가 선언된다.








    }



}
