package ch09_class.school;

import ch09_class.common.MyUtil;
import ch09_class.nextit.NextStudent;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SchoolMain {

    public static void main(String[] args) {
        // 학교의 학생 성적 입력, 관리하는 프로그램 만들 예정
        // 각 학생에 대해 객체로 만들어서 써야겠다.
        // 학생은 이름, 국어, 영어, 수학, 평균을 가진다.
        // 학생에 대한 객체를 클래스로 정의내려야겠다.

        Student seonggu = new Student();
        System.out.println(seonggu); // @4eec7777
        System.out.println(seonggu.toString());

        Student uicheol = new Student("의철",80, 87, 78, ((80+87+78)/3.0));
        System.out.println(uicheol);

        NextStudent hoppang = new NextStudent("호빵맨");

        // 필드변수의 접근제어자가 default거나 public이면
        // 점(.) 찍고 직접 접근 가능 (같은 클래스니까)
//        System.out.println(uicheol.name);
        System.out.println(uicheol.getName()); //  getName이라는 메소드를 만들어서 이름만 꺼냄
                                                // uicheol.getName() = "정의철" 같은 변수값 수정불가
      System.out.println(uicheol.getKor());
      System.out.println(uicheol.getEng());
      System.out.println(uicheol.getAvg());
//        System.out.println(uicheol.kor);


        // 직접 수정도 가능
//        uicheol.name = "정의철";
        uicheol.setName("정의철");
        System.out.println(uicheol);

//        uicheol.kor = 95;
        uicheol.setKor(95);
        System.out.println(uicheol);

        // 평균을 직접 수정한다는 것은 말이 안됨
        // = 직접 수정하지 못하게 만들면 그만
        // = setAvg 없애면 그만
//        uicheol.setAvg(99.99);
//        System.out.println(uicheol);


        // 두명의 학생 객체
        Student yeonji = new Student("연지",90,70,90,(90+70+90)/3.0);
        Student jiin = new Student("지인",90,80,95,(90+80+95)/3.0);

        // 평균을 입력받지 않고 학생 객체 생성
        Student taewna = new Student("태완",77,68,86);
        System.out.println(taewna);


        // 일반적으로 클래스 내에 선언된 메소드는
        // 해당 클래스로부터 객체를 생성한 이후 접근해서 사용 가능

        // common 폴더에 MyUtil 클래스 생성
        // MyUtil 클래스 내부 myRound 메소드 사용
        MyUtil util = new MyUtil();
        System.out.println(util.myRound(yeonji.getAvg(), 2));

        // Math 클래스 내 메소드는
        // Math 를 객체로 생성하지 않아도 사용가능

        System.out.println(Math.random());
        System.out.println(Math.toRadians(180));

        // static이 붙어있는 필드변수와 메소드는
        // 해당 클래스를 객체로 생성하지 않아도 사용가능
        MyUtil.myRound(yeonji.getAvg(),2);
        System.out.println(MyUtil.myRound(yeonji.getAvg(),2));

        Student seunghwan = new Student("승환", 77,77,78);
        System.out.println(seunghwan);

        seunghwan.setEng(80);
        System.out.println(seunghwan);

        System.out.println("\n=======================\n");

        ArrayList<Student> stuList = new ArrayList<>();

        stuList.add(uicheol);
        stuList.add(yeonji);
        stuList.add(jiin);
        stuList.add(taewna);
        stuList.add(seunghwan);

        for(int i = 0; i < stuList.size(); i++){

        }

        // stuList에 담긴 학생들의 평균을 이용해서 정렬 후
        // 종합 성적표를 출력해보기
        // 1등. 지인, 국어: 90, 영어: 80, 수학: 95, 평균: 88.33
        // 2등. 정의철, 국어: 95, 영어: 87, 수학: 78, 평균: 86.67

        // 버블정렬
        for (int j = 0; j < stuList.size() -1; j++) {
            for (int i = 0; i < stuList.size() - 1-j; i++) {
                if (stuList.get(i).getAvg() < stuList.get(i+1).getAvg()) {
                    Student tmp2 = stuList.get(i);
                    stuList.set(i, stuList.get(i+1));
                    stuList.set(i+1, tmp2);
                }
            }
        }

        // Collections.sort 사용
//        Collections.sort(stuList, (stuA, stuB) -> stuA.getAvg() - stuB.getAvg());
        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student stuA, Student stuB) {
                // 단순히 int 형변환을 하면, 77.3과 77.8이 정렬 안됨
                int result = 1;
                if (stuA.getAvg() - stuB.getAvg() < 0){
                    result = -1; // stuB가 더 큰것
                }
                return result;
            }
        });

        // 람다식 사용
        Collections.sort(stuList, (stuA, stuB) -> {
            int result = 1;
            if (stuA.getAvg() - stuB.getAvg() < 0){
                result = -1; // stuB가 더 큰것
            }
            return result;
        });

        // 삼항연산자과 람다식을 사용한 정렬방법
        Collections.sort(stuList, (stuA, stuB) -> (stuA.getAvg() - stuB.getAvg() < 0)? -1 : 1 );


        for (int i = 0; i < stuList.size(); i++){
            System.out.println((i+1) + "등. " + stuList.get(i).toString());

        }





    }

}
