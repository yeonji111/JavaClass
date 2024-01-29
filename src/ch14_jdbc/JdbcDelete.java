package ch14_jdbc;

import java.sql.*;

public class JdbcDelete {
    // 아이디가 a001인 데이터 삭제
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (Exception e) {
            System.out.println("드라이버 로드 실패");
            System.exit(0); // 프로그램 종료
        }

        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std115";
        String pw = "oracle21c";

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            connection = DriverManager.getConnection(url, id, pw);

            StringBuffer query = new StringBuffer();
            query.append("DELETE         ");
            query.append("  FROM         ");
            query.append("  members      ");
            query.append("  WHERE        ");
            query.append("  mem_id       ");
            query.append("  like         ");
            query.append("  ?        ");

            ps = connection.prepareStatement(query.toString());

            int idx = 1;
            ps.setString(idx++, "a001");

            // 쿼리문 실행
            // INSERT, UPDATE, DELETE는 executeUpdate()로 실행
            int result = ps.executeUpdate();
            System.out.println(result);

        } catch(SQLException e){e.printStackTrace();}
        finally {
            // 8. DB 연결에 사용된 객체들 .close() 해주기 (= 자원정리)
            if(ps != null){try {ps.close();} catch (SQLException e) {}}
            // 연결에 실패해서 connection이 null인 경우
            // finally는 에러가 떠도 무조건 실행되므로 null.close()가 되어서 오류를 뱉어냄
            // 그러므로 if문으로 조건 추가해줌
            if (connection != null) {try {connection.close();} catch (SQLException e) {}}

            if(rs != null){try {rs.close();} catch (SQLException e) {}}
        }

    }
}