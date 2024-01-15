package ch09_class.homepage;

public class Board {
    private int boardNo;             /* 글 번호 */
    private String boardTitle;      /* 글 제목 */
    private String boardContent;    /* 글 내용 */
    private String memId;           /* 작성자 */



    public Board(int boardNo, String boardTitle, String boardContent, String memId) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.memId = memId;
    }

    public Board() {
    }

    @Override
    public String toString() {
        return
                 boardNo +
                 boardTitle
                 + boardContent
                 + memId
               ;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }
}
