package ch14_jdbc;

import oracle.jdbc.OracleDriver;

import java.sql.*;

public class JdbcSelect {

    public static void main(String[] args) {

        // 1. ojdbc 라이브러리 내에 있는
        //    OracleDriver 클래스를 깨우기
        //    driver 객체를 가지고 무언가를 하지는 않는다.
        //    OracleDriver 클래스만 깨워서 내부 static{}이 실행되도록 할 예정
//        OracleDriver driver = new OracleDriver();

        // OralceDriver의 풀경로 = oracle.jdbc.driver.OracleDriver
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (Exception e) {
            System.out.println("드라이버 로드 실패");
            System.exit(0); // 프로그램 종료
        }

        // 2. DB 연결을 위한 URL과 계정의 ID/PW 준비
        //      DB마다 형식이 다를 수도 있음 (@nextit.or.kr 은 @IP주소)
        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std115";
        String pw = "oracle21c";

        // 3. DB 서버와 연결
        // 연결에 성공하면 연결된 상태인 Connection 객체를 리턴
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, id, pw);
            System.out.println("연결 성공");

            // 4. 쿼리문(SQL) 작성
            StringBuffer query = new StringBuffer();
            query.append("SELECT        "); // SELECTmem_id 이면 실행 안됨
            query.append("        mem_id    ");
            query.append("      , mem_pw    ");
            query.append("      , mem_name  ");
            query.append("      , mem_score AS SCORE    ");
            query.append("FROM      ");
            query.append("  members     "); // 세미콜론(;)은 없어야 함

            // 5. 쿼리문을 실행하기 위한 PreparedStatement 객체 생성
            ps = connection.prepareStatement(query.toString());

            // 6. 쿼리문 실행 및 실행 결과를 ResultSet에 담기
            rs = ps.executeQuery(); // SELECT문 실행을 위한 메소드


            // 7. ResultSet 내부 데이터 조회
            while (rs.next()){
                // VARCHAR2 타입은 rs.getString()
                // .getString() 괄호 안에는 컬럼명( DB에서 AS "NAME"를 사용한 경우 컬럼명을 "NAME"으로 보아야함)
                System.out.println(rs.getString("mem_id"));
                System.out.println(rs.getString("mem_pw"));
                System.out.println(rs.getString("mem_name"));
                // NUMBER 타입에 대해 rs.getString() 하면 문자열로 받아옴
                // Alias (AS) 를 적용한 컬럼이 있다면 해당 Alias를 작성해줘야함
                System.out.println(rs.getString("SCORE"));
                // NUMBER 타입에 대해 rs.getInt() 하면 숫자로 받아옴
                System.out.println(rs.getInt("SCORE"));
            }

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
