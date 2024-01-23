package yeonji.submit11;

import ch09_class.school.Student;
import ch10_extends_interface.mysort.MyCollections;
import ch10_extends_interface.mysort.MyComparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateBoardMain {

    public static void main(String[] args) throws ParseException {
        // dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
        ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        for (int i = 0; i < 100; i++) {
            int randDay = (int) (Math.random() * 365) + 1;        // 1~365
            Calendar cal = Calendar.getInstance(); // 오늘날짜
            cal.add(Calendar.DATE, randDay * -1); // 오늘날짜에서 1~365 중 랜덤한 일수를 뺀다.

            String strDate = sdf.format(cal.getTime());
            dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
        }

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }


        // TODO 코드작성 시작 ~!!

        System.out.println("\n=============== 최신순 정렬 ================\n");

        // 날짜순 정렬
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        for (int j = 0; j < dbList.size() - 1; j++) {
            for (int i = 0; i < dbList.size() - 1 - j; i++) {
                // dbList.get(i).getDate() -> "2023.10.23 12:00:00"
                // dbList.get(i+1).getDate() -> "2023.12.20 12:00:00"

                // 1. "2023.10.23 12:00:00" -> Date 객체로 변환
                // 2. Date 객체의 .getTime() 적용 -> long 타입 숫자

                // 1.
                Date leftDate = sdf.parse(dbList.get(i).getDate());
                Date rightDate = sdf.parse(dbList.get(i + 1).getDate());

                // 2.
                if (leftDate.getTime() < rightDate.getTime()) {
                    DateBoard tmp2 = dbList.get(i);
                    dbList.set(i, dbList.get(i + 1));
                    dbList.set(i + 1, tmp2);
                }
            }
        }
        // 최신순 정렬 확인용 찍어보기
        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }


        System.out.println("\n================= 과거순 순 ==================\n");

        MyCollections.mySort(dbList, (left, right) -> {

            try {
                Date leftDate = sdf.parse(left.getDate());
                Date rightDate = sdf.parse(right.getDate());

                return leftDate.getTime() > rightDate.getTime();

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        });

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

        System.out.println("\n================== 최근 한달 내 ============\n");

        // 30일 전
        // 3월 20일 기준으로 -> 2월 18일

        // 1. 오늘 날짜에 대한 long 타입 숫자에 30일 만큼의 long 타입 숫자를 뺀다.
        //      = 오늘로부터 30일 이전에 해당하는 long 타입 숫자 획득
        long berfore30 = System.currentTimeMillis() - (30L * 24 * 60 * 60 * 1000);
//        System.out.println(System.currentTimeMillis());
//        System.out.println(berfore30);
        // 2. dbList 내 DateBoard 에서 30일 이전 long타입 숫자보다 큰 것들만 출력

        for (int i = 0; i < dbList.size(); i++) {
            Date temp = sdf.parse(dbList.get(i).getDate());
//            System.out.println(temp.getTime());
            if (temp.getTime() >= berfore30) {
                System.out.println(dbList.get(i));
            }
        }

        // 3월 20일 기준으로 최근 한달 내? -> 2월 20일
        // 24.01.23
        Calendar cal = Calendar.getInstance();
        // 23.12.13
        cal.add(Calendar.MONTH, -1);

        // 23.12.13에 대한 long 타입 숫자
        long beforeMonth = cal.getTime().getTime();

        for (int i = 0; i < dbList.size(); i++) {
            Date temp = sdf.parse(dbList.get(i).getDate());
//            System.out.println(temp.getTime());
            if (temp.getTime() >= beforeMonth) {
                System.out.println(dbList.get(i));
            }
        }


        System.out.println("\n=========== 이번달 출력 ===========\n");

        Calendar calMonth = Calendar.getInstance();

        for (int i = 0; i < dbList.size(); i++) {
            Date temp = sdf.parse(dbList.get(i).getDate());
            // Date -> Calendar 변경
            Calendar tempCal = Calendar.getInstance();
            tempCal.setTime(temp);
            if (tempCal.get(Calendar.YEAR) == calMonth.get(Calendar.YEAR)
                    && tempCal.get(Calendar.MONTH) == calMonth.get(Calendar.MONTH)) {
                System.out.println(dbList.get(i));
            }

        }

        System.out.println("\n=========== 2023년 6월만 출력 ===========\n");

        for (int i = 0; i < dbList.size(); i++) {
            Date temp = sdf.parse(dbList.get(i).getDate());
            // Date -> Calendar 변경
            Calendar tempCal = Calendar.getInstance();
            tempCal.setTime(temp);
            if (tempCal.get(Calendar.YEAR) == 2023
                    && tempCal.get(Calendar.MONTH) == 6 - 1) {
                System.out.println(dbList.get(i));
            }

        }

        System.out.println("\n=========== 2023.07.14 ~ 2023.08.21===========\n");
        String before = "2023.07.14 00:00:00";
        String after = "2023.08.21 00:00:00";

        // SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy.MM.dd")

        Date beforeDate = sdf.parse(before);
        Date afterDate = sdf.parse(after);

        //      Date beforeDate = sdfYMD.parse(before);
        //      Date afterDate = sdfYMD.parse(after);

        for (int i = 0; i < dbList.size(); i++) {
            Date temp = sdf.parse(dbList.get(i).getDate());

            // beforeDate <= temp.getTime() <= afterDate

            if (beforeDate.getTime() <= temp.getTime()
                    && temp.getTime() <= afterDate.getTime()) {
                System.out.println(dbList.get(i));
            }

        }
    }
}


