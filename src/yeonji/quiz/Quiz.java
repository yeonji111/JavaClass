package yeonji.quiz;

public class Quiz {
    private String quiz;        /* 문제 */
    private String correct;     /* 문제 정답 */
    private int score;          /* 문제 점수 */

    public Quiz() {
    }

    public Quiz(String quiz, String correct, int score) {
        this.correct = correct;
        this.quiz = quiz;
        this.score = score;
    }

    @Override
    public String toString() {
        return "QuizDB{" +
                "correct='" + correct + '\'' +
                ", quiz='" + quiz + '\'' +
                ", score=" + score +
                '}';
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }




}
