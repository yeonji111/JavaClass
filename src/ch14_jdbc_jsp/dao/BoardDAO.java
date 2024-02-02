package ch14_jdbc_jsp.dao;

import ch14_jdbc_jsp.dto.BoardDTO;
import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {

    // 싱글톤 적용
    private BoardDAO(){}

    private static BoardDAO instance = new BoardDAO();

    public static BoardDAO getInstance() {
        return instance;
    }

    // 글 목록 보기 (SELECT)
    public List<BoardDTO> getBoardList(Connection conn) throws SQLException {
        // 쿼리문 작성
        StringBuffer query = new StringBuffer();
        query.append("SELECT                                         ");
        query.append("      mb.BO_NO                                 ");
        query.append("      ,mb.BO_TITLE                             ");
        query.append("      ,mb.BO_CONTENT                           ");
        query.append("      ,mb.VIEW_COUNT                           ");
        query.append("      ,mb.MEM_ID                               ");
        query.append("      ,m.MEM_NAME                              ");
        query.append("      ,TO_CHAR(mb.BO_DATE,'mm-dd' )AS BO_DATE  ");
        query.append("FROM                                           ");
        query.append("      MEMBERS m                                ");
        query.append("      ,MEM_BOARDS mb                           ");
        query.append("WHERE 1=1                                      ");
        query.append("    AND  m.MEM_ID = mb.MEM_ID                  ");
        query.append("    AND  mb.DEL_YN = 'N'                       ");
        query.append("    ORDER BY mb.BO_NO DESC                     ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        ResultSet rs = ps.executeQuery();

        List<BoardDTO> result = new ArrayList<>();

        while(rs.next()){
            BoardDTO board = new BoardDTO();
            board.setBoNo(rs.getInt("BO_NO"));
            board.setBoTitle(rs.getString("BO_TITLE"));
            board.setBoContent(rs.getString("BO_CONTENT"));
            board.setMemId(rs.getString("MEM_ID"));
            board.setMemName(rs.getString("MEM_NAME"));
            board.setBoDate(rs.getString("BO_DATE"));
            board.setViewCount(rs.getInt("VIEW_COUNT"));

            result.add(board);

        }
        ps.close();
        rs.close();

        return result;

    }

    // 글쓰기 (INSERT)
    public int writheBoard(Connection conn, BoardDTO board) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO               ");
        query.append(" MEM_BOARDS (             ");
        query.append("     BO_NO                ");
        query.append("      ,BO_TITLE           ");
        query.append("      ,BO_CONTENT         ");
        query.append("      ,MEM_ID             ");
        query.append("      ,BO_DATE            ");
        query.append("      ,VIEW_COUNT         ");
        query.append("      ) VALUES (          ");
        query.append("  seq_mem_boards.NEXTVAL  ");
        query.append("          , ?             ");
        query.append("          , ?             ");
        query.append("          , ?             ");
        query.append("          , SYSDATE       ");
        query.append("          , 0             ");
        query.append("  )                       ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setString(idx++, board.getBoTitle());
        ps.setString(idx++, board.getBoContent());
        ps.setString(idx++, board.getMemId());

        int result = ps.executeUpdate();

        ps.close();

        return result;
    }

    // 게시글 조회 (SELECT, WHERE)
    public BoardDTO readBoard(Connection conn, int no) throws SQLException {
//        StringBuffer query = new StringBuffer();
//        query.append("SELECT                     ");
//        query.append("       b.bo_title          ");
//        query.append("      , m.mem_name         ");
//        query.append("      , TO_CHAR(b.BO_DATE,'mm-dd' )AS BO_DATE          ");
//        query.append("      , b.bo_content       ");
//        query.append("FROM                       ");
//        query.append("  members m, mem_boards b  ");
//        query.append("WHERE 1=1                  ");
//        query.append("  AND b.bo_no = ?          ");
//        query.append("  AND m.mem_id = b.mem_id  ");

        StringBuffer query = new StringBuffer();
        query.append("SELECT                                         ");
        query.append("      mb.BO_NO                                 ");
        query.append("      ,mb.BO_TITLE                             ");
        query.append("      ,mb.BO_CONTENT                           ");
        query.append("      ,mb.MEM_ID                               ");
        query.append("      ,m.MEM_NAME                              ");
        query.append("      ,TO_CHAR(mb.BO_DATE,'mm-dd' )AS BO_DATE  ");
        query.append("FROM                                           ");
        query.append("      MEMBERS m                                ");
        query.append("      ,MEM_BOARDS mb                           ");
        query.append("WHERE 1=1                                      ");
        query.append("    AND  m.MEM_ID = mb.MEM_ID                  ");
        query.append("  AND mb.bo_no = ?                             ");
        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setInt(idx++, no);

        ResultSet rs = ps.executeQuery();

        BoardDTO result = new BoardDTO();

        if (rs.next()){
            result.setBoNo(rs.getInt("BO_NO"));
            result.setBoTitle(rs.getString("BO_TITLE"));
            result.setBoContent(rs.getString("BO_CONTENT"));
            result.setMemId(rs.getString("MEM_ID"));
            result.setMemName(rs.getString("MEM_NAME"));
            result.setBoDate(rs.getString("BO_DATE"));

        }

        ps.close();
        rs.close();

        return result;

        // 조회수 올리는 메소드
    } public int upViewCount(Connection conn, int no) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE                         ");
        query.append("  mem_boards                   ");
        query.append("SET                            ");
        query.append("  view_count = view_count + 1  ");
        query.append("WHERE                          ");
        query.append("  bo_no = ?                    ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int idx = 1;
        ps.setInt(idx++, no);

        int result = ps.executeUpdate();

        return result;
    }

    // 글 삭제 메소드 (UPDATE)
    public int deleteBoard(Connection conn, int no) throws SQLException {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE                         ");
        query.append("  mem_boards                   ");
        query.append("SET                            ");
        query.append("  del_yn = 'Y'                 ");
        query.append("WHERE                          ");
        query.append(" bo_no = ?                  ");

        PreparedStatement ps = conn.prepareStatement(query.toString());

        int  idx = 1;

        ps.setInt(idx++,no);

        int result = ps.executeUpdate();

        ps.close();

        return result;
    }


}