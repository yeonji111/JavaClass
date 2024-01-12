package ch09_class.homepage;

import java.util.ArrayList;

public class BoardDB {

    private static ArrayList<Board> boardList = new ArrayList<>();

    // BoardDB 싱글톤 적용
    private BoardDB() {
        boardList.add(new Board(1," | 첫번째 게시글 제목 | ","","호빵맨"));
        boardList.add(new Board(2, " | 두번째 게시글 제목 | " ,"" , "식빵맨"));
        boardList.add(new Board(3," | 세번째 게시글 제목 | ","", "찐빵맨"));
    }

    private static BoardDB instance = new BoardDB();

    // instance에 대한 Getter 만들어주기
    public static BoardDB getInstance() {
        return instance;
    }


    // 글 목록 조회 메소드
    public static void showBoardList() {
        for (int i = 0; i < boardList.size(); i++) {
            System.out.println(boardList.get(i));
        }
    }

    // 글 제목, 내용 생성(저장) 메소드
    public static void boardUpload(String title, String contents){
        for(int i = 0; i < boardList.size(); i++){

            System.out.println((boardList.get(i).getBoardNo() + 1)
                    + title
                    + contents
            );

        }
    }
}
