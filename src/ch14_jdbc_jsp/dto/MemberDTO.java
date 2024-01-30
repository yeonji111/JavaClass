package ch14_jdbc_jsp.dto;

// DTO, Data Transfer Object (DB의 데이터를 객체로 전환)
// MemberDTO 는 Members 테이블의 컬럼과 1:1 매핑이 되는 클래스
// 정확하게는 DTO 는 SELECT 문의 실행 결과 컬럼과 1:1 매핑이 되게 함.
public class MemberDTO {
    private String memId;   /* 회원 아이디 */
    private String memPw;   /* 회원 비밀번호 */
    private String memName; /* 회원 이름 */
    private int memScore;   /* 출석 점수 */

    public MemberDTO() {
    }

    public MemberDTO(String memId, String memPw, String memName, int memScore) {
        this.memId = memId;
        this.memPw = memPw;
        this.memName = memName;
        this.memScore = memScore;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memId='" + memId + '\'' +
                ", memPw='" + memPw + '\'' +
                ", memName='" + memName + '\'' +
                ", memScore=" + memScore +
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

    public int getMemScore() {
        return memScore;
    }

    public void setMemScore(int memScore) {
        this.memScore = memScore;
    }
}
