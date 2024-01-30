package ch14_jdbc;

import java.sql.*;

public class JdbcUpdate {

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



        try {
            connection = DriverManager.getConnection(url, id, pw);
//            connection.setAutoCommit(false); // DBeaver의 auto commit 해제와 같은 기능, 따로 설정하지 않으면
                                             // 자동으로 auto commit
              /* 쿼리문 자바에 적용하기
                update members
               set mem_name = '호빵맨'
               where mem_id = 'b001'; */
            StringBuffer query = new StringBuffer();
            query.append("UPDATE                       ");
            query.append("  members                    ");
            query.append("SET                          ");
            query.append("  mem_score = mem_score + 1  ");
            query.append("WHERE                        ");
            query.append("  mem_id = ?                 ");

           ps = connection.prepareStatement(query.toString());

           int idx = 1;
           ps.setString(idx++, "b001");

           int result = ps.executeUpdate();
            System.out.println(result);

            // 이어서 쿼리문 작성 후 실행 (update -> select 확인용)
            // 사용한 ps를 close() 해준다.
            ps.close();
            // 쿼리문 초기화
            query = new StringBuffer();
            query.append("SELECT        "); // SELECTmem_id 이면 실행 안됨
            query.append("        mem_id    ");
            query.append("      , mem_pw    ");
            query.append("      , mem_name  ");
            query.append("      , mem_score AS SCORE    ");
            query.append("FROM      ");
            query.append("  members     ");

            ps = connection.prepareStatement(query.toString());
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("mem_id"));
                System.out.println(rs.getString("mem_pw"));
                System.out.println(rs.getString("mem_name"));
                System.out.println(rs.getString("SCORE"));
                System.out.println(rs.getInt("SCORE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){try {ps.close();} catch (SQLException e) {}}
            if (connection != null) {try {connection.close();} catch (SQLException e) {}}
            if (rs != null) {try {rs.close();} catch (SQLException e) {}}

        }










    }
}
