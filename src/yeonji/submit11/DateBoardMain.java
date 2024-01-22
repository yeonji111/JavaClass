package yeonji.submit11;

import ch09_class.school.Student;
import ch10_extends_interface.mysort.MyCollections;
import ch10_extends_interface.mysort.MyComparator;

import java.sql.Date;
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

        // 최신순 정렬
//        System.out.println(dbList);

      int temp = 0;
        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//        for (int j = 0; j < dbList.size() - 1; j++) { // 사이클 반복하면서 String타입인 날짜를 int타입으로 변환
//            // 밀리세컨드가 가장 큰것부터
//            for (int i = 0; i < dbList.size()-1-j; i++){
//                Date oneDate = sdf.parse(dbList.get(i).getDate());
//                Date twoDate = sdf.parse(dbList.get(i+1).getDate());
//                if (oneDate.getTime() < twoDate.getTime()){
//                    long tmp = oneDate.getTime();
//                    dbList.set(i, dbList.get(i+1));
//                    dbList.set(i+1, dbList.get(i));
//                }
//
//            }

        Comparator<DateBoard> comparator = (o1, o2) -> Long.valueOf(
                o1.getDate()
        )
        Collections.sort(dbList, (o1, o2) -> {

                return -1;
            }
            return 0;
        });





        }
        }


        // 과거순 정렬
        // 밀리세컨드가 가장 작은것부터


        // 최근 한달 내 (오늘 기준 30일전까지)
        //  오늘 - 30일전 밀리세컨드를 계산하고 그 사이만

        // 이번달 출력


    }


}
