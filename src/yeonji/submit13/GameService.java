package yeonji.submit13;

import ch14_jdbc_jsp.dao.BoardDAO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/** 게임을 진행하기 위한
 * 메소드를 제공하는 클래스
 * */

public class GameService {
    // 싱글톤 패턴 적용(메인단에서는 가져다쓰기만 하면 되니까)


    public GameService() {
    }

    private static GameService instance = new GameService();

    public static GameService getInstance(){
        return instance;
    }

    private static ConnectionPool cp = ConnectionPool.getInstance();
    private static QuizDAO dao = QuizDAO.getInstance();




    // todo 게임 진행 메소드(playGame) - SELECT WHERE
   public static ArrayList<QuizDTO> playGame() {
       Connection conn = cp.getConnection();

       ArrayList<QuizDTO> result = new ArrayList<>();

       try {
           result = dao.playGame(conn);
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           cp.returnConnection(conn);
       }
       return result;
   }





}
