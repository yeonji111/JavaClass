package yeonji.game;

public class Player {
    private String id;
    private String pw;

    public Player(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
