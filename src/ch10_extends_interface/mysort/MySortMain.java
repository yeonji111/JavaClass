package ch10_extends_interface.mysort;

import ch09_class.school.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MySortMain {
    public static void main(String[] args) {

        ArrayList<Student> stuList = new ArrayList<>();

        stuList.add(new Student("짱구", 78,75,84));
        stuList.add(new Student("훈이", 43,46,83));
        stuList.add(new Student("맹구", 42,55,62));
        stuList.add(new Student("철수", 78,59,28));
        stuList.add(new Student("유리", 75,47,39));

        for (int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

        System.out.println("\n=====================\n");
        // 버블 정렬 - 오름차순
        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAvg() - o2.getAvg() < 0){
                    return -1;
                }
                return 0;
            }
        });

        for (int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }



        // 버블 정렬 - 내림차순
        Collections.sort(stuList, (o1, o2) -> {
            if (o1.getAvg() - o2.getAvg() > 0){
                return -1;
            }
            return 0;
        });

        for (int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

        System.out.println("\n========================\n");

        // MyCollections.mySort와 new MyComparator<타입> 를 사용해서 오름차순 정렬
        MyCollections.mySort(stuList, new MyComparator<Student>() {
            @Override
            public boolean myCompare(Student left, Student right) {
                return left.getAvg() > right.getAvg();
            }
        });

        for (int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

        // MyCollections.mySort 와 람다식을 사용해서 내림차순정렬
        MyCollections.mySort(stuList, (left, right) -> left.getAvg() < right.getAvg());

        for (int i = 0; i < stuList.size(); i++){
            System.out.println(stuList.get(i));
        }

    }
}
