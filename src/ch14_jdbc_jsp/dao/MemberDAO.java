package ch14_jdbc_jsp.dao;

import ch14_jdbc_jsp.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO: Data Access Object
// 쿼리문을 보유한 클래스
// member 테이블과 관련된 쿼리문만 작성해놓음
public class MemberDAO {

    // MemberDAO 또한 하나만 존재하면 되므로 싱글톤 적용한다.(.getInstance)
    private MemberDAO(){}

    private static MemberDAO instance = new MemberDAO();

    public static MemberDAO getInstance(){
        return instance;
    }

    // 회원목록 보기 (SELECT)
    public ArrayList<MemberDTO> getMemberList(Connection conn) throws SQLException {
        // 쿼리문 작성
        StringBuffer query = new StringBuffer();
        query.append("SELECT        "); // SELECTmem_id 이면 실행 안됨
        query.append("        mem_id    ");
        query.append("      , mem_pw    ");
        query.append("      , mem_name  ");
        query.append("      , mem_score    ");
        query.append("FROM      ");
        query.append("  members     "); // 세미콜론(;)은 없어야 함

        PreparedStatement ps = conn.prepareStatement(query.toString());

        ResultSet rs = ps.executeQuery();

        // MemberDTO 객체들을 담을 ArrayList 생성
        ArrayList<MemberDTO> result = new ArrayList<>();

        while (rs.next()) {
//            // 1. MemberDTO 객체 생성 (DB 데이터를 -> JAVA 객체화)
//            MemberDTO에 풀생성자를 미리 깔아두었기때문에 담으면서 객체 생성

//            String memId = rs.getString("mem_id");
//            String memPw = rs.getString("mem_pw");
//            String memName = rs.getString("mem_name");
//            int memScore = rs.getInt("Score");
//
//            MemberDTO member = new MemberDTO(memId, memPw, memName, memScore);
//            result.add(member);

            // 2. MemberDTO 객체 생성 (DB 데이터를 -> JAVA 객체화)
            // --> 원하는 컬럼만 가져오는 좀 더 수정이 용이한 유연한 방법
            MemberDTO member = new MemberDTO();
            member.setMemId(rs.getString("mem_id"));
            member.setMemPw(rs.getString("mem_pw"));
            member.setMemName(rs.getString("mem_name"));
            member.setMemScore(rs.getInt("mem_score"));
            result.add(member);

        }

        // 자원 정리 ( finally 부분에서 했던 일을 return 앞에서 실행)
        rs.close();
        ps.close();

        return result;

    }

    // 회원가입 (INSERT)
    // String id, pw, name 모두 DTO에서 가지고 있으므로 MemberDTO 타입을 파라미터로 받음
    public int signUp(Connection conn,MemberDTO member) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO           ");
        query.append("       members (      ");
        query.append("       mem_id         ");
        query.append("     , mem_pw         ");
        query.append("     , mem_name       ");
        query.append("     , mem_score          ");
        query.append("      ) values (      ");
        query.append("            ?         ");
        query.append("          , ?         ");
        query.append("          , ?         ");
        query.append("          , 100       "); // 점수는 기본 100점 넣기 (default 설정을 하지 않았을 경우)
        query.append("    )                 ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setString(idx++, member.getMemId());
        ps.setString(idx++, member.getMemPw());
        ps.setString(idx++, member.getMemName());

        int result = ps.executeUpdate();

        ps.close();

        return result;
    }

    // 로그인 (SELECT)
    public MemberDTO signIn(Connection conn,MemberDTO member) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("SELECT            ");
        query.append("        mem_id    ");
        query.append("      , mem_pw    ");
        query.append("      , mem_name  ");
        query.append("      , mem_score ");
        query.append("FROM              ");
        query.append("  members         ");
        query.append("WHERE 1=1         "); // 1=1 는 항상 true
        query.append("  AND mem_id = ?  ");
        query.append("  AND mem_pw = ?  ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setString(idx++, member.getMemId());
        ps.setString(idx++, member.getMemPw());

        ResultSet rs = ps.executeQuery();

        MemberDTO result = new MemberDTO();

        if (rs.next()){
            result.setMemId(rs.getString("mem_id"));
            result.setMemPw(rs.getString("mem_pw"));
            result.setMemName(rs.getString("mem_name"));
            result.setMemScore(rs.getInt("mem_score"));

        }

        rs.close();
        ps.close();

        return result;

    }
    // 회원탈퇴
    public MemberDTO deleteMember(Connection conn, MemberDTO member) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("DELETE            ");
        query.append("FROM              ");
        query.append("  members         ");
        query.append("WHERE             ");
        query.append("mem_id = ?        ");
        query.append("AND               ");
        query.append("mem_pw = ?        ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setString(idx++, member.getMemId());
        ps.setString(idx++, member.getMemPw());

        ResultSet rs = ps.executeQuery();

        MemberDTO result = new MemberDTO();

        rs.close();
        ps.close();

        return result;
    }





}
