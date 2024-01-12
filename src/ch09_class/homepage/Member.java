package ch09_class.homepage;

public class Member {
    private String memId;
    private String memPw;
    private String memName;



    public Member(String memId, String memPw, String memName) {
        this.memId = memId;     /* 회원 아이디 */
        this.memPw = memPw;     /* 회원 비밀번호 */
        this.memName = memName; /* 회원 이름 */
    }
    public Member() {}

    @Override
    public String toString() {
        return "Member{" +
                "memId='" + memId + '\'' +
                ", memPw='" + memPw + '\'' +
                ", memName='" + memName + '\'' +
                '}';
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }
}
