package ch09_class.nextit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class NextitMain {
    public static void main(String[] args) {
        String ghName = "건희";
        int ghLevel = 1;
        int ghExp = 20;

        String twName = "태완";
        int twLevel = 1;
        int twExp = 10;

        // 하루가 지나서 경험치가 오른다.
        ghExp += 30;
        twExp += 30;

        // 이틀이 지남
        ghExp += 30;
        twExp += 30;

        // 삼일이 지남
        ghExp += 30;
        twExp += 30;

        // 경험치가 100 이상이 되면 레벨업
        if (ghExp >= 100){  // 110
            ghLevel ++;

            ghExp %= 100;  // 10

        }

        if (twExp >= 100){
            twLevel ++;

            twExp %= 100;
        }

        // 상태 확인
        System.out.println(ghName);
        System.out.println(ghLevel);
        System.out.println(ghExp);

        System.out.println(twName);
        System.out.println(twLevel);
        System.out.println(twExp);


        System.out.println("\n============= 클래스를 이용한 방법 ==============\n");

        // 클래스로부터 객체 생성
        NextStudent yuna = new NextStudent();


        System.out.println(yuna);  // ch09_class.nextit.NextStudent@4eec7777

        // 생성된 객체의 속성(=필드변수)에 접근
        System.out.println(yuna.name);
        System.out.println(yuna.level);
        System.out.println(yuna.exp);

        // 필드 변수에 값을 담아주지 않으면
        // 생성된 객체의 필드 변수들은 초기값(default)을 가지고 있음
        // 숫자: 0, boolean: false, 참조타입: null

        // 필드변수에 값 담기
        yuna.name = "유나";
        yuna.level = 1;
        yuna.exp = 30;

        System.out.println(yuna);

        System.out.println(yuna.name);
        System.out.println(yuna.level);
        System.out.println(yuna.exp);


        // 두번째 객체 생성
        NextStudent yeonji = new NextStudent();

        System.out.println(yeonji); // ch09_class.nextit.NextStudent@3b07d329

        yeonji.name = "연지";
        yeonji.level = 1;
        yeonji.exp = 20;

        // 하루가 지남
        yuna.exp += 30;
        yeonji.exp += 30;

        // 하루가 지날때마다 경험치 확인 후 레벨업
        if (yuna.exp >= 100){
            yuna.level ++;
            yuna.exp %= 100;
        }

        if (yeonji.exp >= 100){
            yeonji.level ++;
            yeonji.exp %= 100;
        }

        // 이틀이 지남
        yuna.exp += 30;
        yeonji.exp += 30;
        if (yuna.exp >= 100){
            yuna.level ++;
            yuna.exp %= 100;
        }

        if (yeonji.exp >= 100){
            yeonji.level ++;
            yeonji.exp %= 100;
        }

        // 삼일이 지남..
        yuna.afterOneDay();
        yeonji.afterOneDay();

        // 객체를 println에 넣었을때
        // 필드변수 값들을 한번에 보고자 한다면
        // 클래스 내부에 toString을 만들어주면 된다.
        // println 에 객체를 넣게 되면 객체의 toString()
        // 실행 결과가 출력된다.
        // toString() 을 우리가 따로 만들어주지 않으면
        // 기본적으로 toString()은 @3b07d329의 형태를 리턴한다.

        System.out.println(yuna);
        System.out.println(yeonji);


        // 세번째 객체
        NextStudent yongseok = new NextStudent();

        yongseok.name = "용석";
        yongseok.level = 1;
        yongseok.exp = 10;

        // 한번에 3일이 지났습니다.

        yuna.afterOneDay();
        yeonji.afterOneDay();
        yongseok.afterOneDay();

        yuna.afterOneDay();
        yeonji.afterOneDay();
        yongseok.afterOneDay();

        yuna.afterOneDay();
        yeonji.afterOneDay();
        yongseok.afterOneDay();

        // 동일한 클래스로부터 생성된 객체들은
        // 같은 속성(필드변수)과 메소드를 가지고 있으나,
        // 속성의 값은 개별적이다.
        System.out.println(yuna);
        System.out.println(yeonji);
        System.out.println(yongseok);


        // 짝꿍에 대한 객체 생성
        NextStudent hh = new NextStudent();

        hh.name = "회환";
        hh.level = 1;
        hh.exp = 20;

        hh.afterOneDay();
        System.out.println(hh);


        System.out.println("\n====================\n");

        // 필드변수 값을 입력 받을 수 있는 생성자(Constructor)로
        // 객체 생성하기
        // new NextStudent() 에서 NextStudent() 을 생성자라고 부른다.
        // 파라미터를 입력받지 않는 생성자를 기본 생성자라고 부른다.
        NextStudent miseung = new NextStudent("미승", 1, 40);

        System.out.println(miseung);


        // 학생 객체 두명 더 생성
        NextStudent geonhui = new NextStudent("건희", 1, 20);
        NextStudent heseong = new NextStudent("해성", 1, 30);

        // 생성자를 추가해서 levle = 1을 기본값으로 설정하기
        // (굳이 level에 대한 값을 입력하지 않아도 되게끔)
        NextStudent seunghwan = new NextStudent("승환", 20);
        System.out.println(seunghwan);

        // 생성자를 추가해서 파라미터로 이름만 입력하기
        // (level은 1, exp는 10이 기본적으로 부여되도록 하기)
        NextStudent changhun = new NextStudent("창훈");
        System.out.println(changhun);

        // 객체의 복사
        NextStudent changhunBot = changhun;
        System.out.println(changhunBot);

        changhunBot.name = "창훈봇";
        System.out.println(changhunBot);

        // 메모리 주소가 다르고, 필드변수값은 동일한 객체 만들기
        NextStudent robot = new NextStudent(changhun.name, changhun.level, changhun.exp);
        System.out.println(robot);

        robot.name = "로봇";
        System.out.println(changhun);

        // 하루가 지났습니다.
        yuna.afterOneDay();
        yeonji.afterOneDay();
        yongseok.afterOneDay();
        hh.afterOneDay();
        heseong.afterOneDay();

        // 이틀이 지났습니다.
        yuna.afterOneDay();
        yeonji.afterOneDay();
        yongseok.afterOneDay();
        hh.afterOneDay();
        heseong.afterOneDay();


        // 여러개의 객체를 한번에 다루기
        ArrayList<NextStudent>  stuList = new ArrayList<>();

        stuList.add(yuna);
        stuList.add(yeonji);
        stuList.add(yongseok);
        stuList.add(hh);
        stuList.add(heseong);

        System.out.println(stuList);

        for (int i = 0; i < stuList.size(); i++){
//            System.out.println(stuList.get(i));
            System.out.println(stuList.get(i).name);
        }

        // 하루가 지났습니다.
        for (int i = 0; i < stuList.size(); i++){
            stuList.get(i).afterOneDay();
        }

        // 향상된 for문 사용
        for(  NextStudent stu : stuList  ){
            stu.afterOneDay();
        }

        // 10일이 한번에 지난다.
        for(int i = 0; i < 10; i++){
            for ( NextStudent stu : stuList){
                stu.afterOneDay();
            }
        }

        // 굳이 객체를 변수에 담은 후 리스트에 추가하지 않아도 된다.
        NextStudent hyeonggu = new NextStudent("형구");
        stuList.add(hyeonggu);

        stuList.add(new NextStudent("성구"));


        System.out.println("\n=========== 150일이 지난 상태 확인 ===========\n");
        // 150일이 지나게 하고
        // 아래와 같이 출력되도록 하기
        // 유나 Lv. 15 (20%)
        // 연지 Lv. 14 (45%)

//
//        for (int i = 0; i < 150; i++) {
//            for (NextStudent stu : stuList) {
//                stu.afterDays();
//            }

//        }
        for (int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i).name + "Lv." + stuList.get(i).level + " (" + stuList.get(i).exp + "%)");
        }


        System.out.println("\n========= 정렬 ===========\n");
