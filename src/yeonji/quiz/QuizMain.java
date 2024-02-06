package yeonji.quiz;

public class QuizMain {
    public static void main(String[] args) {


        QuizDB quizDB = QuizDB.getIntstnace();


        // 게임 실행 (파라미터로 20까지 받을 수 있음)
        quizDB.game(10);

    }
}
