package yeonji.quiz;

public class QuizMain {
    public static void main(String[] args) {


        QuizDB quizDB = QuizDB.getIntstnace();

        quizDB.game(10);

    }
}
