package ch08_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionSet {
    public static void main(String[] args) {
        // Set은 우리가 직접적으로 만들어서 사용하는 경우는 드뭄
        // 하지만 사용법을 잘 알아두어야 한다.

        // 집합(Set -> HashSet)
        HashSet<String> stuSet = new HashSet<String>();
        HashSet<String> stuSet2 = new HashSet<>();

        // 다형성을 이용
        Set<String> stuSet3 = new HashSet<>();

        // .add()
        // 값 추가
        stuSet.add("해성");
        stuSet.add("유나");
        stuSet.add("창훈");

        // Set에 담겨있는 데이터에는 인덱스가 없으며
        // 순서 또한 존재하지 않는다.
        System.out.println(stuSet);

        // Set의 큰 특징
        // 중복된 값이 들어가지 않는다.
        stuSet.add("창훈");
        System.out.println(stuSet);

        // .contains(객체)
        // 괄호 안 객체가 Set 안에 있으면 true, 없으면 false
        System.out.println(stuSet.contains("유나"));

        // .size()
        // Set 내부 요소 개수 리턴
        System.out.println(stuSet.size());

        System.out.println("\n======== Set 내부 요소 순회 ==========\n");

        // Set 내부 요소 순회

        // 1. while문 사용 (인덱스가 없으므로 for문 사용 힘듦)
        Iterator<String> stuIter = stuSet.iterator();
        while (stuIter.hasNext()){
          String stu = stuIter.next();
            System.out.println(stu);
        }


        // 2. 향상된 for문 사용
        for ( String stu :  stuSet ) {
            System.out.println(stu);
        }


        // 3. forEach문 사용( + 람다식 사용)
        stuSet.forEach(s -> System.out.println(s));
        stuSet.forEach(stu -> System.out.println(stu));


        System.out.println("\n===========================\n");

        // Set의 중복을 허용하지 않는 특성을 이용한
        // 중복 제거


        // 정수를 담을 수 있는 ArrayList 선언
        ArrayList<Integer>intList = new ArrayList<>();

        // intList에 25부터 35 사이의 숫자 10개 넣기
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * 11) + 25;

            intList.add(rand);

        }
        System.out.println(intList);

        HashSet<Integer> intSet = new HashSet<>();


        // ArrayList의 값을 HashSet에 옮기기
        //  1. for문 이용
        for (int i = 0; i < intList.size(); i++) {
            intSet.add(intList.get(i));
        }
        System.out.println(intSet);


        intSet.clear();
        System.out.println(intSet);

        // 2. addAll() 이용
        intSet.addAll(intList);
        System.out.println(intSet);



        // 중복 제거가 된 intSet의 값들을 다시 List에 담아주기
        intList.clear();
        intList.addAll(intList);  // intSEt 내부 요소 -> intList
        System.out.println(intList); // 순서는 망가져 있다.








    }
}
