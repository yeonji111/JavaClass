package yeonji.quiz;

import java.util.ArrayList;

public class Quiz {
    private String quiz;                    /* 문제 */
    private String correct;                 /* 문제 정답 */
    private int score;                      /* 문제 점수 */
    private String hint;   /* 문제 힌트 */


    public Quiz() {
    }

    public Quiz(String quiz, String correct, int score, String hint) {
        this.quiz = quiz;
        this.correct = correct;
        this.score = score;
        this.hint = hint;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quiz='" + quiz + '\'' +
                ", correct='" + correct + '\'' +
                ", score=" + score +
                ", hint='" + hint + '\'' +
                '}';
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}