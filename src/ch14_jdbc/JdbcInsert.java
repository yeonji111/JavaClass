package ch14_jdbc;

import java.sql.*;

public class JdbcInsert {
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
            connection  = DriverManager.getConnection(url, id, pw);

            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO           ");
            query.append("       members (      ");
            query.append("       mem_id         ");
            query.append("     , mem_pw         ");
            query.append("     , mem_name       ");
            query.append("     , score          ");
            query.append("      ) values (      ");
            query.append("            ?         ");      // 문자열의 경우 작은따옴표를 붙여줘야 한다. -> 쓰기 불편할 뿐 아니라 보안에 취약해짐.
            query.append("          , ?         "); // 쿼리문 안에 물음표로 채우고, 이후에 완성시켜주는 방식 사용
            query.append("          , ?         ");
            query.append("          , ?         ");
            query.append("    )                 ");


            // PreparedStatement 객체 생성
            ps = connection.prepareStatement(query.toString());

            // 이때 ps는 미완성된 쿼리문을 가지고 있는 상황
            // (= 쿼리문 실행 불가, 물음표에 값을 따로 넣어주어야 함)

            // 미완성된 쿼리문 내에 있는 물음표(?) 값 채우기
            // 위에서부터 첫번째 물음표의 인덱스는 1이다.
            int idx = 1;
            ps.setString(idx++, "d001");
            ps.setString(idx++, "123d");
            ps.setString(idx++, "식빵맨");
            ps.setInt(idx++,5);

            // 쿼리문 실행
            rs = ps.executeQuery(); // SELECT문 실행을 위한 메소드


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
