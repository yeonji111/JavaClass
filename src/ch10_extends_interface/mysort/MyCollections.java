package ch10_extends_interface.mysort;

import ch09_class.school.Student;
import yeonji.submit11.DateBoard;

import java.util.ArrayList;
import java.util.Date;

public class MyCollections {

    // 어떤 객체가 들어오든지 대처할 수 있도록
    // 객체의 타입 부분에 T를 표기한다.
    // T를 사용하는 메소드의 경우, 리턴타입 앞에 <T>를 추가해준다.
    public static <T> void mySort(ArrayList<T> list, MyComparator<T>comp){

        for (int j = 0; j < list.size() -1; j++) {
            for (int i = 0; i < list.size() - 1-j; i++) {
                // if문 안에 true 혹은 false가 되는 기준을 알아야 한다.
                // mySort를 사용하는 곳에서 기준을 알려줄 수 있도록
                // 해당 자리에 인터페이스의 추상 메소드를 삽입
                if (comp.myCompare(list.get(i), list.get(i+1))) {
                    // 파라미터로 들어온 타입 T가 적용됨
                    T tmp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, tmp);
                }
            }
        }

    }


}
