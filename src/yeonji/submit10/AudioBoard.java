package yeonji.submit10;

public class AudioBoard extends Board{

    private String audio;

    public AudioBoard(int titleNum, String title, String date, String content) {
        super(titleNum, title, date, content);
    }

    public AudioBoard(int titleNum, String title, String date, String content, String audio) {
        super(titleNum, title, date, content);
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "AudioBoard{" +
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
