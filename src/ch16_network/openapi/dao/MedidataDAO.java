package ch16_network.openapi.dao;


import ch16_network.openapi.dto.MedidataDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class MedidataDAO {

    // 싱글톤 패턴 적용

    private MedidataDAO() {}

    private static MedidataDAO instance = new MedidataDAO();

    public static MedidataDAO getInstance() {
        return instance;
    }

    // 약품 데이터 넣기 (INSERT)
    public int inputMedidata(Connection conn, MedidataDTO medidata) throws SQLException {
        StringBuilder query = new StringBuilder(); // 멀티스레드 환경이 아니라서 동기화 미지원인 빌더가 더 좋은 성능을 보임
        query.append("INSERT INTO medidata(   ");
        query.append("       item_Seq         ");
        query.append("      ,item_Name        ");
        query.append("      ,entp_Name        ");
        query.append("      ,efcy_Qesitm      ");
        query.append("  ,use_Method_Qesitm    ");
        query.append("      ) VALUES (        ");
        query.append("          ?             ");
        query.append("          ,?            ");
        query.append("          ,?            ");
        query.append("          ,?            ");
        query.append("          ,?            ");
        query.append("          )             ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setInt(idx++, medidata.getItemSeq());
        ps.setString(idx++, medidata.getItemName());
        ps.setString(idx++, medidata.getEntpName());
        ps.setString(idx++, medidata.getEfcyQesitm());
        ps.setString(idx++, medidata.getUseMethodQesitm());

        int result = ps.executeUpdate();

        ps.close();

        return result;

    }

    // 약품 데이터가져오기 (SELECT)
    public ArrayList<MedidataDTO> getMedidataList(Connection conn) throws SQLException {
        StringBuilder query = new StringBuilder();

        query.append("SELECT                ");
        query.append(" item_seq             ");
        query.append(" , item_name          ");
        query.append(" , entp_name          ");
        query.append(" , efcy_qesitm        ");
        query.append(" , use_method_qesitm  ");
        query.append(" FROM                 ");
        query.append("      medidata        ");

    PreparedStatement ps = conn.prepareStatement(query.toString());

    ResultSet rs = ps.executeQuery();

    ArrayList<MedidataDTO> result = new ArrayList<>();

    while(rs.next()){
        MedidataDTO medidata = new MedidataDTO();
        medidata.setItemSeq(rs.getInt("item_seq"));
        medidata.setItemName(rs.getString("item_name"));
        medidata.setEntpName(rs.getString("entp_name"));
        medidata.setEfcyQesitm(rs.getString("efcy_qesitm"));
        medidata.setUseMethodQesitm(rs.getString("use_method_qesitm"));

        result.add(medidata);


    }
        rs.close();
        ps.close();

        return result;

    }

}
