package yeonji.submit13;

public class QuizDTO {
    private String dic; /* 정답 체크용 명사 */

    public QuizDTO() {
    }

    public QuizDTO(String dic) {
        this.dic = dic;
    }

    @Override
    public String toString() {
        return "QuizDTO{" +
                "dic='" + dic + '\'' +
                '}';
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }
}
