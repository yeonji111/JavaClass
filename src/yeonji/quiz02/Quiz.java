package yeonji.quiz02;

public class Quiz {
    private String name;    /* 영화 이름 */
    private String talk;    /* 명대사 */
    private String actor;   /* 배우 힌트 */
    private String word;    /* 초성 힌트 */

    public Quiz() {
    }

    public Quiz(String name, String talk, String actor, String word) {
        this.name = name;
        this.talk = talk;
        this.actor = actor;
        this.word = word;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "name='" + name + '\'' +
                ", talk='" + talk + '\'' +
                ", actor='" + actor + '\'' +
                ", word='" + word + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
