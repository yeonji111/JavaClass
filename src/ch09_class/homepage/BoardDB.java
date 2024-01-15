package ch09_class.homepage;

import java.util.ArrayList;

public class BoardDB {

    private static ArrayList<Board> boardList = new ArrayList<>();

    // BoardDB 싱글톤 적용
    private BoardDB() {
//        boardList.add(new Board(1," | 첫번째 게시글 제목 | ","","호빵맨"));
//        boardList.add(new Board(2, " | 두번째 게시글 제목 | " ,"" , "식빵맨"));
//        boardList.add(new Board(3," | 세번째 게시글 제목 | ","", "찐빵맨"));
        boardList.add(new Board(boardList.size() + 1, "첫 번째 게시글 제목 ", "일빠", "호빵맨"));
        boardList.add(new Board(boardList.size() + 1, "두 번째 게시글 제목 ", "이빠", "찐빵맨"));
        boardList.add(new Board(boardList.size() + 1, "세 번째 게시글 제목 ", "삼빠", "식빵맨"));
    }

    private static BoardDB instance = new BoardDB();

    // instance에 대한 Getter 만들어주기
    public static BoardDB getInstance() {
        return instance;
    }


    // 글 목록 조회 메소드
    public static void showBoardList() {
//        for (int i = 0; i < boardList.size(); i++) {
//            System.out.println(boardList.get(i));
//        }
        for(Board bo : boardList){
            System.out.println("[ " + bo.getBoardNo() + " | " + bo.getBoardTitle() + " | " + bo.getMemId() + " ]");
        }
    }

    // 글 제목, 내용 생성(저장) 메소드
    public static void wirteBoard(Board board){
        // 파라미터로 들어온 board 객체의 글번호가 0인 상태
        // 해당 board 객체의 글번호만 세팅해주면 된다.
        board.setBoardNo(boardList.size() + 1);
        boardList.add(board);
    }

    public void readBoard(int boardNo){
        for (int i = 0; i < boardList.size(); i++){
            if (boardList.get(i).getBoardNo() == boardNo){
                System.out.println("===================");
                System.out.println("제목: " + boardList.get(i).getBoardTitle() );
                System.out.println("작성자: " + boardList.get(i).getMemId() );
                System.out.println("--------------------");
                System.out.println(boardList.get(i).getBoardContent());
                System.out.println("===================");
                return;
            }
        }
    }
}
