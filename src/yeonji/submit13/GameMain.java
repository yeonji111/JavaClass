//package yeonji.submit13;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// * 게임을 진행하는 클래스
// */
//
//public class GameMain {
//    public static void main(String[] args) {
//        // 커넥션은 src\\ch14_jdbc_jsp\\jdbc\\ConnectionFactroy와 ConnectionPool을 빌려올것
//
//
//        // 게임 시작
//        // 랜덤한 인덱스 꺼내오기
//        ArrayList<QuizDTO> quizList = GameService.playGame();
//        int ran = (int) (Math.random() * (quizList.size() - 1)) + 1;
//        Scanner scan = new Scanner(System.in);
//
//
//        while (true) {
//            String starWord = quizList.get(ran).getDic();
//            System.out.println("제시어: " + starWord);
//
//            if (starWord.length() == 3) {
//                // 첫 제시어가 세글자인 경우
//                System.out.println(starWord.substring(2));
//                System.out.print(">>> ");
//                String answer = scan.nextLine();
//
//                if (starWord.substring(2).equals(answer.charAt(0))) {
//
////                    GameService.playGame();
//                    // 사용자가 제시어의 조건에 맞는 답을 입력한 경우
//                    // 사용자의 마지막 글자에 맞춰 게임 진행
//
//
//                }
//
//            }
//
//        }
//
//
//
//    }
//
//
//}
