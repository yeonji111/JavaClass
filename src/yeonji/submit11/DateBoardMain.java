package yeonji.submit11;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Comparator.comparing;

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
        System.out.println("\n=================최신순 정렬===================\n");
        dbList.sort(comparing(DateBoard::getDate).reversed());
        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }

//        Collections.sort(dbList, new Comparator<DateBoard>() {
//            @Override
//            public int compare(DateBoard o1, DateBoard o2) {
//                if (o1.getDate(). == o2.getDate())
//                    return 0;
//                else if(o1.getDate()) > o2.getDate()){
//                    return 1;
//                } else return -1;
//            }
//        });


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
        System.out.println("\n=================오래된 순====================\n");
        // 과거순 정렬
        dbList.sort(comparing(DateBoard::getDate));
        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i));
        }


        System.out.println("\n=================최근 한달 내====================\n");
        // todo 최근 한달 내 (오늘 기준 30일전까지)
        //  오늘 - 30일전 밀리세컨드를 계산하고 그 사이만

        String oneMonth = "2023.12.22 21:22:00";
        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        Date oneDate = sdf.parse(oneMonth);
        Date today = new Date(); // 오늘 1705925960821

        System.out.println(today.getTime());
        System.out.println(oneDate.getTime()); // 한달 전 1703247720000

        long diffMillSec = today.getTime() - oneDate.getTime();
        System.out.println(diffMillSec); // 2678599408

        boolean check = true;
        while (true) {
            dbList.sort(comparing(DateBoard::getDate).reversed());
            for (int i = 0; i < dbList.size(); i++) {
                long time = oneDate.getTime();
                long date = Long.parseLong(dbList.get(i).getDate());
                if (date < time) {
                    check = false;
                }
                System.out.println(dbList.get(i));
            }

        }
        //이번달 출력
        //System.out.println("\n=================이번달 출력====================\n");
        String firstMonth = "2024.01.01 00:00:00";
        Date firMonDate = sdf.parse(firstMonth);

        System.out.println(firMonDate);
        System.out.println(firMonDate.getTime()); // Date 사용할것

        while (dbList.get() > firMonDate.getTime()){

        }


    }
}






