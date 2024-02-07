package yeonji.submit13;

import yeonji.quiz.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class QuizDAO {
    private QuizDAO() {
    }

    private static QuizDAO instance = new QuizDAO();

    public static QuizDAO getInstance() {
        return instance;
    }

    // todo DB에 있는 데이터 자바단에 리스트로 끌고 오기
    public ArrayList<String> getWord(Connection conn) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("SELECT kr_word  ");
        query.append("FROM  ");
        query.append("  WORDGAME  ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        ResultSet rs = ps.executeQuery();

        ArrayList<String> quizList = new ArrayList<>();

        while (rs.next()) {
            quizList.add(rs.getString("kr_word"));
        }
        rs.close();
        ps.close();

        return quizList;
    }




}
