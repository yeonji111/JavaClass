package yeonji.submit10;

import java.util.ArrayList;

public class Board {
    int titleNum;
    String title;
    String date;
    String content;

    public Board(int titleNum, String title, String date, String content) {
        this.titleNum = titleNum;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Board{" +
                "titleNum=" + titleNum +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getTitleNum() {
        return titleNum;
    }

    public void setTitleNum(int titleNum) {
        this.titleNum = titleNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
