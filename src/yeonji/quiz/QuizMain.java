package yeonji.quiz;

/** 직접 만든 버전 초성으로 영화 이름 맞추기 게임
    초성, 점수, 영화이름, 영화힌트    */

public class QuizMain {
    public static void main(String[] args) {


        QuizDB quizDB = QuizDB.getIntstnace();


        // 게임 실행 (파라미터로 20까지 받을 수 있음)
        quizDB.game(10);

    }
}
