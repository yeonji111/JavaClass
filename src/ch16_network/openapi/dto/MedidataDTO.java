package ch16_network.openapi.dto;

public class MedidataDTO {
    private int itemSeq;            /* 약품번호(PK) */
    private String itemName;        /* 약품명 */
    private String entpName;        /* 회사명 */
    private String efcyQesitm;      /* 증상 */
    private String useMethodQesitm; /* 복용방법 */

    public MedidataDTO() {
    }


    public MedidataDTO(int itemSeq, String itemName, String entpName, String efcyQesitm, String useMethodQesitm) {
        this.itemSeq = itemSeq;
        this.itemName = itemName;
        this.entpName = entpName;
        this.efcyQesitm = efcyQesitm;
        this.useMethodQesitm = useMethodQesitm;
    }

    @Override
    public String toString() {
        return "MedidataDTO{" +
                "itemSeq=" + itemSeq +
                ", itemName='" + itemName + '\'' +
                ", entpName='" + entpName + '\'' +
                ", efcyQesitm='" + efcyQesitm + '\'' +
                ", useMethodQesitm='" + useMethodQesitm + '\'' +
                '}';
    }

    public int getItemSeq() {
        return itemSeq;
    }

    public void setItemSeq(int itemSeq) {
        this.itemSeq = itemSeq;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getEfcyQesitm() {
        return efcyQesitm;
    }

    public void setEfcyQesitm(String efcyQesitm) {
        this.efcyQesitm = efcyQesitm;
    }

    public String getUseMethodQesitm() {
        return useMethodQesitm;
    }

    public void setUseMethodQesitm(String useMethodQesitm) {
        this.useMethodQesitm = useMethodQesitm;
    }
}
