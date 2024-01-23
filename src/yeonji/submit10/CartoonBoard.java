package yeonji.submit10;

public class CartoonBoard extends Board {
    private String audio;



    public CartoonBoard(int titleNum, String title, String date, String content, String audio) {
        super(titleNum, title, date, content);
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "CartoonBoard{" +
                "audio='" + audio + '\'' +
                '}';
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
