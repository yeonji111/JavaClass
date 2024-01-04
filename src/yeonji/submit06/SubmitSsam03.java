//package yeonji.submit06;
//
//import ch07_array.ArrayMain;
//
//public class SubmitSsam03 {
//    public static void main(String[] args) {
//
//        int[] lotto = new int[6]; // 0,0,0,0,0,0
//
//
//        int rand = (int) (Math.random() * 10) + 1; // 5
//
//
//        int idx = 0;
//        while (true) {
//            int rand = (int) (Math.random() * 10) + 1;
//
//
//            boolean isDuple = false;
//            for (int i = 0; i < lotto.length; i++) {
//                // 생성된 번호가 배열내에 존재한다면 if문이 동작
//                if (lotto[i] == rand) {
//                    isDuple = true; // 불리언 타입인 isDuple이 true로 바뀌기만 할 뿐 변수를 새로 담거나, 결과를 리턴하는건 아무것도 없음
//
//                }
//                if (isDuple == false) {
//                    lotto[idx] = rand; // idx가 lotto.length-1일때 마지막 인덱스에 해당
//
//                    idx++;               // while문 중단
//                }
//                if (idx == lotto.length) {
//                    break;
//                }
//
//
//            }
//            ArrayMain.printArray(lotto);
//
//            int[] winLotto = {17, 26, 29, 30, 31, 43};
//
//            // 당첨이 될때까지 makeLotto() 실행 후 winLotto와 비교
//            // 당첨 = makeLotto의 모든 번호가 winLotto의 모든 번호와 일치
//            int buy = 0;
//            while(true){
//                buy++;
//                int[] myLotto = makeLotto();
//
//                boolean isFail = false;
//                for (int i = 0; i < winLotto.length; i++) {
//                    // 이 if문이 한번이라도 실행되면 1등 당첨이 안된 것
//                    if (winLotto[i] == myLotto[i]) {
//                        isFail = true;
//                    }
//                }
//                System.out.println(buy);
//
//
//                // 당첨됨!
//                if (isFail == false) {
//                    System.out.println("당첨");
//                    System.out.println("구매횟수 : " + buy);
//                    System.out.println("구매금액 : " + (buy*1000L) + "원");
//                    break;
//
//                }
//
//            }
//
//
//
//
//        }
//    }// 메소드 끝
////    public static int[] makeLotto() {
//
//}