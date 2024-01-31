package ch14_jdbc_jsp.service;


import ch14_jdbc_jsp.dao.MemberDAO;
import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

// ConnectionPool 로부터 Connection 객체를 대여/반납
// MemberDAO의 메소드 실행 및 예외처리 담당
public class MemberService {

    // MemberService 객체는 하나만 존재하면 된다.
    // ( = 싱글톤 적용)
    private MemberService(){}

    private static MemberService instance = new MemberService();

    public static MemberService getInstance() {
        return instance;
    }

    private static ConnectionPool cp = ConnectionPool.getInstance();
    private static MemberDAO dao = MemberDAO.getInstance();

    // 회원목록 가져오기
    public static ArrayList<MemberDTO> getMemberList(){
        // ConnectionPool 내에 있는 Connection 객체 빌려오기
        Connection conn = cp.getConnection();

        ArrayList<MemberDTO> result = new ArrayList<>();

        // dao의 메소드에 빌려온 Connection 객체 넣어주기
        // MemberDAO의 getMemberList 메소드의 파라미터로 conn 이 필요하니까 ConnectionPool로부터 빌려옴
        try {
          result = dao.getMemberList(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.returnConnection(conn); // 목적을 마치고 오류가 나든 말든 Connection을 반납.
        }
        return result;

    }

    // 회원가입 메소드
    public int signUp(MemberDTO member){
        Connection conn = cp.getConnection();

        int result = 0;

        try {
            result = dao.signUp(conn,member);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.returnConnection(conn);
        }

        return result;
    }

    // 로그인 메소드
    public MemberDTO signIn(MemberDTO member){
        Connection conn = cp.getConnection();

        MemberDTO result = null;

        try {
            result = dao.signIn(conn,member);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.returnConnection(conn);
        }

        // 로그인 실패 시 result의 필드변수는 텅 비어있음 -> result에 null값 넣기
        if (result.getMemId() == null){
            result = null;
        }

        return result;
    }

    // 회원탈퇴 메소드
    public MemberDTO deleteMember(MemberDTO member){
        Connection conn = cp.getConnection();

        MemberDTO result = null;

        try {
            result = dao.deleteMember(conn, member);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.returnConnection(conn);
        }


        return result;
    }








}
