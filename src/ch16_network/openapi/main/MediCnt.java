package ch16_network.openapi.main;

public class MediCnt {
    private String efcy;    /* 증상 이름 */
    private int cnt;        /* 중복 횟수 */

    public MediCnt() {
    }

    public MediCnt(String efcy, int cnt) {
        this.efcy = efcy;
        this.cnt = cnt;
    }


    @Override
    public String toString() {
        return "MediCnt{" +
                "efcy='" + efcy + '\'' +
                ", cnt=" + cnt +
                '}';
    }

    public String getEfcy() {
        return efcy;
    }

    public void setEfcy(String efcy) {
        this.efcy = efcy;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
