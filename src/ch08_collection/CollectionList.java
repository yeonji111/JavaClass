package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class CollectionList {

    public static void main(String[] args) {
        // 리스트 (List)

        // 리스트 객체 선언 -----  ArrayList < 타입 > 변수명(=객체) = new ArrayList < 타입 > ( );
        String[] strArr = new String[10];
        String str = new String();
        ArrayList<String> students = new ArrayList<String>();
        ArrayList<String> students2 = new ArrayList<>(); // new ArrayList의 제너릭안에 타입을 적지 않아도 됨

        // 다형성을 이용한 선언
        List<String> students3 = new ArrayList<>();


        // <> 제너릭 안에는 참조타입 객체만 담을 수 있다.
        // 기본타입을 담으려면 Wrapper Class를 이용해야한다.
        // Wrapper Class는 기본 타입의 데이터를 참조 타입의 객체로
        // 사용해야하는 경우 이용한다.

        ArrayList<Integer> intList = new ArrayList<>(); // int 타입(기본타입)은 Integer을 사용해야함.

        // 기본 타입 데이터를 Wrapper Class 객체로 변환
        // = 박싱(boxing)
        // deprecated : 현재 또는 이후 지원 종료를 의미한다.
//        Integer numObject = new Integer(30);

        // = 오토박싱(auto boxing)
        Integer numObj = 30;
        System.out.println(numObj);
        System.out.println(numObj + 7); // int와 차이점 느끼기 힘듬

        // Wrapper class에 저장된 값을
        // 기본 타입으로 꺼내기
        // = 언박싱(unboxing)
        int num = numObj.intValue();
        System.out.println(num);


        // 오토 언박싱
        num = numObj;
        System.out.println(num);

        // 오토박싱과 오토언박싱이 자동으로 이루어지기 때문에
        // 기본타입에 대해 Wrapper Class를 이용한다해도
        // 아무런 불편함을 느낄 수 없음.

        System.out.println("\n================================\n");


        // ArrayList의 크기 확인
        // .size()
        System.out.println(intList.size()); // 안에 값이 들어가있는 갯수 확인
        System.out.println(intList);

        // ArrayList에 값 담기
        // .add()
        intList.add(10);
        System.out.println(intList.size()); // intList.add(10)으로 하나를 담았으므로 1 출력
        intList.add(20);

        // 배열과 달리 컬렉션은 println()에 찍어보면
        // 내부 요소들이 잘 출력 된다.
        System.out.println(intList); // [20, 10] 배열이 출력됨

//        값을 한번에 여러개 넣는것은 불가능하다.
//        intList.add(30,40);
//        System.out.println(intList);
        intList.add(30);
        intList.add(40);

        // 제너릭<> 타입과 일치하지 않은 데이터는 추가 불가능
//        intList.add("받아줘");
//        intList.add(3.14);

        System.out.println("\n======================\n");

        ArrayList<String> stuList = new ArrayList<>();
        stuList.add("건희");
        stuList.add("태완");
        stuList.add("정현");
        stuList.add("승환");
        stuList.add("해성");
        stuList.add("유나");

        // [건희, 태완, 정현, 승환, 해성, 유나]
        // add 를 실행한 순서에 맞게 데이터가 들어가 있음
        // 인덱스 0 : 건희, 인덱스 1: 태완, ...

        System.out.println(stuList);

        // 리스트의 인덱싱
        // .get(인덱스)
        System.out.println(stuList.get(3)); // stuList.get(3) 이 '문자열' 승환을 출력
        System.out.println(stuList.get(3).substring(0,1)); // 그러므로 문자열인 승환을 .substring으로 문자열 자르기가 가능

        // 해당 인덱스에 있는 값 변경
        // intArr[2] = 6;
        // .set(인덱스, 변경할 값)
        stuList.set(3, "형구");
        System.out.println(stuList);


        // .isEmpty()
        // 리스트가 비어있으면 true, 아니면 false 리턴
        // .size() == 0 과 같음
        System.out.println(stuList.isEmpty());

        // .remove(인덱스)
        // 해당 인덱스에 있는 데이터를 삭제
        System.out.println(stuList.get(2)); // 정현
        stuList.remove(2);
        System.out.println(stuList);
        System.out.println(stuList.get(2)); // 인덱스 2번이 삭제된 후, 삭제된 인덱스 뒷 부분이 앞당겨진다.

        // .clear()
        // 리스트를 비움 (size가 0이 됨)
        stuList.clear();
        System.out.println(stuList);


        // 리스트를 초기화(Init)
        stuList = new ArrayList<>();
        System.out.println(stuList);

        System.out.println("\n===========================\n");

        stuList.add("건희");
        stuList.add("태완");
        stuList.add("정현");
        stuList.add("승환");
        stuList.add("해성");
        stuList.add("유나");

        System.out.println(stuList);

        // for문으로 ArrayList 내부요소 접근, 제어
        // 학생 이름 앞에 넘버링 추가
        // 1. 건희
        for(int i = 0; i < stuList.size(); i++){
            System.out.println((i+1) + "." + " " + stuList.get(i)); // 내가 한 버전) 출력만 넘버링이 되게 함, 원본은 건드리지않음

            stuList.set(i, (i+1) + ". " + stuList.get(i)); // .set을 넣어 배열 안에 담겨져있는 데이터 자체를 변경하는 코드
            System.out.println(stuList);

        }


        System.out.println("\n===========================\n");

        // 리스트의 정렬
        // 오름차순 정렬
        intList.add(7);
        intList.add(17);
        System.out.println(intList);

        Collections.sort(intList);

        System.out.println(intList);


        // 내림차순 정렬
        Collections.sort(intList, Collections.reverseOrder());

        System.out.println(intList);

        // 버블정렬 알고리즘을 이용한 정렬 (내림차순)
        int temp = 0;
        for (int j = 0; j < intList.size() -1; j++) {
            for (int i = 0; i < intList.size() - 1-j; i++) {

                if (intList.get(i) < intList.get(i+1)) {
                    // intList.get(i) -> Integer 타입
                    // -> int로 자동 언박싱이 됨
                    Integer tmp = intList.get(i);
                    intList.set(i, intList.get(i+1));   // .set을 사용해서 값을 적용했어야함.
//                    intList.get(i) = intList.get(i+1);
//                    intList.get(i+1) = tmp;
                    intList.set(i+1, temp);

                }
            }
        }
        System.out.println(intList);



        System.out.println("\n===========================\n");

        // 값을 부여하면서 리스트 선언
        ArrayList <Integer> numList = new ArrayList<>(Arrays.asList(32, 4, 65, 23, 11));
        System.out.println(numList);


        int[] numArr = {32, 4, 65, 23, 11};
        numList = new ArrayList<>();

        // 배열 내 요소 전부를 리스트에 옮기기
        for(int i = 0; i < numArr.length; i++){
            numList.add(numArr[i]);
        }
        System.out.println(numList);

        System.out.println("\n============= 리스트 복사 ==============\n");

        // 리스트 복사 첫번재 방법 .addAll()

//  올바르지 않은 복사법      ArrayList<Integer> copyList = numList;
        ArrayList<Integer> copyList = new ArrayList<>();

        // numList 내부 요소들이 전부 copyList에 복사된다.
        copyList.addAll(numList); // 빈 리스트명.addAll(복사하고자 하는 원본 리스트)

        System.out.println(copyList);

        // 리스트 복사 두번째 방법, 빈 리스트에 numList를 담는것
        ArrayList<Integer> copyList2 = new ArrayList<>(numList);
        System.out.println(copyList2);

        // 리스트 복사 세번째 방법,
        ArrayList<Integer> copyList3 = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++){
            copyList3.add(numList.get(i));
        }
        System.out.println(copyList3);
    }




}
