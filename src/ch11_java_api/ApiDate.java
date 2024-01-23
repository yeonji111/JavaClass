package ch11_java_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ApiDate {
    public static void main(String[] args) throws InterruptedException, ParseException {
        // API란? 완성된 코드를 가져다 쓰는 것
        // SDK란? 로직 정도는 만들어져 있는데 쓰려면 추가 개발이 필요

        // java api 파트는 JDK 라고 보면 된다.

        // 현재 시간 구하기
        // 1. Date 클래스 사용
        Date dateToday = new Date(); // 1)

        // Date 객체가 생성될 때 [= new Date()]
        // Date 객체 내부에 new Date()가 실행되었을 때의 시간이 저장된다.
        System.out.println(dateToday); // 2)

//        Thread.sleep(2000);

        System.out.println(dateToday); // 3) = 1)이 실행되었을때 담기는 시간이 출력된다.

        // 날짜 포맷을 이용하여
        // 2024-01-19 11:29:10 형태로 바꿔서 출력
        // yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // sdf.format(Date 객체)
        // Date 객체에 저장된 날짜를 지정한 날짜 포맷형식으로
        // 변환한 문자열을 리턴
        System.out.println(sdf.format(dateToday));

        String strToday = sdf.format(dateToday);
        System.out.println(strToday);

        System.out.println("\n=========================\n");

        // 2. Calendar 클래스 사용
        // .getInstance() 실행 시 새로운 객체가 생성된다. (싱글톤 x)
        // 객체가 생성될 때의 시간이 저장된다.
        Calendar calToday = Calendar.getInstance(); // new ~~ 실행된다는 뜻

        System.out.println(calToday);

        // Calendar 객체로부터 Date 객체 얻기
        Date calToDate = calToday.getTime();

        System.out.println(calToDate);
        System.out.println(sdf.format(calToDate));
        System.out.println(sdf.format(calToday.getTime()));

        System.out.println("\n=========================\n");

        // 3. System 클래스 사용
        long longToday = System.currentTimeMillis();
        System.out.println(longToday);

        // 날짜 포멧팅
        System.out.println(sdf.format(longToday));
        System.out.println(sdf.format(0));

        System.out.println("\n=========================\n");

        // 다양한 날짜 타입 만들기
        // 1. 2024/01/19 12:12:30
        // 2. 24-01-19 오후 00:12:30
        // 3. 금요일 12:12:30
        // @. 2024.01.19 PM 00:12:30
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(sdf.format(dateToday));

        sdf = new SimpleDateFormat("yy-MM-dd a KK:mm:ss");
        System.out.println(sdf.format(dateToday));

        sdf = new SimpleDateFormat("E요일 kk:mm:ss");
        System.out.println(sdf.format(dateToday));

        sdf = new SimpleDateFormat("yyyy.MM.dd a KK:mm:ss", Locale.ENGLISH);
        System.out.println(sdf.format(dateToday));

//        // @ 현재 미국 시간을 출력하기
//        TimeZone usEasternTimeZone = TimeZone.getTimeZone("American/New-York");
//        sdf = new SimpleDateFormat("yy-MM-dd a KK:mm:ss", Locale.ENGLISH);
//        System.out.println(new Date());


        System.out.println("\n============================\n");
        // "132" 숫자형 문자열
        // "2024-01-22" 날짜형 문자열
        // "2024-01-19"
        // 날짜형 문자열(String) -> Date 객체로 변환
        String strTomorrow = "2024-01-23 09:07:20";

        // 변환하고자 하는 문자열과 똑같은 형태의 포멧 설정
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTomorrow = sdf.parse(strTomorrow);

        System.out.println(dateTomorrow);

        // 시간만 변환해보기
        String strTime = "09:13:40";
        sdf = new SimpleDateFormat("HH:mm:ss");
        Date dateTime = sdf.parse(strTime);
        System.out.println(dateTime); // Thu Jan 01 09:13:40 KST 1970, 날짜를 지정하지 않으면 기본값인 1970.01.01로 출력된다.

        // 날짜만 변환해보기
        String strYear = "2024.01.22";
        sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date dateYear = sdf.parse(strYear);
        System.out.println(dateYear); //  00:00:00 기본값으로 출력된다.

        System.out.println("\n===========================\n");


        // 날짜 세팅하기
        Calendar cal = Calendar.getInstance();

        // 1998년 1월 31일
        // month 부분은 1월이 0, 2월이 1, 3월이 2, ... 12월이 11
        cal.set(1998, 0, 31);
        // 1998년 1월 31일 21시 38분 52초
        cal.set(1998, 0, 31, 21, 38, 52);
        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(sdf.format(cal.getTime())); // set으로 설정하고 get으로 꺼내야함


        // Date 객체로부터 Calendar 객체 얻기
        Date temp = new Date();
        Calendar calTemp = Calendar.getInstance();
        // Date 객체의 시간이 Calendar 객체에 저장된다.
        calTemp.setTime(dateTomorrow);
        System.out.println(sdf.format(calTemp.getTime()));


        System.out.println("\n=========================\n");

        // 날짜 꺼내기

        // 년도
        System.out.println(calTemp.get(Calendar.YEAR));

        // 월
        System.out.println(calTemp.get(Calendar.MONTH) + 1);

        // 일
        System.out.println(calTemp.get(Calendar.DATE));

        // 시간
        System.out.println(calTemp.get(Calendar.HOUR)); // hh와 같음(9시)
        System.out.println(calTemp.get(Calendar.HOUR_OF_DAY)); // HH와 같음(21시)

        // 분
        System.out.println(calTemp.get(Calendar.MINUTE));

        // 초
        System.out.println(calTemp.get(Calendar.SECOND));

        System.out.println("\n========================\n");

        String oneDay = "2024.01.10 13:14:15";
        String twoDay = "2024.01.12 15:14:15";

        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        Date oneDate = sdf.parse(oneDay);
        Date twoDate = sdf.parse(twoDay);

        System.out.println(oneDate);
        System.out.println(twoDate);

        // Date 객체에 .getTime()을 하면 그 밀리초(long)가 나옴
        // .getDate(), .getHour() 등 줄이 그러진 메소드들에 대해
        // deprecated 대상이라고 되어있는데
        // 곧 지원 종료 대상이라고 보면 된다. (추후 삭제될 수 있음)
        System.out.println(oneDate.getTime()); // 1704860055000
        System.out.println(twoDate.getTime()); // 1705040055000

        long diffMillSec = twoDate.getTime() - oneDate.getTime();
        System.out.println(diffMillSec + "밀리초 차이");

        // 1초 = 1000밀리초
        // diffMillSec / 1000 = N초
        long diffSec = diffMillSec / 1000;
        System.out.println(diffSec + "초 차이");

        // 1분 = 60초
        // diffSec / 60 -> 분 단위
        long diffMin = diffSec / 60;
        System.out.println(diffMin + "분 차이");

        // 1시간 = 60분
        // diffMin / 60 -> 시간 단위
        long diffHour = diffMin / 60;
        System.out.println(diffHour + "시간 차이");

        // 1일 = 24시간
        // diffHour / 24 -> 일 단위
        long diffDate = diffHour / 24;
        System.out.println(diffDate + "일 차이");

        // 한줄로 끝내기
        long diff = diffMillSec / 1000 / 60 / 60 / 24;
        long diffTwo = diffMillSec / (1000 * 60 * 60 * 24);
        System.out.println(diff + "일 차이");
        System.out.println(diffTwo);

        System.out.println("\n=============================\n");

        // 디데이 계산기
        // 2023.12.18 에 대해 + 35
        // 2023.02.09 에 대해 -18
        // 2024.01.20 에 대해 +2
        // 2024.01.24 에 대해 -2
        // 이 출력되도록 하는 디데이 계산기 만들어보기

        Date todayDate = new Date(); // 오늘 2024.01.22

        sdf = new SimpleDateFormat("yyyy.MM.dd");

        String todayStr = sdf.format(todayDate); // 2024.01.22
        todayDate = sdf.parse(todayStr); // 2024.01.22 00:00:00

        String before = "2024.01.20"; // 이틀전
        String after = "2024.01.24"; // 이틀후
        String start = "2023.12.18"; // 훈련시작일
        String newDay = "2024.02.09"; // 설


        Date beforeDate = sdf.parse(before);
        long calDiff = todayDate.getTime() - beforeDate.getTime();
        calDiff = calDiff / (1000*60*60*24);
        System.out.println(calDiff);

        Date afterDate = sdf.parse(after);
        long dday = todayDate.getTime() - afterDate.getTime();
        dday = dday / (1000*60*60*24);
        System.out.println(dday);
        Date startDate = sdf.parse(start);
        Date newDate = sdf.parse(newDay);

        System.out.println((todayDate.getTime() - beforeDate.getTime()) / 1000 / 60 / 60 / 24); // 01.22 - 01.20
        System.out.println((todayDate.getTime() - afterDate.getTime()) / 1000 / 60 / 60 / 24 ); // 0때문에?
        System.out.println((todayDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24); // 훈련시작 35일 경과
        System.out.println((todayDate.getTime() - newDate.getTime()) / 1000 / 60 / 60 / 24);

        System.out.println("\n=====================\n");

        // Calendar 의 날짜 연산
        // 특정 날짜를 기준으로 원하는 날짜를 더하거나 뺄 때 유용
        Calendar toCal = Calendar.getInstance();
        sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(sdf.format(toCal.getTime())); // A) 2024.01.23 10:36:42

        // 3일 뒤 날짜로
        toCal.add(Calendar.DATE, 3);
        System.out.println(sdf.format(toCal.getTime())); // B) 2024.01.26 10:36:42

        // 20일 뒤 날짜로
        toCal.add(Calendar.DATE, 20);
        System.out.println(sdf.format(toCal.getTime())); // C) 2024.02.15 10:37:50 --> B + 20일한 값

        toCal.add(Calendar.DATE, -7);
        System.out.println(sdf.format(toCal.getTime())); // D) 2024.02.08 10:39:05 --> C -7일한 값

        // 1달 뒤
        toCal.add(Calendar.MONTH, 1);
        System.out.println(sdf.format(toCal.getTime())); // F) 2024.03.08 10:40:47 --> D -1개월한 값


        System.out.println("\n==========================\n");

        // 달력 만들기
        int year = 2024;
        int month = 2;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1); // Calendar 객체에서 Month는 -1해야 생각대로 됨
        System.out.println(sdf.format(calendar.getTime()));

        // 해당 월의 1일이 무슨 요일에 시작하는지 확인
        // 1: 일요일, 2: 월요일, 3: 화요일, 4: 수요일, ... 7: 토요일
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(startDay); // 5 출력, 일요일부터 시작하므로

        // 해당 월의 마지막 일자가 언제인지
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(lastDay);

        System.out.println(year +"년 " + month + "월 달력");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        int day = 1;
        for (int i = 0; i < 42; i++){
            // startDay가 5(목요일) 일때 i=4에 해당
            // i가 0, 1, 2, 3 일때는 그리지 않음
            if (i < startDay - 1){
                System.out.print("\t");
            } else {
                System.out.print(day + "\t");

                if (day == lastDay){
                    break;
                }
                day++;

            } // i가 6,13, 20, 27, ... 일때 줄바꿈 넣기
            if (i % 7 == 6){
                System.out.println();
            }

        }


    }

}