//        stuList에 담겨있는 학생들의 레벨을 기준으로 정렬
//         버블정렬 알고리즘 (내림차순)
        int temp = 0;
        for (int j = 0; j < stuList.size() -1; j++) {
            for (int i = 0; i < stuList.size() - 1-j; i++) {

                if (stuList.get(i).level < stuList.get(i+1).level) {
                    NextStudent tmp = stuList.get(i);
                    stuList.set(i, stuList.get(i+1));
                    stuList.set(i+1, tmp);
                }
            }
        }
        // 등수와 함께 출력
        for (int i = 0; i < stuList.size(); i++){
            System.out.println((i+1)+"등." + stuList.get(i).name + "Lv." + stuList.get(i).level + " (" + stuList.get(i).exp + "%)");
        }

        System.out.println("\n===========================\n");

        // Collections.sort
        // if(stuList.get(i) < stuList.get(i+1)) 와 같은 상황
        // 정렬의 기준이 없으므로 정렬이 안됨.
        // -> 정렬의 기준을 알려주면 정렬이 됨
        Collections.sort(stuList, new Comparator<NextStudent>() {
            // stuList의 왼쪽 객체가 stuA로, 오른쪽 객체가 stuB로 들어옴

            @Override
            public int compare(NextStudent stuA, NextStudent stuB) {
                // 정렬의 기준을 return 되는 정수가 양수인지 음수인지로 알려준다
                // 왼쪽 stuA의 level에서 오른쪽 stuB의 level을 뺀 값이
                // 양수인지 음수인지에 따라 내부적으로 자리가 바뀐다.
                // stuA.level - stuB.level : 오름차순
                // stuB.level - stuA.level : 내림차순
                return stuA.level - stuB.level;
            }
        });
        // 등수와 함께 출력
        for (int i = 0; i < stuList.size(); i++){
            System.out.println((i+1)+"등." + stuList.get(i).name + "Lv." + stuList.get(i).level + " (" + stuList.get(i).exp + "%)");
        }


        // 람다식 사용
       Collections.sort(stuList, (stuA, stuB) -> stuA.level - stuB.level );  // 오름차순
       Collections.sort(stuList, (stuA, stuB) -> {
           return stuA.level - stuB.level;

       });  // 오름차순


    }
}
