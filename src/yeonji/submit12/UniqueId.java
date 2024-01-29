//package yeonji.submit12;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.UUID;
//
//public class UniqueId {
//    public static void main(String[] args) {
//////        String uniqueId = makeUniqueId();
//////        System.out.println(uniqueId);
////        Date date = new Date();
////        // 받은 날짜~밀리초를 원하는 포맷형식의 문자열로 변경
////        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
////        String inputDate = sdf.format(date);
////        System.out.println(inputDate);
////
////        int rand = (int) Math.random() * 10;
////
////       StringBuffer = new StringBuffer;
//
////        System.out.println(inputDate + rand);
//
//        String uniqueId = makeUniqueId();
//        System.out.println(uniqueId);
//
//    }
//
//    static String makeUniqueId() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
//        String inputDate = sdf.format(new Date());
//        // inputDate에 6자리 랜덤 숫자 추가
//
//        StringBuffer rst = new StringBuffer(inputDate);
//        for (int i = 0; i < 6; i++) {
//            rst.append((int) (Math.random() * 10));
////            inputDate += (int)(Math.random()*10);
//        }
//
//        return inputDate;
//return rst.toString();
//    }
//}
//
