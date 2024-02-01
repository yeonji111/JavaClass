package ch14_jdbc_jsp.service;

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
    private BoardService(){}

    private static BoardService instance = new BoardService();

    public static BoardService getInstance(){
        return instance;
    }

    private static ConnectionPool cp = ConnectionPool.getInstance();
    private static BoardDAO dao = BoardDAO.getInstance();


    // 글 목록 가져오기
    public List<BoardDTO> getBoardList(){
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
    public int writeBoard(BoardDTO board){
        Connection conn = cp.getConnection();

        int result = 0;

        try {
          result = dao.writheBoard(conn,board);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cp.returnConnection(conn);
        }
        return result;
    }

    // 글 자세히 보기
    public BoardDTO readBoard(int no){ // 파라미터로 int 글번호를 받아야함
        Connection conn = cp.getConnection();

        BoardDTO result = null;
        // 파라미터로 입력받은 글번호 == boardList에 존재하는 글번호 매칭



        int number = readBoard(no).getBoNo();
        try {
            result = dao.readBoard(conn,no);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cp.returnConnection(conn);
        }
        return result;
    }


}
