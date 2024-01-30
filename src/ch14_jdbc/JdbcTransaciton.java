package ch14_jdbc;

import java.sql.*;

public class JdbcTransaciton {
        /*
            코드 실행 시 붕어빵맨의 score 50점을 호빵맨에게 준다.
            UPDATE 1번 -> b001의 score를 -50,
            UPDATE 2번 -> c001의 score를 +50

            만약 붕어빵맨의 score가 50 미만인 경우에는
            송금하지 못하도록 막기

         */

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
        ResultSet rs = null; // Select문에서 사용하는 ResultSet

        try {
            connection = DriverManager.getConnection(url, id, pw);
            // 자동 커밋(auto-commit) 기능 끄기
            connection.setAutoCommit(false);

            StringBuffer query = new StringBuffer();
            query.append("UPDATE                       ");
            query.append("  members                    ");
            query.append("SET                          ");
            query.append(" mem_score = mem_score +  ?  ");
            query.append("WHERE                        ");
            query.append("  mem_id = ?                 ");

            ps = connection.prepareStatement(query.toString());

            int idx = 1;
            ps.setInt(idx++, -50);
            ps.setString(idx++, "b001");
            int result = ps.executeUpdate();


            if (result > 0) {
                query = new StringBuffer();
                query.append("SELECT        ");
                query.append("   mem_score  ");
                query.append("FROM               ");
                query.append("  members          ");
                query.append("WHERE              ");
                query.append("  mem_id = ?    ");

                ps = connection.prepareStatement(query.toString());
                idx = 1;
                ps.setString(idx++, "b001");

                rs = ps.executeQuery();

                if (rs.next()) {

                    // if문안에 담기 위해서
                    int money = rs.getInt("mem_score");

                    if (money < 0) {
                        // b001의 점수 50을 깎은 후의 점수가 0 미만인 경우 롤백
                        connection.rollback();
                    } else {
                        // b001의 점수 50을 깎은 후의 점수가 0 이상이므로
                        // c001의 점수 50을 올리는 UPDATE문 진행
                        ps.close();
                        query = new StringBuffer();
                        query.append("UPDATE                       ");
                        query.append("  members                    ");
                        query.append("SET                          ");
                        query.append(" mem_score = mem_score +  ?  ");
                        query.append("WHERE                        ");
                        query.append("  mem_id = ?                 ");


                        ps = connection.prepareStatement(query.toString());

                        idx = 1;
                        ps.setInt(idx++, 50);
                        ps.setString(idx++, "c001");

                        result = ps.executeUpdate();

                        if (result > 0) {
                            // 커밋 -- 최종 완성(실행)에만 커밋하고 나머지는 롤백
                            connection.commit();
                            System.out.println("점수 송금 완료");
                        } else {
                            // 롤백
                            connection.rollback();
                            System.out.println("문제가 발생하여 롤백하였습니다.");
                        }

                    }
                }

            }


        } catch (SQLException e) {
            // 에러 발생 시 이곳이 실행되므로 롤백을 넣어준다.
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(); // 변수의 Scope를 의식하여 두번째 catch단에는 ex 으로 인텔리제이가 임의로 지음
            }
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
        }


    }
}
