package yeonji.game;

public class Player {
    private String id;
    private String pw;
    private float result;

    public Player() {}

    public Player(String id, String pw) {
        this.id = id;
        this.pw = pw;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", result=" + result +
                '}';
    }



    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public float getResult() {
        return result;
    }

}
