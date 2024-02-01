package ch14_jdbc_jsp.dto;

public class BoardDTO {
    private int boNo;           /* 게시글 번호 */
    private String boTitle;     /* 게시글 제목 */
    private String boContent;   /* 게시글 내용 */
    private String memId;       /* 작성자 아이디(FK) */
    private String memName;     /* 작성자 닉네임 */
    private String boDate;      /* 게시글 작성일(MM-dd) */
    // 보통 Date 타입으로 받지 않고 String 으로 그대로 받음
    // 날짜 계산을 해야한다 하면 parsing 을 이용함.

    public BoardDTO() {}

    public BoardDTO(int boNo, String boTitle, String boContent, String memId, String memName, String boDate) {

        this.boNo = boNo;
        this.boTitle = boTitle;
        this.boContent = boContent;
        this.memId = memId;
        this.memName = memName;
        this.boDate = boDate;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "boNo=" + boNo +
                ", boTitle='" + boTitle + '\'' +
                ", boContent='" + boContent + '\'' +
                ", memId='" + memId + '\'' +
                ", memName='" + memName + '\'' +
                ", boDate='" + boDate + '\'' +
                '}';
    }

    public int getBoNo() {
        return boNo;
    }

    public void setBoNo(int boNo) {
        this.boNo = boNo;
    }

    public String getBoTitle() {
        return boTitle;
    }

    public void setBoTitle(String boTitle) {
        this.boTitle = boTitle;
    }

    public String getBoContent() {
        return boContent;
    }

    public void setBoContent(String boContent) {
        this.boContent = boContent;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getBoDate() {
        return boDate;
    }

    public void setBoDate(String boDate) {
        this.boDate = boDate;
    }
}
