package ch12_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 에러가 발생할 수 있는 모든 메소드들을 보유하는 클래스
public class ExMethod {

    // 날짜 문자열을 파라미터로 입력받으면
    // 해당 날짜에 대한 그 long 타입 숫자로 변환하여 리턴
    // (날짜 문자열은 yyyy.MM.dd 로 들어와야 함)
    public static long dateToMillSec(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        // sdf.parse() 는 포맷이 다른 문자열에 대해 ParseException 발생
        // ParseException에 대한 예외처리 해줘야 함
        // 선택 1. 이곳에서 try~catch를 이용하여 예외 처리
        // 선택 2. 이곳에서 예외처리를 하지 않고, 다른 곳에서 try~catch로
        //        예외처리를 하도록 넘기기

//        --- 선택 1
//        Date result = null;
//        try {
//            result = sdf.parse(date);
//        } catch (ParseException e) {
//            return 0L;
//        }

//        --- 선택 2 : throws ParseException 으로 예외처리를 다른 곳으로 넘기기
                 // ExceptionMain에서  try~catch로 해결 !
        Date result = sdf.parse(date);
        return result.getTime();
    }


    // 파라미터로 0이 들어오면 "가위" 리턴
    // 파라미터로 1이 들어오면 "바위" 리턴
    // 파라미터로 2가 들어오면 "보" 리턴
    // (0,1,2가 아닌 숫자가 들어오면 문제가 생김)

    public static String rsp(int num) throws Exception{
        if (num == 0){
            return "가위";
        } else if (num == 1) {
            return "바위";
        } else if (num == 2) {
            return "보";
        } else{
            // 에러 발생시키기
        throw new Exception("숫자 0~2만 넣으세요.");
        }
    }

    // 입력받은 이름을 콘솔창에 출력
    // 파라미터로 들어온 문자열이 숫자거나, empty면 안됨
    public static void printName(String name) throws BizException{
        if (name.length() == 0){
            throw new BizException("빈 문자열이 들어왔다.", 1);
        }
        if (name.matches("^.*[0-9].*$")){
            // 에러 발생 시, 메소드가 중단된다.
            throw new BizException("숫자가 들어왔다", 2);
        }
        System.out.println(name);
    }
}
