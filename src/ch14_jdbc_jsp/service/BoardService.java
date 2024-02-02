package ch14_jdbc_jsp.service;

import ch12_exception.BizException;
import ch12_exception.ExCode;
import ch14_jdbc_jsp.dao.BoardDAO;
import ch14_jdbc_jsp.dto.BoardDTO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;
import yeonji.submit10.Board;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardService {


    // 싱글톤 적용
    private BoardService() {
    }

    private static BoardService instance = new BoardService();

    public static BoardService getInstance() {
        return instance;
    }

    private static ConnectionPool cp = ConnectionPool.getInstance();
    private static BoardDAO dao = BoardDAO.getInstance();


    // 글 목록 가져오기
    public List<BoardDTO> getBoardList() {
        Connection conn = cp.getConnection();

        List<BoardDTO> result = new ArrayList<>();

        try {
            result = dao.getBoardList(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.returnConnection(conn);
        }
        return result;
    }

    // 글 작성
    public int writeBoard(BoardDTO board) {
        Connection conn = cp.getConnection();

        int result = 0;

        try {
            result = dao.writheBoard(conn, board);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.returnConnection(conn);
        }
        return result;
    }

    // 글보기 메소드
    public BoardDTO readBoard(int no) { // 파라미터로 int 글번호를 받아야함
        Connection conn = cp.getConnection();

        BoardDTO result = null;

        try {
            result = dao.readBoard(conn, no);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.returnConnection(conn);
        }
        if (result.getBoTitle() == null) {
            result = null;
        }
        return result;
    }

    // 조회수 증가 메소드
    public void upViewCount(int no) {
        // 글 작성같은 메소드들처럼 int를 리턴하는 메소드로 만들어도 무방하나,
        // 리턴값이 있다하더라도 딱히 별 다른 기능을 추가할게 없으므로 void
        Connection conn = cp.getConnection();

        try {
            dao.upViewCount(conn, no);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.returnConnection(conn);

        }
    }

    // 글 삭제 메소드
    public int deleteBoard(int no) throws BizException{
        Connection conn = cp.getConnection();

        int result = 0;
        try {
           result = dao.deleteBoard(conn,no);
            System.out.println("글 삭제 완료 !!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.returnConnection(conn);
        }

        if (result == 0){
            throw new BizException("글 삭제 실패", ExCode.API_003 );
        }
        return result;
    }


}
