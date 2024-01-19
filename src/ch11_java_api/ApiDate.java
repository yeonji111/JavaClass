package ch11_java_api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ApiDate {
    public static void main(String[] args) throws InterruptedException {
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




    }
}
