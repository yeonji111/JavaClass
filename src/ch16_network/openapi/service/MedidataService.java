package ch16_network.openapi.service;

import ch14_jdbc_jsp.jdbc.ConnectionPool;
import ch16_network.openapi.dao.MedidataDAO;
import ch16_network.openapi.dto.MedidataDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedidataService {

    private MedidataService(){}

    public static MedidataService instance = new MedidataService();

    public static MedidataService getInstance() {
        return instance;
    }

    // 싱글톤 패턴 적용한 클래스의 객체들 getInstance로 끌어와서 사용하기
    private MedidataDAO dao = MedidataDAO.getInstance();

    private ConnectionPool cp = ConnectionPool.getInstance();


    // 약품 데이터 넣기
    public void inputMedidata(MedidataDTO medidata){
        Connection conn = cp.getConnection();

        try {
            dao.inputMedidata(conn, medidata);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.returnConnection(conn);
        }




    }


    // 약품 데이터 가져오기
    public ArrayList<MedidataDTO> getMedidataList(){
        Connection conn = cp.getConnection();

        ArrayList<MedidataDTO> result = new ArrayList<>();

        try {
            result = dao.getMedidataList(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.returnConnection(conn);
        }

        return result;
    }




}

